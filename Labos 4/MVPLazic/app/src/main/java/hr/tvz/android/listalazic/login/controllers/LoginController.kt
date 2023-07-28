package hr.tvz.android.listalazic.login.controllers

import hr.tvz.android.listalazic.login.model.User
import hr.tvz.android.listalazic.login.view.ILoginView

class LoginController(private val loginView : ILoginView) : ILoginController {

    override fun onLogin(email: String, password: String) {
        val user = User(email, password)
        val loginCode = user.isValid()
        when (loginCode){
            0 -> loginView.onLoginError("Please enter email")
            1 -> loginView.onLoginError("Please enter valid email")
            2 -> loginView.onLoginError("Please enter password")
            3 -> loginView.onLoginError("Please enter valid password (too weak)")
            else -> loginView.onLoginError("Login Successful")

        }
    }
}