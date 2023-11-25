package com.example.boolreader

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.boolreader.services.AdviseService
import com.example.boolreader.services.CompanyService

class AdviseActivity : AppCompatActivity() {
    private val companyService: CompanyService = CompanyService.getInstance();
    private val adviseService: AdviseService = AdviseService.getInstance();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advise)

        val selectedAdvise = adviseService.getSelectedAdvise();

        val titleTextView: TextView = findViewById(R.id.titleTextView)
        titleTextView.text = selectedAdvise.title;

        val companyNameTextView: TextView = findViewById(R.id.companyNameTextView)
        companyNameTextView.text = selectedAdvise.company.name;

        val textTextView: TextView = findViewById(R.id.textTextView)
        textTextView.text = selectedAdvise.text;

        val goToMainPageBtn: Button = findViewById(R.id.goToMainPage5)
        goToMainPageBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val goToCompanyPageBtn: Button = findViewById(R.id.goToParentCompanyPageBtn)
        goToCompanyPageBtn.setOnClickListener {
            companyService.selectCompany(selectedAdvise.company.id)
            val intent = Intent(this, CompanyActivity::class.java)
            startActivity(intent)
        }
    }
}