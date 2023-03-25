package com.example.waffle.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    var email: String,
    var password: String
)
