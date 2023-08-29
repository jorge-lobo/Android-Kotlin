package com.example.cineclube.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.cineclube.R
import com.example.cineclube.database.MovieDBHelper
import com.example.cineclube.databinding.ActivityMovieDetailBinding
import com.example.cineclube.model.MovieModel
import java.text.SimpleDateFormat
import java.util.Locale

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding
    private lateinit var db: MovieDBHelper
    private var movieModel = MovieModel()

    private val movieImageNameMap = mapOf(
        "p1" to R.drawable.p1,
        "p2" to R.drawable.p2,
        "p3" to R.drawable.p3,
        "p4" to R.drawable.p4,
        "p5" to R.drawable.p5,
        "p6" to R.drawable.p6,
        "p7" to R.drawable.p7,
        "p8" to R.drawable.p8,
        "p9" to R.drawable.p9,
        "p10" to R.drawable.p10,
        "p11" to R.drawable.p11,
        "p12" to R.drawable.p12,
        "p13" to R.drawable.p13,
        "p14" to R.drawable.p14,
        "p15" to R.drawable.p15,
        "p16" to R.drawable.p16,
        "p17" to R.drawable.p17,
        "p18" to R.drawable.p18,
    )

    private fun formatDate(date: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val outputFormat = SimpleDateFormat("d MMMM", Locale.getDefault())
        val parsedDate = inputFormat.parse(date)
        return outputFormat.format(parsedDate)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("username")

        db = MovieDBHelper(this)
        val sharedPreferences = application.getSharedPreferences("login", Context.MODE_PRIVATE)

        val i = intent
        val id = i.extras?.getInt("id")
       // val poster = i.extras?.getString("poster")

        if (id != null) {
            movieModel = db.getMovie(id)
            populate()

        } else {
            finish()
        }

        binding.btnLogout.setOnClickListener {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("username", "")
            editor.apply()
            startActivity(Intent(applicationContext, SplashScreenActivity::class.java))
        }

        binding.btnClose.setOnClickListener {
            finish()
        }

        if (username == "admin") {
            binding.btnEdit.visibility = View.VISIBLE
        } else {
            binding.btnEdit.visibility = View.INVISIBLE
        }

        binding.btnEdit.setOnClickListener {
            val i = intent
            val intent = Intent(this, EditMovieActivity::class.java)
            intent.putExtra("movie", movieModel)
            intent.putExtras(i)

            startActivity(intent)
        }
    }

    private fun populate() {
        binding.textTitle.text = movieModel.title
        val formattedDate = formatDate(movieModel.date)
        binding.textDate.text = formattedDate
        binding.textPlace.text = movieModel.place
        binding.textYear.text = movieModel.year.toString()
        binding.textDirector.text = movieModel.director
        binding.textCast1.text = movieModel.cast1
        binding.textCast2.text = movieModel.cast2
        binding.textCast3.text = movieModel.cast3
        binding.textGenre.text = movieModel.genre
        binding.textDuration.text = movieModel.duration.toString()
        binding.textImdb.text = movieModel.imdb.toString()
        binding.textPlot.text = movieModel.plot

        val imageResourceName = movieModel.poster
        val imageResourceId = movieImageNameMap[imageResourceName] ?: R.drawable.p_default
        binding.imagePoster.setImageResource(imageResourceId)
    }
}