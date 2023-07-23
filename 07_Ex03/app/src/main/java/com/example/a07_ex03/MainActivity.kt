package com.example.a07_ex03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.R
import android.content.Intent
import android.widget.ArrayAdapter
import com.example.a07_ex03.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val pos = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaAluno = ArrayList<Aluno>()
        listaAluno.add(Aluno("Luís Alberto", "Rua Central", "luis.alberto@gmail.com"))
        listaAluno.add(Aluno("Rute Santos", "Rua do Pinhal", "rute.santos@gmail.com"))
        listaAluno.add(Aluno("Adalberto Castro", "Rua da Boavista", "berto.castro@gmail.com"))
        listaAluno.add(Aluno("Carlota Martins", "Rua S. João", "carlota.martins@gmail.com"))
        listaAluno.add(Aluno("Vasco Pires", "Rua Direita", "vasco.pires@gmail.com"))
        listaAluno.add(Aluno("Olga Vaz", "Rua do Jogo", "olga.vaz@gmail.com"))

        val arrayAdapter = ArrayAdapter(this, R.layout.simple_list_item_1, listaAluno)
        binding.listViewAlunos.adapter = arrayAdapter

        binding.listViewAlunos.setOnItemClickListener { _, _, position, _ ->
            val i = Intent(this, AlunoActivity::class.java)
            i.putExtra("nome", listaAluno.get(position).nome)
            i.putExtra("morada", listaAluno.get(position).morada)
            i.putExtra("email", listaAluno.get(position).email)
            startActivity(i)
        }


    }
}