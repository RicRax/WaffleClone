package com.example.waffle.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.waffle.R
import com.example.waffle.databinding.FragmentViewdiaryBinding
import com.example.waffle.model.repository.DbRepository
import com.example.waffle.presenter.DiaryViewPresenter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint
import org.w3c.dom.Text
import javax.inject.Inject

@AndroidEntryPoint
class DiaryViewFragment : Fragment(R.layout.fragment_viewdiary) {

    @Inject
    lateinit var dbRepository: DbRepository

    private lateinit var presenter: DiaryViewPresenter

    private var diaryText : String? = null
    private var diaryName : String? = null

    private lateinit var editText: EditText
    private lateinit var titleDiary: TextView



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_viewdiary,container,false)

        editText = view.findViewById<EditText>(R.id.diaryText)
        titleDiary = view.findViewById<TextView>(R.id.nameDiary)

        presenter = DiaryViewPresenter(dbRepository)

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        diaryName = requireArguments().getString("nameDiary")
        diaryText = requireArguments().getString("textDiary")


        requireActivity().findViewById<FloatingActionButton>(R.id.addDiary).hide()
        titleDiary.text = diaryName


        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                presenter.updateDiary(s.toString(),requireArguments().getInt("diaryId"))
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
       /*if(diaryText !=requireArguments().getString("textDiary")  )
       {
           presenter.updateDiary(diaryText,requireArguments().getInt("diaryId"))
       }

        */
    }
}