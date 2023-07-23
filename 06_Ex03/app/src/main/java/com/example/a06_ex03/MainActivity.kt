package com.example.a06_ex03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.a06_ex03.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private var username = "username"
    private var password = "password"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRegist.setOnClickListener {
            val i = Intent(this, RegistoActivity::class.java)
            i.putExtra("username", username)
            i.putExtra("password", password)
            resultLauncher.launch(i)
        }

        binding.buttonLogin.setOnClickListener {
            var i = Intent(this, LoginActivity::class.java)
            i.putExtra("username", username)
            i.putExtra("password", password)
            startActivity(i)
        }

        binding.buttonAbout.setOnClickListener {
            startActivity(Intent(this, SobreActivity::class.java))
        }

        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.data != null) {
                    if (it.resultCode == 1) {
                        username = it.data?.getStringExtra("username").toString()
                        password = it.data?.getStringExtra("password").toString()
                    }
                }
            }

    }
}