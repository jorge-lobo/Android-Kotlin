package com.example.a09_ex02

import android.R
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.a09_ex02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listNotes = ArrayList<String>()

        val arrayAdapter = ArrayAdapter(this, R.layout.simple_list_item_1, listNotes)
        binding.listViewNotes.adapter = arrayAdapter

        binding.btnAddNote.setOnClickListener {
            if (!binding.editNote.text.toString().trim().isEmpty()) {
                listNotes.add(binding.editNote.text.toString())
                arrayAdapter.notifyDataSetChanged()
                binding.editNote.setText("")
            }
        }

    }
}