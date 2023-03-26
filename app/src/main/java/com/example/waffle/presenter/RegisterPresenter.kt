package com.example.waffle.presenter

import javax.inject.Inject

class RegisterPresenter @Inject constructor(private val view: RegisterContract.View) :
    RegisterContract.Presenter {

    override fun register(username: String, email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            view.showErrorMessage("Please enter both email and password.")
            return
        }

        view.showSuccessMessage()
    }
}