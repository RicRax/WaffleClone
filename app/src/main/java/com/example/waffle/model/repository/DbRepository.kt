package com.example.waffle.model.repository

import com.example.waffle.model.*
import javax.inject.Inject

class DbRepository
@Inject constructor(
    private val  userDao: UserDao,
    private val  diaryDao: DiaryDao,
    private val  ownershipDao: OwnershipDao,
) {
    fun saveUser(username: String, email : String, password: String ) = userDao.insertUser(User(0,username, email, password))
    fun getUser(email : String, password: String) = userDao.getUser(email,password)
    fun getDiariesOfUser(userId: Int) = ownershipDao.getAllDiariesIdOfUser(userId)
    fun addDiary(userId: Int,nameDiary: String){
        val newDiary = Diary(0,"black",nameDiary,null)
        val diaryId = diaryDao.insertDiary(newDiary)

        ownershipDao.insertOwnership(DiaryOwnership(userId,diaryId.toInt()))
    }
}