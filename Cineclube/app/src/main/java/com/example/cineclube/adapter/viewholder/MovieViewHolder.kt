package com.example.cineclube.adapter.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cineclube.R

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val imagePoster: ImageView = view.findViewById(R.id.image_poster)
    val textTitle: TextView = view.findViewById(R.id.text_title)
    val textDate: TextView = view.findViewById(R.id.text_date)
    val textPlace: TextView = view.findViewById(R.id.text_place)

}

