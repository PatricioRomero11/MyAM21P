package com.example.mypokedex

import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.myam21p.R

class DetailActivity : AppCompatActivity() {
    lateinit var textViewName: TextView
    lateinit var url: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val bundle = intent.extras
        val nombre = bundle?.getString("name")
        val imagen = bundle?.getString("image")
        textViewName = findViewById(R.id.textViewName)
        url = findViewById(R.id.imageView)
        textViewName.text = nombre
        Glide.with(applicationContext).load(imagen).into(url)
    }
}