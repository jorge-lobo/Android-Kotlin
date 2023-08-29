package com.example.cineclube.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.cineclube.R
import com.example.cineclube.database.MovieDBHelper
import com.example.cineclube.databinding.ActivityEditMovieBinding
import com.example.cineclube.model.MovieModel

class EditMovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditMovieBinding
    private lateinit var db: MovieDBHelper
    private lateinit var launcher: ActivityResultLauncher<Intent>
    private var movieModel = MovieModel()
    private var poster: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent
        val id = i.extras?.getInt("id")

        db = MovieDBHelper(applicationContext)

        val movie = intent.getParcelableExtra<MovieModel>("movie")
        if (movie != null) {
            movieModel = movie
            populate()
        } else {
            finish()
        }

        binding.imagePoster.setOnClickListener {
            launcher.launch(
                Intent(
                    applicationContext,
                    MovieImageSelectionActivity::class.java
                )
            )
        }

        binding.btnCancel.setOnClickListener {
            setResult(0, i)
            finish()
        }

        binding.btnDelete.setOnClickListener {
            val res = db.deleteMovie(movieModel.id)

            if (res > 0) {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.filme_eliminado_com_sucesso),
                    Toast.LENGTH_SHORT
                ).show()
                setResult(1, i)
                finish()
            } else {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.erro_ao_eliminar_filme),
                    Toast.LENGTH_SHORT
                ).show()
                setResult(0, i)
                finish()
            }
        }

        binding.btnSave.setOnClickListener {
            val title = binding.editTitle.text.toString()
            val date = binding.editDate.text.toString()
            val place = binding.editPlace.text.toString()
            val yearText = binding.editYear.text.toString()
            val year = try {
                yearText.toInt()
            } catch (e: NumberFormatException) {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.valor_invalido),
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            val director = binding.editDirector.text.toString()
            val cast1 = binding.editCast1.text.toString()
            val cast2 = binding.editCast2.text.toString()
            val cast3 = binding.editCast3.text.toString()
            val genre = binding.editGenre.text.toString()
            val durationText = binding.editDuration.text.toString()
            val duration = try {
                durationText.toInt()
            } catch (e: NumberFormatException) {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.valor_invalido),
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            val imdbText = binding.editImdb.text.toString()
            val imdb = try {
                imdbText.toDouble()
            } catch (e: NumberFormatException) {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.valor_invalido),
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            val plot = binding.editPlot.text.toString()

            if (title.isNotEmpty() && date.isNotEmpty() && place.isNotEmpty() &&
                year.toString().isNotEmpty() && director.isNotEmpty() && cast1.isNotEmpty() &&
                cast2.isNotEmpty() && cast3.isNotEmpty() && genre.isNotEmpty() &&
                duration.toString().isNotEmpty() && imdb.toString()
                    .isNotEmpty() && plot.isNotEmpty()
            ) {
                val insertedId = db.updateMovie(
                    movieModel.id, title, date, place, poster, year, director, cast1, cast2, cast3,
                    genre, duration, imdb, plot
                )

                if (insertedId > 0) {
                    Toast.makeText(
                        this,
                        getString(R.string.filme_editado_com_sucesso),
                        Toast.LENGTH_SHORT
                    ).show()
                    setResult(1, i)
                    finish()
                } else {
                    Toast.makeText(
                        this,
                        getString(R.string.erro_ao_editar_filme),
                        Toast.LENGTH_SHORT
                    ).show()
                    setResult(0, i)
                    finish()
                }
            } else {
                Toast.makeText(
                    this,
                    getString(R.string.preencha_todos_os_campos),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.imagePoster.setOnClickListener {
            launcher.launch(
                Intent(
                    applicationContext,
                    MovieImageSelectionActivity::class.java
                )
            )
        }

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.data != null && it.resultCode == 1) {
                poster = it.data?.extras?.getString("poster") ?: ""
                if (poster.isNotEmpty()) {
                    val resourceId = resources.getIdentifier(poster, "drawable", packageName)
                    if (resourceId != 0) {
                        binding.imagePoster.setImageResource(resourceId)
                    } else {
                        binding.imagePoster.setImageResource(R.drawable.p_default)
                    }
                } else {
                    binding.imagePoster.setImageResource(R.drawable.p_default)
                }
            } else {
                binding.imagePoster.setImageResource(R.drawable.p_default)
            }
        }
    }

    private fun populate() {
        binding.editTitle.setText(movieModel.title)
        binding.editDate.setText(movieModel.date)
        binding.editPlace.setText(movieModel.place)
        binding.editYear.setText(movieModel.year.toString())
        binding.editDirector.setText(movieModel.director)
        binding.editCast1.setText(movieModel.cast1)
        binding.editCast2.setText(movieModel.cast2)
        binding.editCast3.setText(movieModel.cast3)
        binding.editGenre.setText(movieModel.genre)
        binding.editDuration.setText(movieModel.duration.toString())
        binding.editImdb.setText(movieModel.imdb.toString())
        binding.editPlot.setText(movieModel.plot)

        if (movieModel.poster.isNotEmpty()) {
            val posterResourceId =
                resources.getIdentifier(movieModel.poster, "drawable", packageName)
            if (posterResourceId != 0) {
                poster = movieModel.poster
                binding.imagePoster.setImageResource(posterResourceId)
            } else {
                binding.imagePoster.setImageResource(R.drawable.p_default)
            }
        } else {
            binding.imagePoster.setImageResource(R.drawable.p_default)
        }
    }
}