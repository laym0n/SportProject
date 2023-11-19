package com.example.boolreader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

var login: String = "Victor"
var password: String = "123"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginLabel: EditText = findViewById(R.id.editTextText)
        val passwordLabel: EditText = findViewById(R.id.editTextText2)
        val buttonLog: Button = findViewById(R.id.button2)
        val buttonReg: Button = findViewById(R.id.button)

        buttonLog.setOnClickListener {
            var text_log = loginLabel.text.toString()
            var text_pass = passwordLabel.text.toString()
            if (text_log != "" && login == text_log && text_pass != "" && password == text_pass) {
                Toast.makeText(this, "Вы успешло зашли как $text_log", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Вы ввели неправильный логин или пароль", Toast.LENGTH_SHORT)
                    .show();
            }
        }
        buttonReg.setOnClickListener {
            val intent = Intent(this, Reg::class.java)
            startActivity(intent)
        }
    }
}

fun change(Log: String, Pass: String) {
    login = Log
    password = Pass
}