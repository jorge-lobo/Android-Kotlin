package com.example.a06_ex02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.a06_ex02.databinding.ActivityNewNumberBinding

class NewNumberActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewNumberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOk2.setOnClickListener {
            var i = intent
            val extras = i.extras

            i = Intent(this, ResultActivity::class.java)
            if (extras != null) {
                i.putExtras(extras)
            }
            i.putExtra("número2", binding.editNumero2.text.toString())
            startActivity(i)
        }


    }
}