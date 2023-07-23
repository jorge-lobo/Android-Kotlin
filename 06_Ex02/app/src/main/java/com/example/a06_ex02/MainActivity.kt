package com.example.a06_ex02

import android.app.Instrumentation.ActivityResult
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.a06_ex02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOk1.setOnClickListener {
            val i = Intent(this, NewNumberActivity::class.java)
            i.putExtra("número1", binding.editNumero1.text.toString())
            startActivity(i)
        }


    }
}