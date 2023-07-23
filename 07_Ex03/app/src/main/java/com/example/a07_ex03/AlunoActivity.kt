package com.example.a07_ex03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a07_ex03.databinding.ActivityAlunoBinding

class AlunoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlunoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlunoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent
        val aluno_nome = i.getStringExtra("nome")
        val aluno_morada = i.getStringExtra("morada")
        val aluno_email = i.getStringExtra("email")
        val aluno = "  ${aluno_nome} \n  ${aluno_morada} \n  ${aluno_email}"

        binding.textAluno1.setText("Nome:\nMorada:\nEmail:")
        binding.textAluno2.setText(aluno)

        binding.btnVoltar.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            finish()
        }






    }
}