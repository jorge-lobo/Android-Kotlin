package com.example.cineclube.adapter.listener

import com.example.cineclube.model.MovieModel

class MovieOnClickListener(val clickListener: (movie: MovieModel) -> Unit) {
    fun onClick(movie: MovieModel) = clickListener
}