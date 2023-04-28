package com.example.waffle.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.waffle.model.Diary
import com.example.waffle.model.User

@Dao
interface OwnershipDao {
    @Insert
    fun insertOwnership(userId: Int, diaryId:Int)

    @Query(
        "SELECT D.id, D.color, D.name FROM ownerships O, diaries D WHERE O.userId = :userId")//fix query


    //join to diary table to return diaries
    fun getAllDiariesIdOfUser(userId:Int): List<Diary>

}