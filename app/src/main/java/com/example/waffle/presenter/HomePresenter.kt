package com.example.waffle.presenter

import com.example.waffle.model.Diary
import com.example.waffle.model.User
import com.example.waffle.model.repository.DbRepository
import javax.inject.Inject

class HomePresenter @Inject constructor(private val view: HomeContract.View, private val DbRepository: DbRepository) : HomeContract.Presenter{
    override fun getDiariesOfUser(userId: Int) : List<Diary>
    {
      return DbRepository.getDiariesOfUser(userId)
    }
}
