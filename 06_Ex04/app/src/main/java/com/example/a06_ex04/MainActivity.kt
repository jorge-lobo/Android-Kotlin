package com.example.a06_ex04

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.example.a06_ex04.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOrder.setOnClickListener {
            val i = Intent(this, SplashScreenActivity::class.java)
            i.putExtra("qt_pizza", binding.editQtPizza.text.toString())
            i.putExtra("qt_lasagna", binding.editQtLasagna.text.toString())
            i.putExtra("qt_carbonara", binding.editQtCarbonara.text.toString())
            i.putExtra("qt_bolognese", binding.editQtBolognese.text.toString())
            i.putExtra("qt_cake", binding.editQtCake.text.toString())
            i.putExtra("qt_icecream", binding.editQtIcecream.text.toString())
            startActivity(i)
        }

        binding.cbPizza.setOnClickListener {
            if (binding.cbPizza.isChecked) {
                binding.editQtPizza.setText("1")
             } else {
                binding.editQtPizza.setText("0")
            }
        }

        binding.cbLasagna.setOnClickListener {
            if (binding.cbLasagna.isChecked) {
                binding.editQtLasagna.setText("1")
            } else {
                binding.editQtLasagna.setText("0")
            }
        }

        binding.cbCarbonara.setOnClickListener {
            if (binding.cbCarbonara.isChecked) {
                binding.editQtCarbonara.setText("1")
            } else {
                binding.editQtCarbonara.setText("0")
            }
        }

        binding.cbBolognese.setOnClickListener {
            if (binding.cbBolognese.isChecked) {
                binding.editQtBolognese.setText("1")
            } else {
                binding.editQtBolognese.setText("0")
            }
        }

        binding.cbCake.setOnClickListener {
            if (binding.cbCake.isChecked) {
                binding.editQtCake.setText("1")
            } else {
                binding.editQtCake.setText("0")
            }
        }

        binding.cbIcecream.setOnClickListener {
            if (binding.cbIcecream.isChecked) {
                binding.editQtIcecream.setText("1")
            } else {
                binding.editQtIcecream.setText("0")
            }
        }
    }
}