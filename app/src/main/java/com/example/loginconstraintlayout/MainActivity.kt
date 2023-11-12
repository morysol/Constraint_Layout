package com.example.loginconstraintlayout

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.example.loginconstraintlayout.databinding.ActivityMainBinding


const val emailRegex =
    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})\$"

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    private fun isCredential(login: Boolean, password: Boolean) = login && password
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//


        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn.isEnabled = false

        var isEmailOK = false
        var isPasswordOK = false

        binding.name.addTextChangedListener {
            Log.d(TAG, it.toString())

            isEmailOK = it.toString().matches(emailRegex.toRegex())
            if (!isEmailOK) {
                binding.name.error = getString(R.string.wrong_email)
                binding.nameInputLayout.isErrorEnabled = true
            }

            val isEmailNotBlank = it.toString().isNotBlank()
            if (!isEmailNotBlank) {
                binding.name.error = null
            }

            if (isCredential((isEmailNotBlank && isEmailOK), isPasswordOK)) binding.btn.isEnabled =
                true
        }

        binding.password.addTextChangedListener {
            if (it != null) {
                isPasswordOK = it.length > 4
            }
            Log.d(TAG, isEmailOK.toString())
            Log.d(TAG, isPasswordOK.toString())
            if (isCredential(isEmailOK, isPasswordOK)) binding.btn.isEnabled = true
        }

        binding.btn.setOnClickListener {
            var infoMessage = "Hello, dear user!"


            infoMessage = infoMessage.replace("user", binding.name.text.toString())

            binding.loginLabel.text = infoMessage

            binding.btn.setBackgroundColor(
                ContextCompat.getColor(this, R.color.btnLoginPressed)
            )
            binding.btn.text = "success"
            binding.btn.isEnabled = false

            binding.name.text = null
            binding.name.isEnabled = false

            binding.password.text = null
            binding.password.isEnabled = false

            supportFragmentManager.beginTransaction()
                .replace(binding.mainLayout.id, Library()) // place where to put fragment
                .addToBackStack(null) // we want add fragment to backStack
                .commit()


        }
    }
}