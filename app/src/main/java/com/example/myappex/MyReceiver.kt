package com.example.myappex

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        Toast.makeText(context, "Заряда батареи достаточно, юзай приложулю", Toast.LENGTH_SHORT).show()
    }
}
