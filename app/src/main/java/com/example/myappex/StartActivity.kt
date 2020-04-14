package com.example.myappex

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_new.*
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val receiver = MyReceiver()
        val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        intentFilter.addAction(Intent.ACTION_BATTERY_OKAY)
        registerReceiver(receiver,intentFilter)

        easyCalcBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        coolCalcBtn.setOnClickListener{
            val intent = Intent(this, CoolCalcActivity::class.java)
            startActivity(intent)
        }

        newActBtn.setOnClickListener {

            val intent = Intent(this, NewActivity::class.java)
            intent.putExtra("tvMes", "Переданный текст в активити")
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                var result = data?.getStringExtra("result")
                newActBtn.text = result
            }
            if(resultCode == Activity.RESULT_CANCELED){
                var result = "Ничерта не открылось!"
            }
        }
    }

}


