package com.example.waffle.model

import androidx.room.Entity

@Entity(tableName = "ownerships", primaryKeys = ["diaryId","userId"])
class DiaryOwnership (
    //foreign keys from users and diaries
    val userId : Int,

    val diaryId : Int
    )