package com.esma.movieapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class GenreXX(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)