package com.example.loginconstraintlayout

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private var loginLabel: TextView? = null
    private var btnLogin: Button? = null
    private var editName: EditText? = null
    private var editPass: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginLabel = findViewById(R.id.loginLabel)
        btnLogin = findViewById(R.id.btn)
        editName = findViewById(R.id.name)
        editPass = findViewById(R.id.password)

        btnLogin?.setOnClickListener {

            if (editPass?.text.toString().isNotBlank() && editName?.text.toString().isNotBlank()
            ) {
                loginLabel?.text = "Hello, dear ${
                    editName?.text.toString()
                }!"

                btnLogin?.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.btnLoginPressed)
                )
                btnLogin?.text = "Success!"
            }
        }
    }
}