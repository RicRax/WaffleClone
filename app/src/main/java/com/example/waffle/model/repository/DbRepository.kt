package com.example.waffle.model.repository

import com.example.waffle.model.DiaryDao
import com.example.waffle.model.User
import com.example.waffle.model.UserDao
import javax.inject.Inject

class DbRepository
@Inject constructor(
    private val  userDao: UserDao,
    private val  diaryDao: DiaryDao
) {

    fun saveUser(username: String, email : String, password: String ) = userDao.insertUser(User(0,username, email, password))
    fun getUser(email : String, password: String) = userDao.getUser(email,password)

    // fun getDiariesOfUser(user: User) CREATE OWNERSHIP DAO AND USE IT HERE TO GET ALL DIARIES OF A GIVEN USER

}