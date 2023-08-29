package com.example.cineclube.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cineclube.R
import com.example.cineclube.database.UserDBHelper
import com.example.cineclube.databinding.ActivityLoginBinding
import java.util.Locale
import kotlin.system.exitProcess


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var locale: Locale
    private var currentLanguage = "pt"
    private var currentLang: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = UserDBHelper(this)

        sharedPreferences = application.getSharedPreferences("login", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("username", "")
        if (username != null) {
            if (username.isNotEmpty()) {
                startActivity(Intent(this, MovieListActivity::class.java))
            }
        }

        currentLanguage = intent.getStringExtra(currentLang).toString()

        binding.btnLang.setOnClickListener {
            binding.cardViewLang.visibility = View.VISIBLE
        }

        val radioGroupLang = findViewById<RadioGroup>(R.id.radio_group_lang)
        radioGroupLang.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radio_btn_pt -> {
                    setLocale("pt")
                    binding.textLang.text = getString(R.string.pt_)
                }
                R.id.radio_btn_en -> {
                    setLocale("en")
                    binding.textLang.text = getString(R.string.en_)
                }
            }
            binding.cardViewLang.visibility = View.INVISIBLE
        }

        binding.btnLogin.setOnClickListener {
            val username = binding.editUsername.text.toString()
            val password = binding.editPass.text.toString()
            val logged = binding.checkboxLogin.isChecked

            if (username.isNotEmpty() && password.isNotEmpty()) {
                if (db.login(username, password)) {
                    if (logged) {
                        val editor: SharedPreferences.Editor = sharedPreferences.edit()
                        editor.putString("username", username)
                        editor.apply()
                    }
                    val i: Intent = (Intent(this, MovieListActivity::class.java))
                    i.putExtra("username", username)
                    startActivity(i)
                } else {
                    Toast.makeText(
                        applicationContext,
                        getString(R.string.login_errado),
                        Toast.LENGTH_SHORT
                    ).show()
                    binding.editUsername.setText("")
                    binding.editPass.setText("")
                }
            } else {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.preencha_todos_os_campos),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.btnSignup.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        binding.btnReset.setOnClickListener {
            binding.editUsername.setText("")
            binding.editPass.setText("")
        }

        binding.btnAbout.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }

        binding.imageButtonFacebook.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"))
            startActivity(i)
        }

        binding.imageButtonInstagram.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/"))
            startActivity(i)
        }

        binding.imageButtonYoutube.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com/"))
            startActivity(i)
        }

    }

    private fun setLocale(localeName: String) {
        if (localeName != currentLanguage) {
            locale = Locale(localeName)
            val res = resources
            val dm = res.displayMetrics
            val conf = res.configuration
            conf.locale = locale
            res.updateConfiguration(conf, dm)

            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("language", localeName)
            editor.apply()

            val refresh = Intent(
                this,
                LoginActivity::class.java
            )
            refresh.putExtra(currentLang, localeName)
            startActivity(refresh)
        } else {
            Toast.makeText(
                this@LoginActivity, getString(R.string.idioma_ja_seleccionado), Toast.LENGTH_SHORT).show();
        }
    }

    override fun onStart() {
        super.onStart()

        val savedLanguage = sharedPreferences.getString("language", "pt")

        if (savedLanguage != currentLanguage) {
            if (savedLanguage != null) {
                setLocale(savedLanguage)
            }
        }
    }

    override fun onBackPressed() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
        exitProcess(0)
    }
}