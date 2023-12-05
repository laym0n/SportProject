package com.example.boolreader

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.boolreader.services.AuthService
import com.example.boolreader.services.Monitoring

class MainActivity : AppCompatActivity() {
    private val authService: AuthService = AuthService.getInstance();
    private val batteryLevelReceiver: Monitoring = Monitoring();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        val logOutBtn: Button = findViewById(R.id.logOutBtn)
        logOutBtn.setOnClickListener {
            authService.logOut()
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        val myCompaniesBtn: Button = findViewById(R.id.MyCompaniesBtn)
        myCompaniesBtn.setOnClickListener {
            val intent = Intent(this, MyCompaniesActivity::class.java)
            startActivity(intent)
        }

        val mySubscriptionBtn: Button = findViewById(R.id.goToMySubscriptionsBtn)
        mySubscriptionBtn.setOnClickListener {
            val intent = Intent(this, MySubscriptionActivity::class.java)
            startActivity(intent)
        }

        val gotToAllAdvisesPageBtn: Button = findViewById(R.id.gotToAllAdvisesPageBtn)
        gotToAllAdvisesPageBtn.setOnClickListener {
            val intent = Intent(this, AdvisesActivity::class.java)
            startActivity(intent)
        }

        val batteryBtn: Button = findViewById(R.id.batteryBtn)
        batteryBtn.setOnClickListener {
            val intentFilter : IntentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
            registerReceiver(batteryLevelReceiver, intentFilter)
        }
    }
}