package com.example.register

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import com.example.register.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnContinue : Button = findViewById(R.id.btn_continue)
        btnContinue.setBackgroundColor(resources.getColor(R.color.grey))
        val edtEmail : EditText = findViewById(R.id.edt_email)

        edtEmail.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                btnContinue.isClickable = false
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val redColor : String = "#ED3B3B"
                btnContinue.isClickable = true
                btnContinue.setBackgroundColor(resources.getColor(R.color.red))
            }

            override fun afterTextChanged(s: Editable?) {
                btnContinue.isClickable = true
            }
        })

    }
}