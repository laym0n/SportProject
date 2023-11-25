package com.example.boolreader

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.boolreader.domain.Company
import com.example.boolreader.services.CompanyService

class MySubscriptionActivity : AppCompatActivity() {
    private val companyService: CompanyService = CompanyService.getInstance();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_subscription)


        val goToMainPageBtn: Button = findViewById(R.id.goToMainPage2)
        goToMainPageBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val myCompaniesListView: ListView = findViewById(R.id.mySubscriptionsListView)
        val arrayAdapter : ArrayAdapter<Company> = ArrayAdapter<Company>(this, android.R.layout.simple_list_item_1, companyService.subscribedCompaniesOfCurrentUser)
        myCompaniesListView.adapter = arrayAdapter;
    }
}