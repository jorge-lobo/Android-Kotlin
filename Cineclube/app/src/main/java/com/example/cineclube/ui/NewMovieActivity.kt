package com.example.cineclube.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.cineclube.R
import com.example.cineclube.database.MovieDBHelper
import com.example.cineclube.databinding.ActivityNewMovieBinding

class NewMovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewMovieBinding
    private lateinit var launcher: ActivityResultLauncher<Intent>
    private var id: Int? = -1
    private var poster: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent
        val dbHelper = MovieDBHelper(this)

        binding.btnCancel.setOnClickListener {
            setResult(0, i)
            finish()
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
                sendID(poster)

                val insertedId = dbHelper.insertMovie(
                    title, date, place, poster, year, director, cast1, cast2, cast3,
                    genre, duration, imdb, plot
                )

                if (insertedId != -1L) {
                    Toast.makeText(
                        this,
                        getString(R.string.filme_adicionado_com_sucesso),
                        Toast.LENGTH_SHORT
                    ).show()
                    setResult(1, i)
                    finish()
                } else {
                    Toast.makeText(
                        this,
                        getString(R.string.erro_ao_adicionar_filme),
                        Toast.LENGTH_SHORT
                    ).show()
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

    private fun sendID(poster: String) {
        val i = intent
        i.putExtra("poster", poster)
        setResult(1, i)
    }
}




