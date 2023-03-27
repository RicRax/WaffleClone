package com.example.waffle.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @NonNull
    var username: String,

    @NonNull
    var email: String,

    @NonNull
    var password: String,

)
