package com.example.cineclube.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cineclube.R
import com.example.cineclube.databinding.ActivityMovieImageSelectionBinding

class MovieImageSelectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieImageSelectionBinding
    private lateinit var i: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieImageSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        i = intent

        binding.image1.setOnClickListener { sendID(R.drawable.p13.toString()) }
        binding.image2.setOnClickListener { sendID(R.drawable.p14.toString()) }
        binding.image3.setOnClickListener { sendID(R.drawable.p15.toString()) }
        binding.image4.setOnClickListener { sendID(R.drawable.p16.toString()) }
        binding.image5.setOnClickListener { sendID(R.drawable.p17.toString()) }
        binding.image6.setOnClickListener { sendID(R.drawable.p18.toString()) }
        binding.btnRemove.setOnClickListener { sendID(R.drawable.p_default.toString()) }

        binding.btnCancel.setOnClickListener {
            finish()
        }
    }

    private fun sendID(poster: String) {
        i.putExtra("poster", poster)
        setResult(1, i)
        finish()
    }
}