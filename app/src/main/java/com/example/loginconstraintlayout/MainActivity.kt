package com.example.loginconstraintlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.loginconstraintlayout.databinding.ActivityMainBinding


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

            if (binding.password.text.toString().isNotBlank() && binding.name.text.toString()
                    .isNotBlank()
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