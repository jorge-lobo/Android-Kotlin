package com.example.cineclube.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cineclube.R
import com.example.cineclube.database.UserDBHelper
import com.example.cineclube.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = UserDBHelper(this)

        binding.btnSave.setOnClickListener {
            val username = binding.editUsername.text.toString()
            val password = binding.editPass.text.toString()
            val passwordC = binding.editConfirmPass.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty() && passwordC.isNotEmpty()) {

                if (password == passwordC) {
                    val res = db.insertUser(username, password)
                    if (res > 0) {
                        Toast.makeText(
                            applicationContext,
                            getString(R.string.registo_guardado_com_sucesso),
                            Toast.LENGTH_SHORT
                        ).show()
                        finish()
                    } else {
                        Toast.makeText(
                            applicationContext,
                            getString(R.string.erro_no_registo),
                            Toast.LENGTH_SHORT
                        ).show()
                        binding.editUsername.setText("")
                        binding.editPass.setText("")
                        binding.editConfirmPass.setText("")
                    }
                } else {
                    Toast.makeText(
                        applicationContext,
                        getString(R.string.passwords_nao_combinam),
                        Toast.LENGTH_SHORT
                    ).show()
                    binding.editConfirmPass.setText("")
                }
            } else {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.preencha_todos_os_campos),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.btnCancel.setOnClickListener {
            finish()
        }
    }
}
