package com.example.waffle.presenter

import com.example.waffle.databinding.ActivityHomeBinding
import com.example.waffle.model.Diary
import com.example.waffle.model.User

interface HomeContract {
    interface Presenter{
        fun getDiariesOfUser(userId: Int) : List<Diary>

        fun addDiary(userId : Int, nameDiary : String)


    }

    interface View{

    }
}