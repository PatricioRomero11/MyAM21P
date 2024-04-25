package com.example.myam21p

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mypokedex.DetailActivity

class MainActivity : AppCompatActivity() {
    private lateinit var recView: RecyclerView
    private lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recView= findViewById(R.id.main_rv)
        recView.layoutManager= LinearLayoutManager(this)
        val dataSet = getListadoMovie()
        adapter=Adapter(applicationContext)
        recView.adapter=adapter
        adapter.submitList(dataSet)
        adapter.onItemClickListener = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name", it.name)
            intent.putExtra("image", it.poster)
            startActivity(intent)
        }
    }

    private fun getListadoMovie(): MutableList<Movie>? {
        return mutableListOf(
            Movie(1, "https://upload.wikimedia.org/wikipedia/en/b/b0/Avatar-Teaser-Poster.jpg",  "Avatar (2009)","James Cameron","Sam Worthington" ,MovieType.CIENCIA_FICCION),
            Movie(2, "https://upload.wikimedia.org/wikipedia/en/0/0d/Avengers_Endgame_poster.jpg",  "Avengers: Endgame (2019)","Anthony Russo","Robert Downey Jr." ,MovieType.ACCION),
            Movie(3, "https://upload.wikimedia.org/wikipedia/en/2/22/Titanic_poster.jpg",  "Titanic (1997)","James Cameron","Leonardo DiCaprio" ,MovieType.DRAMA),
            Movie(4, "https://upload.wikimedia.org/wikipedia/en/a/a2/Star_Wars_The_Force_Awakens_Theatrical_Poster.jpg",  "Star Wars (2015)","J.J. Abrams ","Daisy Ridley " ,MovieType.CIENCIA_FICCION),
            Movie(5, "https://upload.wikimedia.org/wikipedia/en/2/22/Titanic_poster.jpg",  "Jurassic World (2015)","Colin Trevorrow","Chris Pratt " ,MovieType.AVENTURA),
            Movie(6, "https://upload.wikimedia.org/wikipedia/en/9/9d/Teaser_poster_for_2019_film_The_Lion_King.jpg",  "El Rey León (2019)","Jon Favreau","Donald Glover" ,MovieType.ANIMACION),
            Movie(7, "https://upload.wikimedia.org/wikipedia/en/0/0d/Avengers_Endgame_poster.jpg",  "Avengers: Endgame (2019)","Anthony Russo","Robert Downey Jr." ,MovieType.ACCION),
            Movie(8, "https://upload.wikimedia.org/wikipedia/en/a/a2/Star_Wars_The_Force_Awakens_Theatrical_Poster.jpg",  "Star Wars (2015)","J.J. Abrams ","Daisy Ridley " ,MovieType.CIENCIA_FICCION),
            Movie(9, "https://upload.wikimedia.org/wikipedia/en/0/0d/Avengers_Endgame_poster.jpg",  "Avengers: Endgame (2019)","Anthony Russo","Robert Downey Jr." ,MovieType.ACCION),
            Movie(10, "https://upload.wikimedia.org/wikipedia/en/a/a2/Star_Wars_The_Force_Awakens_Theatrical_Poster.jpg",  "Star Wars (2015)","J.J. Abrams ","Daisy Ridley " ,MovieType.CIENCIA_FICCION),
            Movie(11, "https://upload.wikimedia.org/wikipedia/en/0/0d/Avengers_Endgame_poster.jpg",  "Avengers: Endgame (2019)","Anthony Russo","Robert Downey Jr." ,MovieType.ACCION),
            Movie(12, "https://upload.wikimedia.org/wikipedia/en/a/a2/Star_Wars_The_Force_Awakens_Theatrical_Poster.jpg",  "Star Wars (2015)","J.J. Abrams ","Daisy Ridley " ,MovieType.CIENCIA_FICCION),
            Movie(13, "https://upload.wikimedia.org/wikipedia/en/0/0d/Avengers_Endgame_poster.jpg",  "Avengers: Endgame (2019)","Anthony Russo","Robert Downey Jr." ,MovieType.ACCION),
            Movie(14, "https://upload.wikimedia.org/wikipedia/en/a/a2/Star_Wars_The_Force_Awakens_Theatrical_Poster.jpg",  "Star Wars (2015)","J.J. Abrams ","Daisy Ridley " ,MovieType.CIENCIA_FICCION),
            Movie(15, "https://upload.wikimedia.org/wikipedia/en/0/0d/Avengers_Endgame_poster.jpg",  "Avengers: Endgame (2019)","Anthony Russo","Robert Downey Jr." ,MovieType.ACCION),

            )
    }
}