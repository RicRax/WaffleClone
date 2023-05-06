package com.example.waffle.view

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.waffle.R
import com.example.waffle.databinding.ActivityHomeBinding
import com.example.waffle.model.Diary
import com.example.waffle.model.repository.DbRepository
import com.example.waffle.presenter.HomeContract
import com.example.waffle.presenter.HomePresenter
import com.example.waffle.presenter.RecyclerViewInterface
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class HomeActivity : AppCompatActivity(), HomeContract.View, RecyclerViewInterface {

    private lateinit var presenter: HomePresenter

    private lateinit var binding: ActivityHomeBinding

    private lateinit var diaryAdapter: DiaryAdapter

    @Inject
    lateinit var dbRepository: DbRepository

    private var userId: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        presenter = HomePresenter(this, dbRepository)

        userId = intent.getIntExtra("userId", 99)//NOT WORKING

        diaryAdapter = DiaryAdapter(presenter.getDiariesOfUser(userId), this)

        binding.booksRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = diaryAdapter
        }

        binding.addDiary.setOnClickListener {
            showEditTextDialog()
        }

    }

    override fun onResume() {
        super.onResume()
        diaryAdapter.update(presenter.getDiariesOfUser(userId))
    }


    private fun showEditTextDialog() {

        val builder = AlertDialog.Builder(this)

        val inflater = layoutInflater

        val dialogLayout = inflater.inflate(R.layout.dialog_newdiary, null)


        val nameDiary = dialogLayout.findViewById<EditText>(R.id.nameDiary)

        with(builder) {

            setPositiveButton(
                R.string.add,
                DialogInterface.OnClickListener { dialog, id ->
                    presenter.addDiary(userId, nameDiary.text.toString())
                    diaryAdapter.update(presenter.getDiariesOfUser(userId))
                })

            setNegativeButton(
                R.string.cancel,
                DialogInterface.OnClickListener { dialog, id ->

                })

            setView(dialogLayout)
            show()
        }
    }

    override fun onItemClick(Position: Int, diary: Diary) {
        //start fragment
        val diaryBundle = Bundle()

        val intentViewDiary = Intent(this@HomeActivity, DiaryViewActivity::class.java)
        intentViewDiary.putExtra("textDiary", diary.text)
        intentViewDiary.putExtra("nameDiary", diary.name)
        intentViewDiary.putExtra("diaryId", diary.id)

        startActivity(intentViewDiary)
    }
}


