package com.example.boolreader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.boolreader.services.AuthService
import com.example.boolreader.services.CompanyService

class CreateCompanyActivity : AppCompatActivity() {
    private val companyService: CompanyService = CompanyService.getInstance();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_company)


        val companyName: EditText = findViewById(R.id.companyName)
        val companyAddress: EditText = findViewById(R.id.companyAddress)

        val createCompanyBtn: Button = findViewById(R.id.createCompanyBtn)
        createCompanyBtn.setOnClickListener {
            var name = companyName.text.toString()
            var address = companyAddress.text.toString()
            try {
                companyService.createNewCompany(name, address)
            } catch (ex : Exception) {
                Toast.makeText(this, ex.message, Toast.LENGTH_SHORT).show();
            }
            val intent = Intent(this, MyCompaniesActivity::class.java)
            startActivity(intent)
        }
    }
}