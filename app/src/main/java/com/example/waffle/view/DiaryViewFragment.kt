package com.example.waffle.view

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.waffle.R
import com.example.waffle.databinding.FragmentViewdiaryBinding
import com.example.waffle.model.Diary

class DiaryViewFragment : Fragment(R.layout.fragment_viewdiary) {

    private lateinit var binding : FragmentViewdiaryBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_viewdiary,container,false)

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val diaryName = requireArguments().getString("nameDiary")
        val diaryText = requireArguments().getString("textDiary")

        binding.diaryText.setText(diaryText)
        binding.nameDiary.text = diaryName
        //add dataBinding
    }
}