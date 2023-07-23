package com.example.a06_ex04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.text.SimpleDateFormat
import android.widget.TextView
import java.util.*
import com.example.a06_ex04.databinding.ActivityOrderBinding

class OrderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textDate: TextView = findViewById(R.id.text_date)
        val calendar: Calendar = Calendar.getInstance()
        val simpleDateFormat = SimpleDateFormat("EEEE, dd-MMMM-yyyy HH:mm:ss")
        val dateTime = simpleDateFormat.format(calendar.time)
        binding.textDate.text = dateTime

        val i = intent
        val qt_pizza = i.getStringExtra("qt_pizza").toString().toInt()
        val qt_lasagna = i.getStringExtra("qt_lasagna").toString().toInt()
        val qt_carbonara = i.getStringExtra("qt_carbonara").toString().toInt()
        val qt_bolognese = i.getStringExtra("qt_bolognese").toString().toInt()
        val qt_cake = i.getStringExtra("qt_cake").toString().toInt()
        val qt_icecream = i.getStringExtra("qt_icecream").toString().toInt()

        val tot_pizza = (qt_pizza * 12.00)
        val tot_lasagna = (qt_lasagna * 15.00)
        val tot_carbonara = (qt_carbonara * 10.00)
        val tot_bolognese = (qt_bolognese * 10.00)
        val tot_cake = (qt_cake * 2.00)
        val tot_icecream = (qt_icecream * 2.50)
        val total =
            tot_pizza + tot_lasagna + tot_carbonara + tot_carbonara + tot_cake + tot_icecream

        val qt = if (qt_pizza != 0) {
                    "${qt_pizza} \n"
                } else {
                    ""
                } +
                if (qt_lasagna != 0) {
                    "${qt_lasagna} \n"
                } else {
                    ""
                } +
                if (qt_carbonara != 0) {
                    "${qt_carbonara} \n"
                } else {
                    ""
                } +
                if (qt_bolognese != 0) {
                    "${qt_bolognese} \n"
                } else {
                    ""
                } +
                if (qt_cake != 0) {
                    "${qt_cake} \n"
                } else {
                    ""
                } +
                if (qt_icecream != 0) {
                    "${qt_icecream} \n"
                } else {
                    ""
                }

        val prod = if (qt_pizza != 0) {
                    "Pizza \n"
                } else {
                    ""
                } +
                if (qt_lasagna != 0) {
                    "Lasagna \n"
                } else {
                    ""
                } +
                if (qt_carbonara != 0) {
                    "Carbonara \n"
                } else {
                    ""
                } +
                if (qt_bolognese != 0) {
                    "Bolognese \n"
                } else {
                    ""
                } +
                if (qt_cake != 0) {
                    "Cake \n"
                } else {
                    ""
                } +
                if (qt_icecream != 0) {
                    "Ice Cream \n"
                } else {
                    ""
                }

        val price = if (qt_pizza != 0) {
                    "${tot_pizza}€ \n"
                } else {
                    ""
                } +
                if (qt_lasagna != 0) {
                    "${tot_lasagna}€ \n"
                } else {
                    ""
                } +
                if (qt_carbonara != 0) {
                    "${tot_carbonara}€ \n"
                } else {
                    ""
                } +
                if (qt_bolognese != 0) {
                    "${tot_bolognese}€ \n"
                } else {
                    ""
                } +
                if (qt_cake != 0) {
                    "${tot_cake}€ \n"
                } else {
                    ""
                } +
                if (qt_icecream != 0) {
                    "${tot_icecream}€ \n"
                } else {
                    ""
                }

        val sum = "_________________  \n" +
                "TOTAL: \t ${total}€  "

        binding.textQt.setText(qt)
        binding.textProd.setText(prod)
        binding.textPrice.setText(price)
        binding.textTotal.setText(sum)

    }
}