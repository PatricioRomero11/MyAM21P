package com.example.myam21p

import android.media.Image
import java.net.URL

data class Movie(
        val id: Int,
        val poster: String,
        val name: String,
        val director: String,
        val actor: String,
        val type: MovieType,

)

enum class MovieType{
    ACCION,DRAMA, CIENCIA_FICCION, ANIMACION, AVENTURA
}