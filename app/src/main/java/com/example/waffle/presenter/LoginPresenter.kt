package com.example.waffle.presenter

import com.example.waffle.model.UserDao
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val view: LoginContract.View, private val userDao: UserDao) :
    LoginContract.Presenter {

    override fun login(email: String, password: String) {
        val user = userDao.getUser(email, password)
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
