package com.example.boolreader

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.boolreader.domain.Advise
import com.example.boolreader.services.AdviseService

class AdvisesActivity : AppCompatActivity() {
    private val adviseService: AdviseService = AdviseService.getInstance();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advises)

        val advisesListView: ListView = findViewById(R.id.advisesListView)
        val arrayAdapter : ArrayAdapter<Advise> = ArrayAdapter<Advise>(this, android.R.layout.simple_list_item_1, adviseService.allAdvises)
        advisesListView.adapter = arrayAdapter;
        advisesListView.setOnItemClickListener { parent, view, position, id ->
            val selectedAdvise : Advise = advisesListView.getItemAtPosition(position) as Advise
            adviseService.selectAdvise(selectedAdvise.id)
            val intent = Intent(this, AdviseActivity::class.java)
            startActivity(intent)
        }

        val goToMainPage: Button = findViewById(R.id.goToMainPage4)
        goToMainPage.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}