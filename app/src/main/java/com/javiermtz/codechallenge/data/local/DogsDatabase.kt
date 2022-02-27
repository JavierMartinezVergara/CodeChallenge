package com.javiermtz.codechallenge.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.javiermtz.codechallenge.data.local.dao.DogsDao
import com.javiermtz.codechallenge.model.response.DogsResponseItem

@Database(entities = [DogsResponseItem::class], version = 2)
abstract class DogsDatabase : RoomDatabase() {

    abstract fun dogsDao() : DogsDao

}
