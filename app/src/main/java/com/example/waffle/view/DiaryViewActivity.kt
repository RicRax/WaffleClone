package com.example.waffle.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.waffle.R
import com.example.waffle.databinding.ActivityViewdiaryBinding
import com.example.waffle.model.repository.DbRepository
import com.example.waffle.presenter.DiaryViewPresenter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DiaryViewActivity : AppCompatActivity() {

    @Inject
    lateinit var dbRepository: DbRepository

    private lateinit var presenter: DiaryViewPresenter

    private lateinit var binding: ActivityViewdiaryBinding

    private var diaryText: String? = null
    private var diaryName: String? = null

    private lateinit var editText: EditText
    private lateinit var titleDiary: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_viewdiary)

        editText = binding.diaryText
        titleDiary = binding.nameDiary

        presenter = DiaryViewPresenter(dbRepository)

        diaryName = intent.getStringExtra("nameDiary")
        diaryText = intent.getStringExtra("textDiary")

        editText.setText(diaryText)
        titleDiary.text = diaryName

        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                presenter.updateDiary(s.toString(), intent.getIntExtra("diaryId", 99))
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        finish()
        /*if(diaryText !=requireArguments().getString("textDiary")  )
        {
            presenter.updateDiary(diaryText,requireArguments().getInt("diaryId"))
        }

         */
    }
}