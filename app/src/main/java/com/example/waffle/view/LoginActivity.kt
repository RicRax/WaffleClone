package com.example.waffle.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.waffle.R
import com.example.waffle.databinding.ActivityLoginBinding
import com.example.waffle.model.UserDao
import com.example.waffle.model.data.AppDatabase
import com.example.waffle.model.repository.DbRepository
import com.example.waffle.presenter.LoginContract
import com.example.waffle.presenter.LoginPresenter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity(), LoginContract.View {

    lateinit var presenter: LoginPresenter

    private lateinit var binding: ActivityLoginBinding

 //   private lateinit var navController: NavController

    @Inject
    lateinit var dbRepository: DbRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_login)

        val emailEditText = binding.emailEditText
        val passwordEditText = binding.passwordEditText
        val loginButton = binding.loginButton

        presenter = LoginPresenter(this,dbRepository)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            presenter.login(email, password)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showError(errorMessage: String?) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }

    override fun navigateToHomeScreen() {
        //val intent = Intent(this, HomeActivity::class.java)
        //startActivity(intent)
        //finish()
    }

}