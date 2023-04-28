package com.example.waffle.presenter

import com.example.waffle.databinding.ActivityHomeBinding
import com.example.waffle.model.Diary
import com.example.waffle.model.User

interface HomeContract {
    interface Presenter{
        fun addDiary (userId: Int): Unit

        fun getDiariesOfUser(userId: Int) : List<Diary>

    }

    interface View{

    }
}