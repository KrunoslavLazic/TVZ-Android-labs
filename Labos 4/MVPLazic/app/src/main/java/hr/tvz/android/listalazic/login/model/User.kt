package hr.tvz.android.listalazic.login.model

import android.util.Patterns

class User(private val email:String, private val password: String) : IUser {

    override fun isValid(): Int {
        return when {
            email.isEmpty() -> 0
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> 1
            password.isEmpty() -> 2
            password.length <=6 -> 3
            else -> -1
        }
    }
}