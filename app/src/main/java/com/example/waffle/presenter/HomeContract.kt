package com.example.waffle.presenter

import com.example.waffle.databinding.ActivityHomeBinding
import com.example.waffle.model.User

interface HomeContract {
    interface Presenter{
        fun getDiariesOfUser(user: User)
    }

    interface View{

    }
}