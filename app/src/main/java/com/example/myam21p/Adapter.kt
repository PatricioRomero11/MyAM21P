package com.example.myam21p
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class Adapter(val context: Context) : ListAdapter<Movie, Adapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener: (Movie) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val nombreElem: TextView = view.findViewById(R.id.item_name)
        val imageElem: ImageView = view.findViewById(R.id.item_img) // Poster Imagen
        val directorElem: TextView = view.findViewById(R.id.item_director)
        val actorElem: TextView = view.findViewById(R.id.item_actor)
        val typeElem: ImageView = view.findViewById(R.id.item_type) //Genero Imagen


        fun bind (mv: Movie) {
            nombreElem.text=mv.name
            directorElem.text=mv.director
            actorElem.text=mv.actor


            Glide.with(context).load(mv.type).into(typeElem)



            val image = when(mv.type) {
                MovieType.ACCION -> R.drawable.accion
                MovieType.ANIMACION -> R.drawable.animacion
                MovieType.AVENTURA -> R.drawable.aventura
                MovieType.CIENCIA_FICCION -> R.drawable.ficcion
                MovieType.DRAMA -> R.drawable.drama
                else -> R.drawable.drama
            }

            typeElem.setImageResource(image)

            view.setOnClickListener() {
                onItemClickListener(mv)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.items_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }
}