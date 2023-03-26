package com.example.waffle.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.waffle.R
import com.example.waffle.databinding.ActivityRegisterBinding
import com.example.waffle.presenter.RegisterContract
import com.example.waffle.presenter.RegisterPresenter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity(), RegisterContract.View {

    lateinit var presenter: RegisterContract.Presenter

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_register)

        val usernameEditText = binding.registerNameEditText
        val emailEditText = binding.registerEmailEditText
        val passwordEditText = binding.registerPasswordEditText
        val registerButton = binding.registerButton

        presenter = RegisterPresenter(this)

        registerButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            presenter.register(username,email, password)
        }
    }

    override fun showErrorMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showSuccessMessage() {
        Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()
    }
}