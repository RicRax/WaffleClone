package com.example.waffle.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "ownerships", foreignKeys = arrayOf(ForeignKey(entity = User::class, parentColumns = arrayOf("id"), childColumns = arrayOf("userId"), onDelete = ForeignKey.CASCADE),
    ForeignKey(entity = Diary::class, parentColumns = arrayOf("id"), childColumns = arrayOf("diaryId"), onDelete = ForeignKey.CASCADE))
)
class DiaryOwnership (
    //foreign keys from users and diaries

    val userId : Int,


    val diaryId : Int
    )