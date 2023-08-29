package com.example.cineclube.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cineclube.R
import com.example.cineclube.adapter.listener.MovieOnClickListener
import com.example.cineclube.adapter.viewholder.MovieViewHolder
import com.example.cineclube.model.MovieModel
import java.text.SimpleDateFormat
import java.util.Locale

class MovieListAdapter(
    private val movieList: List<MovieModel>,
    private val movieOnClickListener: MovieOnClickListener

) : RecyclerView.Adapter<MovieViewHolder>() {

    private val movieImageNameMap = hashMapOf(
        1 to R.drawable.p1,
        2 to R.drawable.p2,
        3 to R.drawable.p3,
        4 to R.drawable.p4,
        5 to R.drawable.p5,
        6 to R.drawable.p6,
        7 to R.drawable.p7,
        8 to R.drawable.p8,
        9 to R.drawable.p9,
        10 to R.drawable.p10,
        11 to R.drawable.p11,
        12 to R.drawable.p12,
        13 to R.drawable.p13,
        14 to R.drawable.p14,
        15 to R.drawable.p15,
        16 to R.drawable.p16,
        17 to R.drawable.p17,
        18 to R.drawable.p18,
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]

        holder.textTitle.text = movie.title
        holder.textDate.text = formatDate(movie.date)
        holder.textPlace.text = movie.place

        val imageResource = movieImageNameMap[movie.id]
        imageResource?.let {
            holder.imagePoster.setImageResource(it)
        } ?: run {
            holder.imagePoster.setImageResource(R.drawable.p_default)
        }

        holder.itemView.setOnClickListener()
        {
            movieOnClickListener.clickListener(movie)
        }
    }

    private fun formatDate(date: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val outputFormat = SimpleDateFormat("d MMMM", Locale.getDefault())
        val parsedDate = inputFormat.parse(date)
        return outputFormat.format(parsedDate)
    }
}