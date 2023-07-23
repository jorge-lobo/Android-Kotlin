package com.example.a06_ex03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a06_ex03.databinding.ActivitySobreBinding

class SobreActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySobreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySobreBinding.inflate(layoutInflater)
        setContentView(binding.root)







    }
}