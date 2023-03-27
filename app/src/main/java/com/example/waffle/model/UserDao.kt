package com.example.waffle.model

import androidx.room.*

@Dao
interface UserDao  {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(User: User)

    @Query("SELECT * FROM users WHERE email = :email AND password = :password")
    fun getUser(email: String, password: String): User?
}