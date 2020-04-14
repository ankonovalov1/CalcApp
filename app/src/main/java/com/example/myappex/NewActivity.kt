package com.example.myappex

import android.app.Activity
import android.content.Intent
import android.drm.DrmStore
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_new.*

class NewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        val data = intent.extras ?: return
        textView4.text = data.getString("tvMes")

        pressBtn.setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra("result", "Все ОК, все открылось!")
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }

    }
}
