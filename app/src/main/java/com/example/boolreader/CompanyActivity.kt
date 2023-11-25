package com.example.boolreader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.boolreader.services.CompanyService

class CompanyActivity : AppCompatActivity() {
    private val companyService: CompanyService = CompanyService.getInstance();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company)

        val selectedCompany = companyService.selectedCompany;

        val nameTextView: TextView = findViewById(R.id.nameTextView)
        nameTextView.text = selectedCompany.name;

        val addressTextView: TextView = findViewById(R.id.addressTextView)
        addressTextView.text = selectedCompany.address;
    }
}