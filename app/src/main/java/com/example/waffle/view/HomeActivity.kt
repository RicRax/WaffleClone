package com.example.waffle.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.waffle.databinding.ActivityHomeBinding
import com.example.waffle.model.repository.DbRepository
import com.example.waffle.presenter.HomeContract
import com.example.waffle.presenter.HomePresenter
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

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = HomePresenter(this, dbRepository)

        val userId = intent.getIntExtra("userId", 0)
        setupRecyclerView(userId)

    }

    private fun setupRecyclerView(id : Int){
        binding.booksRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = DiaryAdapter(presenter.getDiariesOfUser(id)) //get DiaryList from database using a dao
        }
    }
}



