package com.example.boolreader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MyCompaniesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_companies)
        
        val myCompaniesBtn: Button = findViewById(R.id.goToCreateCompanyBtn)
        myCompaniesBtn.setOnClickListener {
            val intent = Intent(this, CreateCompanyActivity::class.java)
            startActivity(intent)
        }
    }
}