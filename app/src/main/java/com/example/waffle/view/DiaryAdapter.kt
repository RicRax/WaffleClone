package com.example.waffle.view

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.waffle.R
import com.example.waffle.databinding.ItemDiaryBinding
import com.example.waffle.model.Diary

class DiaryAdapter(val diaryList: List<Diary>, val listener: (Diary, Int) -> Unit) :
    RecyclerView.Adapter<DiaryAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        val  binding = ItemDiaryBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        holder.bindItem(diaryList[position])
    }

    override fun getItemCount(): Int {
        return diaryList.size
    }

    class MyViewHolder(var itemDiaryBinding: ItemDiaryBinding) :
        RecyclerView.ViewHolder(itemDiaryBinding.root) {

        fun bindItem(diary: Diary) {
            itemDiaryBinding.name.setText(diary.name)
            itemDiaryBinding.image.setImageResource(R.drawable.book)
        }
    }

}