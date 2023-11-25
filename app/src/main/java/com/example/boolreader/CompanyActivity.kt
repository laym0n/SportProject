package com.example.boolreader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.example.boolreader.domain.Advise
import com.example.boolreader.services.AdviseService
import com.example.boolreader.services.AuthService
import com.example.boolreader.services.CompanyService

class CompanyActivity : AppCompatActivity() {
    private val companyService: CompanyService = CompanyService.getInstance();
    private val adviseService: AdviseService = AdviseService.getInstance();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company)

        val selectedCompany = companyService.selectedCompany;

        val nameTextView: TextView = findViewById(R.id.nameTextView)
        nameTextView.text = selectedCompany.name;

        val addressTextView: TextView = findViewById(R.id.addressTextView)
        addressTextView.text = selectedCompany.address;

        val goToMainPageBtn: Button = findViewById(R.id.goToMainPage3)
        goToMainPageBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val subscriptionBtn: Button = findViewById(R.id.subscriptionBtn)
        subscriptionBtn.text = if (companyService.isCurUserSubscribed(selectedCompany.id) ) "Отписаться" else "Подписаться";
        subscriptionBtn.setOnClickListener {
            try {
                if (companyService.isCurUserSubscribed(selectedCompany.id) ) {
                    companyService.unSubscribeToCompany(selectedCompany.id)
                    subscriptionBtn.text = "Подписаться"
                }
                else {
                    companyService.subscribeToCompany(selectedCompany.id)
                    subscriptionBtn.text = "Отписаться"
                }
            } catch (ex : Exception) {
                Toast.makeText(this, ex.message, Toast.LENGTH_SHORT).show();
            }
        }

        val goToCreateAdvisePageBtn: Button = findViewById(R.id.goToCreateAdvisePageBtn)
        goToCreateAdvisePageBtn.setOnClickListener {
            val intent = Intent(this, CreateAdviseActivity::class.java)
            startActivity(intent)
        }

        val advisesListView: ListView = findViewById(R.id.advisesListView)
        val arrayAdapter : ArrayAdapter<Advise> = ArrayAdapter<Advise>(this, android.R.layout.simple_list_item_1, selectedCompany.advises)
        advisesListView.adapter = arrayAdapter;
        advisesListView.setOnItemClickListener { parent, view, position, id ->
            val selectedAdvise : Advise = advisesListView.getItemAtPosition(position) as Advise
            adviseService.selectAdvise(selectedAdvise.id)
            val intent = Intent(this, AdviseActivity::class.java)
            startActivity(intent)
        }
    }
}