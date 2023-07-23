package com.example.a09_ex03

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a09_ex03.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCat.setOnClickListener {
            val mediaPlayer_cat = MediaPlayer.create(applicationContext, R.raw.cat)
            mediaPlayer_cat.start()
        }

        binding.btnCow.setOnClickListener {
            val mediaPlayer_cow = MediaPlayer.create(applicationContext, R.raw.cow)
            mediaPlayer_cow.start()
        }
        binding.btnCrow.setOnClickListener {
            val mediaPlayer_crow = MediaPlayer.create(applicationContext, R.raw.crow)
            mediaPlayer_crow.start()
        }
        binding.btnDog.setOnClickListener {
            val mediaPlayer_dog = MediaPlayer.create(applicationContext, R.raw.dog)
            mediaPlayer_dog.start()
        }
        binding.btnDolphin.setOnClickListener {
            val mediaPlayer_dolphin = MediaPlayer.create(applicationContext, R.raw.dolphin)
            mediaPlayer_dolphin.start()
        }
        binding.btnEagle.setOnClickListener {
            val mediaPlayer_eagle = MediaPlayer.create(applicationContext, R.raw.eagle)
            mediaPlayer_eagle.start()
        }
        binding.btnHorse.setOnClickListener {
            val mediaPlayer_horse = MediaPlayer.create(applicationContext, R.raw.horse)
            mediaPlayer_horse.start()
        }
        binding.btnLion.setOnClickListener {
            val mediaPlayer_lion = MediaPlayer.create(applicationContext, R.raw.lion)
            mediaPlayer_lion.start()
        }
        binding.btnMonkey.setOnClickListener {
            val mediaPlayer_monkey = MediaPlayer.create(applicationContext, R.raw.monkey)
            mediaPlayer_monkey.start()
        }
        binding.btnRooster.setOnClickListener {
            val mediaPlayer_rooster = MediaPlayer.create(applicationContext, R.raw.rooster)
            mediaPlayer_rooster.start()
        }
        binding.btnSheep.setOnClickListener {
            val mediaPlayer_sheep = MediaPlayer.create(applicationContext, R.raw.sheep)
            mediaPlayer_sheep.start()
        }
        binding.btnTurkey.setOnClickListener {
            val mediaPlayer_turkey = MediaPlayer.create(applicationContext, R.raw.turkey)
            mediaPlayer_turkey.start()
        }
        binding.btnWhale.setOnClickListener {
            val mediaPlayer_whale = MediaPlayer.create(applicationContext, R.raw.whale)
            mediaPlayer_whale.start()
        }
        binding.btnWolf.setOnClickListener {
            val mediaPlayer_wolf = MediaPlayer.create(applicationContext, R.raw.wolf)
            mediaPlayer_wolf.start()
        }


    }
}