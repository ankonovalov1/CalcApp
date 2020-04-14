package com.example.myappex

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_cool_calc.*
import kotlin.math.pow
import kotlin.math.sqrt


class CoolCalcActivity : AppCompatActivity() {

    var number = 0.0
    var operatorValue: String = ""
    var operationsCheck: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cool_calc)

        ceBtn.setOnClickListener{
            result1.text = "0"
        }
        cBtn.setOnClickListener {

            result1.text = "0"
            number = 0.0
        }
        delBtn.setOnClickListener {

            val newString = StringBuilder(result1.text);
            val stringLength = result1.text.length;
            if (result1.text != "")
            {
                newString.deleteCharAt(stringLength - 1);
            }
            if (newString.toString() != "")
            {
                result1.text = newString.toString();
            }
            else
            {
                result1.text = "0";
            }
        }

        dotBtn.setOnClickListener {
            if (operationsCheck) {
                result1.text = ""
            }
            operationsCheck = false

            result1.text = result1.text.toString().plus(dotBtn.text)
        }

        equalBtn.setOnClickListener {

            if (operatorValue != "=")
            {
                when(operatorValue)
                {
                    "/" ->
                    if (result1.text.toString().toDouble() != 0.0)
                    {
                        result1.text = (number / (result1.text.toString().toDouble())).toString()
                    }
                    else if (result1.text.toString().toDouble() == 0.0)
                    {
                        result1.text = "На ноль делить нельзя!"
                    }

                    "*" -> result1.text = (number * (result1.text.toString().toDouble())).toString()

                    "-" -> result1.text = (number - (result1.text.toString().toDouble())).toString()

                    "+" -> result1.text = (number + (result1.text.toString().toDouble())).toString()

                    "%" -> result1.text = (number % (result1.text.toString().toDouble())).toString()

                }
                operatorValue = "=";
                operationsCheck = false;
            }
        }

    }

    fun numberClick(view: View)
    {
        val btn = findViewById<Button>(view.id)
        if (result1.text.toString() == "0" || operationsCheck)
            {
                result1.text = ""
            }
            if (operatorValue == "=")
            {
                result1.text = ""
                operatorValue = ""
            }
            operationsCheck = false

        result1.text = result1.text.toString().plus(btn.text)
    }

    fun operationClick(view: View)
    {
        val btn = findViewById<Button>(view.id)
            operatorValue = btn.text.toString()
            number = result1.text.toString().toDouble()
            operationsCheck = true
    }

    fun otherOperationClick(view: View)
    {
        val btn = findViewById<Button>(view.id)
            operatorValue = btn.text.toString()
            number = result1.text.toString().toDouble()
            operationsCheck = true

            when(operatorValue)
            {
                "1/x" -> result1.text = (1 / number).toString()

                "x^2" -> result1.text = number.pow(2).toString()

                "SqrtX" -> result1.text = sqrt(number).toString()

                "+/-" ->
                    if (number > 0)
                        {
                            result1.text = "-" + result1.text
                        }
                    else
                        {
                            number = (number * -2) / 2
                             result1.text = number.toString()
                        }
            }

        }
    }


