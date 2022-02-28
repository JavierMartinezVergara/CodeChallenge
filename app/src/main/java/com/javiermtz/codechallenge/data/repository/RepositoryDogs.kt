package com.javiermtz.codechallenge.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.javiermtz.codechallenge.data.local.DogsDatabase
import com.javiermtz.codechallenge.data.local.shared.SharedPreferencesDogs
import com.javiermtz.codechallenge.model.response.DogsResponseItem
import com.javiermtz.util.ResultWrapper
import com.javiermtz.util.ResultWrapper.GenericError
import com.javiermtz.util.ResultWrapper.Loading
import com.javiermtz.util.ResultWrapper.Success
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryDogs @Inject constructor(
  private val remoteDogs: DogsService,
  private val databaseDogs: DogsDatabase,
  private val shared: SharedPreferencesDogs
) {

  fun getDogs(): LiveData<ResultWrapper<List<DogsResponseItem>>> {

    return liveData {
      if (shared.isFromDatabase()) {
        withContext(Dispatchers.IO){
          emit(ResultWrapper.Loading(false))
          emit(ResultWrapper.Success(databaseDogs.dogsDao().getAllImages()))
        }
      } else when (val data = remoteDogs.getDogsFromApi()) {
        is GenericError -> if (shared.isFromDatabase()) {
          emit(ResultWrapper.Loading(false))
          emit(ResultWrapper.Success(databaseDogs.dogsDao().getAllImages()))
        } else {
          emit(ResultWrapper.Loading(false))
          emit(ResultWrapper.GenericError("Error"))
        }
        is Loading -> {
          emit(ResultWrapper.Loading())
        }
        is Success -> {
          emit(ResultWrapper.Loading(false))
          withContext(Dispatchers.IO) {
            databaseDogs.dogsDao().addImages(data.dataResponse)
            shared.setFromDatabase(true)
            emit(ResultWrapper.Success(data.dataResponse))
          }
        }
      }
    }
  }
}
