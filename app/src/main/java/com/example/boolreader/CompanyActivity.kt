package com.example.boolreader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.boolreader.services.CompanyService

class CompanyActivity : AppCompatActivity() {
    private val companyService: CompanyService = CompanyService.getInstance();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company)
    }
}