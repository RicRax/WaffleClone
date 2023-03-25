package com.example.waffle.presenter

interface LoginContract {
    interface View {
        fun showError(errorMessage: String?)
        fun navigateToHomeScreen()
    }

    interface Presenter {
        fun login(email: String, password: String)
        fun onDestroy()
    }
}