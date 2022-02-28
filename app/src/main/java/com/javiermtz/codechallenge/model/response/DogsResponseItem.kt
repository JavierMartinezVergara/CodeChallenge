package com.javiermtz.codechallenge.model.response

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.javiermtz.util.Constants.TABLE_NAME
import kotlinx.serialization.Serializable

@Entity(tableName = TABLE_NAME)
@Serializable
data class DogsResponseItem(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val age: Int,
    val description: String,

    val dogName: String,
    val image: String
)
