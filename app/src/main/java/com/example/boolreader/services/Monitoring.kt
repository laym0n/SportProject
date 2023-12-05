package com.example.boolreader.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.widget.Toast

class Monitoring : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val batteryLevel = intent?.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)

        val status = when (intent?.getIntExtra(BatteryManager.EXTRA_STATUS, -1)) {
            BatteryManager.BATTERY_STATUS_CHARGING -> "Зарядка"
            BatteryManager.BATTERY_STATUS_DISCHARGING -> "Разрядка"
            BatteryManager.BATTERY_STATUS_FULL -> "Полный заряд"
            BatteryManager.BATTERY_STATUS_UNKNOWN -> "Неизвестно"
            else -> "Неизвестное состояние"
        }

        val message = "Уровень заряда батареи: $batteryLevel%\nСостояние: $status"
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}