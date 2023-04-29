package com.example.waffle.presenter

import com.example.waffle.model.repository.DbRepository
import javax.inject.Inject


class addDiaryDialogPresenter @Inject constructor(private val dbRepository: DbRepository) {
    fun addDiary(userId : Int, nameDiary : String) = dbRepository.addDiary(userId, nameDiary)

}