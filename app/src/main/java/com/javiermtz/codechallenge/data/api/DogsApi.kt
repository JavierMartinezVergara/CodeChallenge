package com.javiermtz.codechallenge.data.api

import com.javiermtz.codechallenge.model.response.DogsResponse
import retrofit2.Response
import retrofit2.http.GET

interface DogsApi {

  @GET("api/945366962796773376")
  suspend fun getDogs() : Response<DogsResponse>
}
