package com.example.waffle.presenter

import com.example.waffle.model.Diary

interface RecyclerViewInterface {

    fun onItemClick(Position: Int, diary: Diary)

}