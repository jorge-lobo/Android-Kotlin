package com.example.cineclube.model

import android.os.Parcel
import android.os.Parcelable

data class MovieModel(
    val id: Int = 0,
    val title: String = "",
    val date: String = "",
    val place: String = "",
    val poster: String = "",
    val year: Int = 0,
    val director: String = "",
    val cast1: String = "",
    val cast2: String = "",
    val cast3: String = "",
    val genre: String = "",
    val duration: Int = 0,
    val imdb: Double = 0.0,
    val plot: String = ""

) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(date)
        parcel.writeString(place)
        parcel.writeString(poster)
        parcel.writeInt(year)
        parcel.writeString(director)
        parcel.writeString(cast1)
        parcel.writeString(cast2)
        parcel.writeString(cast3)
        parcel.writeString(genre)
        parcel.writeInt(duration)
        parcel.writeDouble(imdb)
        parcel.writeString(plot)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieModel> {
        override fun createFromParcel(parcel: Parcel): MovieModel {
            return MovieModel(parcel)
        }

        override fun newArray(size: Int): Array<MovieModel?> {
            return arrayOfNulls(size)
        }
    }
}