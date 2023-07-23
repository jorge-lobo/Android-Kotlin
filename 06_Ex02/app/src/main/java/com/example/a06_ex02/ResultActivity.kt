package com.example.a06_ex02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a06_ex02.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var i = intent

        val numero1 = intent.getStringExtra("número1").toString().toInt()
        val numero2 = intent.getStringExtra("número2").toString().toInt()

        val soma = numero1 + numero2
        binding.textSoma.text = "${numero1} + ${numero2} = ${soma}"

        val subtracao = numero1 - numero2
        binding.textSubtracao.text = "${numero1} - ${numero2} = ${subtracao}"

        val multiplicacao = numero1 * numero2
        binding.textMultiplicacao.text = "${numero1} x ${numero2} = ${multiplicacao}"

        val divisao = numero1 / numero2
        binding.textDivisao.text = "${numero1} : ${numero2} = ${divisao}"

        binding.buttonVoltar.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

    }
}