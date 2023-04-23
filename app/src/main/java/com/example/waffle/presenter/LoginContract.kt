package com.example.waffle.presenter

import com.example.waffle.model.User

interface LoginContract {
    interface View {
        fun showError(errorMessage: String?)
        fun navigateToHomeScreen(user: User)
    }

    interface Presenter {
        fun login(email: String, password: String)
        fun onDestroy()
    }
}