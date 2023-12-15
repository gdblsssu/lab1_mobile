package com.example.lab0.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "cat_table")
data class Cat(@SerializedName("name")
               var name: String = "",
               @SerializedName("width")
               var width: Int = 0,
               @SerializedName("id")
               @PrimaryKey
               var id: String = "",
               @SerializedName("url")
               var url: String = "",
               @SerializedName("height")
               var height: Int = 0)