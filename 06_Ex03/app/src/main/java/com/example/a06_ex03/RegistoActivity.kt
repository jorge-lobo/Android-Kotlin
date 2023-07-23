package com.example.a06_ex03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a06_ex03.databinding.ActivityRegistoBinding

class RegistoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var i = intent

        binding.buttonSave.setOnClickListener {
            i.putExtra("username", binding.editName.text.toString())
            i.putExtra("password", binding.editPass.text.toString())
            setResult(1, i)
            finish()
        }

    }
}




