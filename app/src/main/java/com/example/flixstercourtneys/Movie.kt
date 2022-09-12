package com.example.flixstercourtneys

import android.os.Parcelable
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize
import org.json.JSONArray

@Parcelize
class Movie(
    val movieID: Int,
    private val posterPath: String,
    val title: String,
    val overview: String,
) : Parcelable {
    @IgnoredOnParcel
    val posterImageURL = "https://image.tmdb.org/t/p/w342/$posterPath"

    companion object {
        fun fromJsonArray(movieJsonArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieJsonArray.length()) {
                val movieJson = movieJsonArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJson.getInt("id"),
                        movieJson.getString("poster_path"),
                        movieJson.getString("title"),
                        movieJson.getString("overview")
                    )
                )
            }
                return movies
            }
        }
}