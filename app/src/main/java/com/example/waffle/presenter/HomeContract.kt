package com.example.waffle.presenter

import com.example.waffle.databinding.ActivityHomeBinding

interface HomeContract {
    interface Presenter{
        fun setupRecyclerView(binding: ActivityHomeBinding){
        }
    }

    interface View{

    }
}