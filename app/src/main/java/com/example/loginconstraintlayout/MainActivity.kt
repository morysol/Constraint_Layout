package com.example.loginconstraintlayout

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.loginconstraintlayout.databinding.ActivityMainBinding


const val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
fun isValidEmail(email: String): Boolean {
    return email.matches(emailRegex.toRegex())
}

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn.setOnClickListener {

            var infoMessage = "Hello, dear user!"
            val login = binding.name.text.toString()

            var isLoginOK = login.isNotBlank() && isValidEmail(login)
            Log.d(TAG, isLoginOK.toString())

            var isPasswordOK = binding.password.text.toString().isNotBlank()


            if (isLoginOK && isPasswordOK
            ) {
                infoMessage = infoMessage.replace("user", binding.name.text.toString())

                binding.loginLabel.text = infoMessage

                binding.btn.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.btnLoginPressed)
                )
                binding.btn.text = "Success!"
                binding.btn.isEnabled = false

            }
        }
    }
}