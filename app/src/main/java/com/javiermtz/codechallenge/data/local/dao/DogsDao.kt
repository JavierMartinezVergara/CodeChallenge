package com.javiermtz.codechallenge.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.javiermtz.codechallenge.model.response.DogsResponseItem
import com.javiermtz.util.Constants.TABLE_NAME

@Dao
interface DogsDao {

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllImages(): List<DogsResponseItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addImages(dogs : List<DogsResponseItem>)

}
