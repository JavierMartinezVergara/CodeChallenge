package com.javiermtz.codechallenge.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.javiermtz.codechallenge.data.repository.RepositoryDogs
import com.javiermtz.codechallenge.model.response.DogsResponseItem
import com.javiermtz.util.ResultWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DogsViewModel @Inject constructor(
  repository : RepositoryDogs
) : ViewModel(){

  val data : LiveData<ResultWrapper<List<DogsResponseItem>>> = repository.getDogs()


}
