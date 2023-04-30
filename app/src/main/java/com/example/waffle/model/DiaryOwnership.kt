package com.example.waffle.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "ownerships", primaryKeys =  ["userId","diaryId"])
class DiaryOwnership (
    //foreign keys from users and diaries

    val userId : Int,

    val diaryId : Int
    )