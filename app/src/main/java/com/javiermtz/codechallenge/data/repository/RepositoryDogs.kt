package com.javiermtz.codechallenge.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.javiermtz.codechallenge.data.local.DogsDatabase
import com.javiermtz.codechallenge.model.response.DogsResponse
import com.javiermtz.codechallenge.model.response.DogsResponseItem
import com.javiermtz.util.ResultWrapper.GenericError
import com.javiermtz.util.ResultWrapper.Loading
import com.javiermtz.util.ResultWrapper.Success
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryDogs @Inject constructor(
  private val remoteDogs: DogsService,
  private val databaseDogs : DogsDatabase
) {

  fun getDogs(): LiveData<List<DogsResponseItem>> {

    return liveData {
      when (val data = remoteDogs.getDogsFromApi()) {
        is GenericError -> "Error"
        Loading -> "Data"
        is Success -> {
          withContext(Dispatchers.IO){
            databaseDogs.dogsDao().addImages(data.dataResponse)
            emit(databaseDogs.dogsDao().getAllImages())
          }

        }
      }
    }
  }
}
