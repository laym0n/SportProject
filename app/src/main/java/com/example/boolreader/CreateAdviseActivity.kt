package com.example.boolreader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.boolreader.services.AdviseService
import com.example.boolreader.services.CompanyService

class CreateAdviseActivity : AppCompatActivity() {
    private val companyService: CompanyService = CompanyService.getInstance();
    private val adviseService: AdviseService = AdviseService.getInstance();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_advise)

        val titleEditText: EditText = findViewById(R.id.adviseTitleEditBox)
        val textEditText: EditText = findViewById(R.id.adviseTextEditBox)

        val createAdviseBtn: Button = findViewById(R.id.createAdviseBtn)
        createAdviseBtn.setOnClickListener {
            var title = titleEditText.text.toString()
            var text = textEditText.text.toString()
            try {
                adviseService.createNewAdvise(title, text, companyService.getSelectedCompany().id)
                val intent = Intent(this, AdvisesActivity::class.java)
                startActivity(intent)
            } catch (ex : Exception) {
                Toast.makeText(this, ex.message, Toast.LENGTH_SHORT).show();
            }
        }
    }
}