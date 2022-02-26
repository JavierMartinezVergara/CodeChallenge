package com.javiermtz.codechallenge.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javiermtz.codechallenge.data.repository.RepositoryDogs
import com.javiermtz.codechallenge.model.response.DogsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogsViewModel @Inject constructor(
  repository : RepositoryDogs
) : ViewModel(){

  val data : LiveData<DogsResponse> = repository.getDogs()


}
