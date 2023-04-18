package com.example.waffle.model

import android.graphics.Color
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Diary(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @NonNull
    val users: List<User>,

    @NonNull
    val color: Color
)

