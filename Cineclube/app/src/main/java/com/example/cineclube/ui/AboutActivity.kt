package com.example.cineclube.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cineclube.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnExit.setOnClickListener {
            finish()
        }

        binding.imageButtonInstagram.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/jorgelobo15"))
            startActivity(i)
        }

        binding.imageButtonLinkedin.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/jorgelobo15/"))
            startActivity(i)
        }

        binding.imageButtonGithub.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/jorge-lobo"))
            startActivity(i)
        }
    }
}