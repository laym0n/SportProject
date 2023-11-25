package com.example.boolreader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import com.example.boolreader.domain.Company
import com.example.boolreader.services.CompanyService

class MyCompaniesActivity : AppCompatActivity() {
    private val companyService: CompanyService = CompanyService.getInstance();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_companies)
        
        val myCompaniesBtn: Button = findViewById(R.id.goToCreateCompanyBtn)
        myCompaniesBtn.setOnClickListener {
            val intent = Intent(this, CreateCompanyActivity::class.java)
            startActivity(intent)
        }

        val goToMainPageBtn: Button = findViewById(R.id.goToMainPage)
        goToMainPageBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val myCompaniesListView: ListView = findViewById(R.id.myCompaniesListView)
        val arrayAdapter : ArrayAdapter<Company> = ArrayAdapter<Company>(this, android.R.layout.simple_list_item_1, companyService.owningCompaniesOfCurrentUser)
        myCompaniesListView.adapter = arrayAdapter;
        myCompaniesListView.setOnItemClickListener { parent, view, position, id ->
            val selectCompany : Company = myCompaniesListView.getItemAtPosition(position) as Company;
            companyService.selectCompany(selectCompany.id)
            val intent = Intent(this, CompanyActivity::class.java)
            startActivity(intent)
        }
    }
}