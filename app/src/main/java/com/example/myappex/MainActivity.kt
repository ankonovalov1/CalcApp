package com.example.myappex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionsArr = resources.getStringArray(R.array.actions_name)
            if (actions != null) {
                val adapter = ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_item, actionsArr
                )
                actions.adapter = adapter
                actions.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>,
                        view: View, position: Int, id: Long
                    ) {
                        Toast.makeText(
                            this@MainActivity,
                            actionsArr[position], Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {
                        // write code to perform some action
                    }
                }
            }
        resultBtn.setOnClickListener {
        if(editText1.editableText.isNotEmpty() && editText2.editableText.isNotEmpty()){
            var num1 = editText1.editableText.toString().toInt()
            var num2 = editText2.editableText.toString().toInt()

            if(num2 == 0) Toast.makeText(
                this@MainActivity,
                "На ноль делить нельзя!",
                Toast.LENGTH_SHORT).show()

            when(actions.selectedItem){
                "*" -> result.text = (num1 * num2).toString()
                "-" -> result.text = (num1 - num2).toString()
                "+" -> result.text = (num1 + num2).toString()
                "/" -> if(num2 != 0) result.text = (num1 / num2).toString()
            }
        }

        }
    }
}


