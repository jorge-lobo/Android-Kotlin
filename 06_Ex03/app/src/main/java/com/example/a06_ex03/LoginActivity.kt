package com.example.a06_ex03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a06_ex03.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var i = intent

        val username = i.getStringExtra("username")
        val password = i.getStringExtra("password")

        binding.buttonEnter.setOnClickListener {
            if (username != null && password != null) {
                if (username.equals(binding.editName.text.toString()) && password.equals(binding.editPass.text.toString())) {
                    startActivity(Intent(this, SobreActivity::class.java))
                } else {
                    Toast.makeText(this, "Wrong login", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }


}
