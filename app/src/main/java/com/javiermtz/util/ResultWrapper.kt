package com.javiermtz.util

import com.javiermtz.codechallenge.model.response.DogsResponse
import retrofit2.Response

sealed class ResultWrapper<out T> {
  data class Success<out T>(val dataResponse: T): ResultWrapper<T>()
  data class GenericError(val error: String? = null): ResultWrapper<Nothing>()
  object Loading: ResultWrapper<Nothing>()
}
