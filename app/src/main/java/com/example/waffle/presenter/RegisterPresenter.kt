package com.example.waffle.presenter

import com.example.waffle.model.User
import com.example.waffle.model.repository.DbRepository
import javax.inject.Inject

class RegisterPresenter @Inject constructor(
    private val view: RegisterContract.View,
    private val DbRepository: DbRepository
) :
    RegisterContract.Presenter {

    override fun register(username: String, email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            view.showErrorMessage("Please enter both email and password.")
            return
        }

        DbRepository.saveUser(username,email, password)



        view.showSuccessMessage()
    }
}