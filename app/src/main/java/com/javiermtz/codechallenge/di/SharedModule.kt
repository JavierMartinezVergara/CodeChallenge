package com.javiermtz.codechallenge.di

import android.content.Context
import android.content.SharedPreferences
import com.javiermtz.codechallenge.BuildConfig
import com.javiermtz.codechallenge.data.api.DogsApi
import com.javiermtz.util.Constants.DOGS_URL
import com.javiermtz.util.Constants.SHARED_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedModule {

  @Provides
  @Singleton
  fun provideSharedPreferences(
    @ApplicationContext context: Context
  ): SharedPreferences {
    return context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)
  }
}
