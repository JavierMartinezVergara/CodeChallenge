package com.javiermtz.codechallenge.data.repository

import com.javiermtz.codechallenge.data.api.DogsApi
import com.javiermtz.codechallenge.model.response.DogsResponse
import com.javiermtz.codechallenge.model.response.DogsResponseItem
import com.javiermtz.util.ResultWrapper
import com.javiermtz.util.ResultWrapper.GenericError
import com.javiermtz.util.ResultWrapper.Success
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

class DogsService @Inject constructor(
  private val apiService : DogsApi
) {


  suspend fun getDogsFromApi() : ResultWrapper<List<DogsResponseItem>>{
    return try {
      withContext(Dispatchers.IO){
        val response = apiService.getDogs()
        if(response.isSuccessful){
          val body = response.body()
          ResultWrapper.Success(body!!)
        } else {
          GenericError("")
        }
      }
    }catch (e : Exception){
      GenericError(e.message)
    }

  }
}
