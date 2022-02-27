package com.javiermtz.codechallenge.di

import android.content.Context
import androidx.room.Room
import com.javiermtz.codechallenge.data.local.DogsDatabase
import com.javiermtz.util.Constants.DATABASE_DOGS_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import javax.inject.Singleton

@ExperimentalSerializationApi
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

  @Provides
  @Singleton
  fun provideDatabase(@ApplicationContext context: Context): DogsDatabase {
    return Room.databaseBuilder(
      context,
      DogsDatabase::class.java,
      DATABASE_DOGS_NAME)
      .fallbackToDestructiveMigration()
      .build()
  }

}
