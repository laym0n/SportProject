package com.example.boolreader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.boolreader.services.AuthService
import java.security.InvalidParameterException
import java.util.Objects

class Reg : AppCompatActivity() {
    private val authService: AuthService = AuthService.getInstance();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)

        val loginLabel: EditText = findViewById(R.id.editTextText)
        val passwordLabel: EditText = findViewById(R.id.editTextText2)
        val password2Label: EditText = findViewById(R.id.editTextText3)
        val buttonReg: Button = findViewById(R.id.button2)
        val buttonLog: Button = findViewById(R.id.button)

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
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun registry(login: String, pass: String, repeatPass: String) {
        if (!Objects.equals(pass, repeatPass)) {
            throw InvalidParameterException("Пароли не совпадают")
        }
        authService.auth(login, pass)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}