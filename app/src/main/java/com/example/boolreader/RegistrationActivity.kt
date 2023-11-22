package com.example.boolreader

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.boolreader.services.AuthService
import java.security.InvalidParameterException
import java.util.Objects

class RegistrationActivity : AppCompatActivity() {
    private val authService: AuthService = AuthService.getInstance();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val loginLabel: EditText = findViewById(R.id.editTextText)
        val passwordLabel: EditText = findViewById(R.id.editTextText2)
        val password2Label: EditText = findViewById(R.id.editTextText3)
        val buttonReg: Button = findViewById(R.id.createAccountBtn)
        val buttonLog: Button = findViewById(R.id.backToLoginPage)

        buttonReg.setOnClickListener {
            var login = loginLabel.text.toString()
            var pass = passwordLabel.text.toString()
            var repeatPass = password2Label.text.toString()
            try {
                registry(login, pass, repeatPass)
            } catch (ex: Exception) {
                Toast.makeText(this, ex.message, Toast.LENGTH_SHORT).show();
            }
        }
        buttonLog.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }
    }

    private fun registry(login: String, pass: String, repeatPass: String) {
        if (!Objects.equals(pass, repeatPass)) {
            throw InvalidParameterException("Пароли не совпадают")
        }
        authService.register(login, pass)
        val intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)
    }
}