package com.example.waffle.presenter

import com.example.waffle.model.UserDao
import com.example.waffle.model.repository.DbRepository
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val view: LoginContract.View, private val DbRepository: DbRepository) :
    LoginContract.Presenter {

    override fun login(email: String, password: String) {
        val user = DbRepository.getUser(email, password)
        if (user != null) {
            view.navigateToHomeScreen()
        } else {
            view.showError("Invalid email or password")
        }
    }

    override fun onDestroy() {
        // Any necessary clean-up logic goes here
    }
}
