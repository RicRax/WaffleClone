package com.example.waffle.model

import androidx.room.*

@Dao
interface DiaryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDiary(Diary: Diary) : Long

    @Query("SELECT * FROM diaries WHERE id = :id")
    fun getDiary(id : Int): Diary?

    @Query("UPDATE diaries SET text = :newText WHERE id = :diaryId")
    fun updateDiaryText(newText: String?, diaryId: Int)

}










