package com.example.boolreader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.boolreader.services.AuthService

class MainPage : AppCompatActivity() {
    private val authService: AuthService = AuthService.getInstance();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        val logOutBtn: Button = findViewById(R.id.logOutBtn)
        logOutBtn.setOnClickListener {
            authService.logOut()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}