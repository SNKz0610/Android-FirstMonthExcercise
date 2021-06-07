package com.example.register

import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.register.R

fun isEmailValid(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun alertDialogOfInvalidEmail(context: Context) {
    val builder = AlertDialog.Builder(context)
    builder.setTitle("WARRNING")
    builder.setMessage("Invalid Email! ⊙﹏⊙∥")
    builder.setIcon(R.drawable.ic_baseline_warning_24)
    builder.setNegativeButton("OK") { dialog: DialogInterface, id: Int ->
        dialog.dismiss()
    }
    builder.show()
}


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnContinue: Button = findViewById(R.id.btn_continue)
        val edtEmail: EditText = findViewById(R.id.edt_email)

        edtEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                btnContinue.isClickable = false
                btnContinue.setBackgroundColor(resources.getColor(R.color.grey))
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                btnContinue.isClickable = true
                btnContinue.setBackgroundColor(resources.getColor(R.color.red))
            }

            override fun afterTextChanged(s: Editable?) {
                val email: String = edtEmail.text.toString()
                if (email.isBlank()) {
                    btnContinue.isClickable = false
                    btnContinue.setBackgroundColor(resources.getColor(R.color.grey))
                } else {
                    btnContinue.setOnClickListener {
                        if (isEmailValid(email)) {
                            Toast.makeText(this@MainActivity, "🎉 ACCESS GRANTED! 🎉", Toast.LENGTH_LONG).show()
                        } else {
                            alertDialogOfInvalidEmail(this@MainActivity)
                        }
                    }
                }
            }
        })
    }
}