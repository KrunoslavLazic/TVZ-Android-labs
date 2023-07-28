package hr.tvz.android.listalazic.login

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import hr.tvz.android.listalazic.MainActivity
import hr.tvz.android.listalazic.R
import hr.tvz.android.listalazic.login.controllers.LoginController
import hr.tvz.android.listalazic.login.view.ILoginView

class LoginActivity : AppCompatActivity(),ILoginView {

    private lateinit var email : EditText
    private lateinit var password : EditText
    private lateinit var loginbtn : Button

    private lateinit var loginController : LoginController

    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        loginbtn = findViewById(R.id.loginButton)
        loginController = LoginController(this)

        loginbtn.setOnClickListener{
            loginController.onLogin(
                email.text.toString().trim(),
                password.text.toString().trim()
            )

        }
    }


    override fun onLoginError(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, MainActivity::class.java))
    }
    override fun onLoginSuccess(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()

    }
}