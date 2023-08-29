package com.example.cineclube.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cineclube.R
import com.example.cineclube.adapter.MovieListAdapter
import com.example.cineclube.adapter.listener.MovieOnClickListener
import com.example.cineclube.database.MovieDBHelper
import com.example.cineclube.databinding.ActivityMovieListBinding
import com.example.cineclube.model.MovieModel

class MovieListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieListBinding
    private lateinit var adapter: MovieListAdapter
    private lateinit var movieList: List<MovieModel>
    private lateinit var result: ActivityResultLauncher<Intent>
    private lateinit var dbHelper: MovieDBHelper
    private var ascDesc: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent
        val username = i.getStringExtra("username").toString()
        binding.textNameUser.setText(username)

        dbHelper = MovieDBHelper(this)
        val sharedPreferences = application.getSharedPreferences("login", Context.MODE_PRIVATE)

        binding.recyclerViewMovies.layoutManager = LinearLayoutManager(applicationContext)
        loadList()

        binding.btnLogout.setOnClickListener {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("username", "")
            editor.apply()
            startActivity(Intent(applicationContext, SplashScreenActivity::class.java))
        }

        binding.btnAdd.setOnClickListener {
            result.launch(Intent(applicationContext, NewMovieActivity::class.java))
        }

        binding.btnOrder.setOnClickListener {
            if (binding.viewOrderButtons.visibility == View.GONE) {
                binding.viewOrderButtons.visibility = View.VISIBLE
                binding.btnOrder.setImageResource(R.drawable.arrow_up_32)
                if (username == "admin") {
                    binding.btnAdd.visibility = View.VISIBLE
                }
            } else {
                binding.viewOrderButtons.visibility = View.GONE
                binding.btnOrder.setImageResource(R.drawable.arrow_down_32)
            }
        }

        binding.btnOrderTitle.setOnClickListener {
            movieList = dbHelper.getAllMovie().sortedWith(compareBy { it.title })
            if (ascDesc) {
                binding.btnOrderTitle.setImageResource(R.drawable.order_alpha_desc_32)
                binding.btnOrderPlace.setImageResource(R.drawable.order_place_32)
                binding.btnOrderDate.setImageResource(R.drawable.order_num_32)
            } else {
                binding.btnOrderTitle.setImageResource(R.drawable.order_alpha_asc_32)
                binding.btnOrderPlace.setImageResource(R.drawable.order_place_32)
                binding.btnOrderDate.setImageResource(R.drawable.order_num_32)
                movieList = movieList.reversed()
            }
            ascDesc = !ascDesc
            placeAdapter()
        }

        binding.btnOrderDate.setOnClickListener {
            movieList = dbHelper.getAllMovie().sortedWith(compareBy { it.date })
            if (ascDesc) {
                binding.btnOrderDate.setImageResource(R.drawable.order_num_desc_32)
                binding.btnOrderPlace.setImageResource(R.drawable.order_place_32)
                binding.btnOrderTitle.setImageResource(R.drawable.order_alpha_32)
            } else {
                binding.btnOrderDate.setImageResource(R.drawable.order_num_asc_32)
                binding.btnOrderPlace.setImageResource(R.drawable.order_place_32)
                binding.btnOrderTitle.setImageResource(R.drawable.order_alpha_32)
                movieList = movieList.reversed()
            }
            ascDesc = !ascDesc
            placeAdapter()
        }

        binding.btnOrderPlace.setOnClickListener {
            movieList = dbHelper.getAllMovie().sortedWith(compareBy { it.place })
            if (ascDesc) {
                binding.btnOrderPlace.setImageResource(R.drawable.order_place_desc_32)
                binding.btnOrderTitle.setImageResource(R.drawable.order_alpha_32)
                binding.btnOrderDate.setImageResource(R.drawable.order_num_32)
            } else {
                binding.btnOrderPlace.setImageResource(R.drawable.order_place_asc_32)
                binding.btnOrderTitle.setImageResource(R.drawable.order_alpha_32)
                binding.btnOrderDate.setImageResource(R.drawable.order_num_32)
                movieList = movieList.reversed()
            }
            ascDesc = !ascDesc
            placeAdapter()
        }

        result = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        {
            if (it.data != null && it.resultCode == 1) {
                loadList()
            } else if (it.data != null && it.resultCode == 0) {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.operacao_cancelada),
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
    }

    private fun placeAdapter() {
        adapter = MovieListAdapter(movieList, MovieOnClickListener { movie ->
            val i = intent
            val intent = Intent(applicationContext, MovieDetailActivity::class.java)
            intent.putExtra("id", movie.id)
            intent.putExtra("movie", movie)
            intent.putExtra("title", movie.title)
            intent.putExtra("date", movie.date)
            intent.putExtra("place", movie.place)
            intent.putExtra("year", movie.year)
            intent.putExtra("director", movie.director)
            intent.putExtra("cast1", movie.cast1)
            intent.putExtra("cast2", movie.cast2)
            intent.putExtra("cast3", movie.cast3)
            intent.putExtra("genre", movie.genre)
            intent.putExtra("duration", movie.duration)
            intent.putExtra("imdb", movie.imdb)
            intent.putExtra("plot", movie.plot)
            intent.putExtra("poster", movie.poster)
            intent.putExtras(i)

            result.launch(intent)
        })
        binding.recyclerViewMovies.adapter = adapter
    }

    private fun loadList() {
        movieList = dbHelper.getAllMovie().sortedWith(compareBy { it.date })
        placeAdapter()
    }
}