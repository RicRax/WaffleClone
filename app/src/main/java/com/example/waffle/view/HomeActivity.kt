package com.example.waffle.view

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.waffle.R
import com.example.waffle.databinding.ActivityHomeBinding
import com.example.waffle.model.repository.DbRepository
import com.example.waffle.presenter.HomeContract
import com.example.waffle.presenter.HomePresenter
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class HomeActivity : AppCompatActivity(), HomeContract.View {

    private lateinit var presenter: HomePresenter

    private lateinit var binding: ActivityHomeBinding

    @Inject
    lateinit var dbRepository: DbRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        presenter = HomePresenter(this, dbRepository)

        val userId = intent.getIntExtra("userId", 0)
        setupRecyclerView(userId)

        binding.addDiary.setOnClickListener {
            showEditTextDialog()
        }

    }

    private fun setupRecyclerView(id: Int) {
        binding.booksRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter =
                DiaryAdapter(presenter.getDiariesOfUser(id)) //get DiaryList from database using a dao
        }
    }


    private fun showEditTextDialog(){

        val builder = AlertDialog.Builder(this)

        val inflater = layoutInflater

        val dialogLayout = inflater.inflate(R.layout.dialog_newdiary, null)

        val nameDiary = dialogLayout.findViewById<EditText>(R.id.nameDiary)

        with(builder) {

            setPositiveButton(
                R.string.add,
                DialogInterface.OnClickListener { dialog, id ->
                    presenter.addDiary(0, nameDiary.text.toString())
                })

            setNegativeButton(
                R.string.cancel,
                DialogInterface.OnClickListener { dialog, id ->

                })

            setView(dialogLayout)
            show()
        }
    }
}


