package com.example.waffle.model.repository

import com.example.waffle.model.DiaryDao
import com.example.waffle.model.DiaryOwnership
import com.example.waffle.model.User
import com.example.waffle.model.UserDao
import com.example.waffle.model.data.OwnershipDao
import javax.inject.Inject

class DbRepository
@Inject constructor(
    private val  userDao: UserDao,
    private val  diaryDao: DiaryDao,
    private val  ownershipDao: OwnershipDao
) {

    fun saveUser(username: String, email : String, password: String ) = userDao.insertUser(User(0,username, email, password))
    fun getUser(email : String, password: String) = userDao.getUser(email,password)
    fun getDiariesOfUser(userId: Int) = ownershipDao.getAllDiariesIdOfUser(userId)

}