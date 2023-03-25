package com.example.waffle.presenter

interface RegisterContract {
    interface View {
        fun showErrorMessage(message: String)
        fun showSuccessMessage()
    }

    interface Presenter {
        fun register(username:String, email: String, password: String, )
    }
}