package com.example.recyler_view_1.entities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ort.movieapp.R
import com.ort.movieapp.entities.Movie

class RecipeAdapter (
    var recipeList : MutableList <Recipe>,
    var onClick : (Int) -> Unit
) : RecyclerView.Adapter<RecipeAdapter.RecipeHolder>() {

    class RecipeHolder (v: View) : RecyclerView.ViewHolder(v) {
        private var view: View
        init {
            this.view = v
        }
        fun setTitle (title : String){
            var txtTitle : TextView = view.findViewById(R.id.txtTitle)
            txtTitle.text = title
        }

        fun setDescription (description : String) : CardView {
            var txtDescription : TextView = view.findViewById(R.id.txtDescription)
            txtDescription.text = description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.recipe_item,parent,false)
        return (RecipeHolder(view))
    }

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {
        holder.setTitle(recipeList[position].title)
        holder.setDescription(recipeList[position].description)
        }
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

}