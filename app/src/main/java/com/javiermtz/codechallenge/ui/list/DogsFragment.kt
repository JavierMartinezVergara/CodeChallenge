package com.javiermtz.codechallenge.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.javiermtz.codechallenge.R
import com.javiermtz.codechallenge.databinding.FragmentDogsBinding
import com.javiermtz.codechallenge.ui.DogsViewModel
import com.javiermtz.codechallenge.ui.list.DogsAdapter.OnClickListener
import com.javiermtz.util.ResultWrapper.GenericError
import com.javiermtz.util.ResultWrapper.Loading
import com.javiermtz.util.ResultWrapper.Success
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DogsFragment : Fragment() {
  private lateinit var binding: FragmentDogsBinding
  private val viewModel: DogsViewModel by viewModels()
  private lateinit var adapter: DogsAdapter

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentDogsBinding.inflate(layoutInflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    observers()
    adapter = DogsAdapter(OnClickListener { dataCharacter ->

    })
    binding.recyclerViewCharacters.adapter = adapter

  }

  private fun observers() {
    viewModel.data.observe(viewLifecycleOwner, {
      when(it){
        is GenericError -> {
          if (!it.error.isNullOrBlank()) {
            binding.imgError.visibility = View.VISIBLE
            binding.errorText.text = requireContext().getString(R.string.error, it)
          } else {
            binding.imgError.visibility = View.GONE
            binding.errorText.visibility = View.GONE
          }
        }
        is Loading -> if(it.loading){
          binding.imgLoading.visibility = View.VISIBLE
          binding.imgError.visibility = View.GONE
        }
        else binding.imgLoading.visibility = View.GONE
        is Success -> {
          binding.imgLoading.visibility = View.GONE
          adapter.submitList(it.dataResponse)
        }
      }

    })
  }
}
