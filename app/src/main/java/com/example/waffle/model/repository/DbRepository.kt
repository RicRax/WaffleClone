package com.example.waffle.model.repository

import com.example.waffle.model.User
import com.example.waffle.model.UserDao
import javax.inject.Inject

class DbRepository
@Inject constructor(
    private val dao: UserDao,
) {

    fun saveUser(user: User) = dao.insertUser(user)
    fun getUser(user: User) = dao.getUser(user.email,user.password)

}