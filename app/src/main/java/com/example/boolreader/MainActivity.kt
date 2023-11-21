package com.example.boolreader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.boolreader.services.AuthService

class MainActivity : AppCompatActivity() {
    private val authService: AuthService = AuthService.getInstance();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginLabel: EditText = findViewById(R.id.editTextText)
        val passwordLabel: EditText = findViewById(R.id.editTextText2)
        val buttonLog: Button = findViewById(R.id.button2)
        val buttonReg: Button = findViewById(R.id.button)

        buttonLog.setOnClickListener {
            var login = loginLabel.text.toString()
            var pass = passwordLabel.text.toString()
            try {
                auth(login, pass)
            } catch (ex: Exception) {
                Toast.makeText(this, ex.message, Toast.LENGTH_SHORT).show();
            }
        }
        buttonReg.setOnClickListener {
            val intent = Intent(this, Reg::class.java)
            startActivity(intent)
        }
    }

    fun auth(login: String, pass: String) {
        authService.auth(login, pass)
        Toast.makeText(this, "Вы успешло зашли как $login", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainPage::class.java)
        startActivity(intent)
    }
}
