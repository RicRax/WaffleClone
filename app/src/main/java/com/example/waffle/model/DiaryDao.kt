package com.example.waffle.model

import androidx.room.*
import com.example.waffle.model.Diary
import com.example.waffle.model.User

@Dao
interface DiaryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDiary(Diary: Diary)

    @Query("SELECT * FROM diaries WHERE id = :id")
    fun getDiary(id : Int): Diary?

}










