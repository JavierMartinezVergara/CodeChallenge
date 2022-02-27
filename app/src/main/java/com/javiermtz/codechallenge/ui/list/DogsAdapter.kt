package com.javiermtz.codechallenge.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.javiermtz.codechallenge.databinding.DogsItemBinding
import com.javiermtz.codechallenge.model.response.DogsResponseItem
import com.javiermtz.codechallenge.ui.list.DogsAdapter.ViewHolder

class DogsAdapter(
  private val onClickListener: OnClickListener,
) :
  ListAdapter<DogsResponseItem, ViewHolder>(MyDiffUtil) {

  companion object MyDiffUtil : DiffUtil.ItemCallback<DogsResponseItem>() {
    override fun areItemsTheSame(oldItem: DogsResponseItem, newItem: DogsResponseItem): Boolean {
      return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: DogsResponseItem, newItem: DogsResponseItem): Boolean {
      return oldItem.dogName == newItem.dogName
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(
      DogsItemBinding.inflate(
        LayoutInflater.from(parent.context), parent, false
      )
    )
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val result = getItem(position)
    holder.itemView.setOnClickListener {
      onClickListener.onClick(result)
    }
    holder.bind(result)
  }

  inner class ViewHolder(private val binding: DogsItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(dogsResponseItem: DogsResponseItem?) {
      binding.nameDog.text = dogsResponseItem?.dogName
      binding.descriptionDog.text = dogsResponseItem?.description
      binding.ageDog.text = "Almost ${dogsResponseItem?.age} years"
        Glide.with(binding.imageDog)
          .load(dogsResponseItem?.image)
          .into(binding.imageDog)

    }
  }

  class OnClickListener(val clickListener: (result: DogsResponseItem) -> Unit) {
    fun onClick(result: DogsResponseItem) = clickListener(result)
  }

}




