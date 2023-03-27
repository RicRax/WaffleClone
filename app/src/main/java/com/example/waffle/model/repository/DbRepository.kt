package com.example.waffle.model.repository

import com.example.waffle.model.User
import com.example.waffle.model.UserDao
import javax.inject.Inject

class DbRepository
@Inject constructor(
    private val dao: UserDao,
) {

    fun saveUser(username: String, email : String, password: String ) = dao.insertUser(User(0,username, email, password))
    fun getUser(email : String, password: String) = dao.getUser(email,password)

}