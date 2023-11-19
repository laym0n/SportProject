package com.example.boolreader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Reg : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)

        val loginLabel: EditText = findViewById(R.id.editTextText)
        val passwordLabel: EditText = findViewById(R.id.editTextText2)
        val password2Label: EditText = findViewById(R.id.editTextText3)
        val buttonReg: Button = findViewById(R.id.button2)
        val buttonLog: Button = findViewById(R.id.button)

        buttonReg.setOnClickListener {
            var text_log = loginLabel.text.toString()
            var text_pass = passwordLabel.text.toString()
            var text_pass2 = password2Label.text.toString()
            if (text_log != "" && text_pass != "") {
                if (text_pass2 == text_pass) {
                    Toast.makeText(this, "Аккаунт создан", Toast.LENGTH_SHORT).show();
                    change(text_log, text_pass)
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else
                    Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Введите логин и пароль", Toast.LENGTH_SHORT).show();
            }
        }
        buttonLog.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}