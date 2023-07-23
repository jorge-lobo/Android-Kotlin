package com.example.a09_ex01

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.edit
import com.example.a09_ex01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sp = this.getSharedPreferences("dadosApp", Context.MODE_PRIVATE)
        binding.editUsername.setText(sp.getString("username", ""))

        binding.btnLogin.setOnClickListener {
            val username = binding.editUsername.text.toString()
            val password = binding.editPass.text.toString()
            val editor = sp.edit()

            if (username != null && password != null) {
                Toast.makeText(this, "Valid login", Toast.LENGTH_SHORT).show()
                editor.putString("username", username)
            } else {
                Toast.makeText(this, "Wrong login", Toast.LENGTH_SHORT).show()
                editor.putString("username", "")
            }
            editor.apply()
        }

        binding.btnReset.setOnClickListener {
            binding.editUsername.setText("")
            binding.editPass.setText("")
            val editor = sp.edit()
            editor.putString("username", "")
            editor.apply()
        }
    }

}
