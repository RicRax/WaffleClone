package com.example.waffle.presenter

import com.example.waffle.model.repository.DbRepository
import javax.inject.Inject

class DiaryViewPresenter @Inject constructor(private val dbRepository: DbRepository){

    fun updateDiary(newText: String?, diaryId: Int)
    {
        dbRepository.updateDiaryText(newText,diaryId)
    }
}