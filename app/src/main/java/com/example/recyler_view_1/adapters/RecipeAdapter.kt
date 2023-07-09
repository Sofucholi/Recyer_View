package com.example.recyler_view_1.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyler_view_1.R
import com.example.recyler_view_1.entities.Recipe


class RecipeAdapter (
    var recipeList : MutableList <Recipe>,
    val context: Context,
    var onClick : (Int) -> Unit
) : RecyclerView.Adapter<RecipeAdapter.RecipeHolder>() {

    class RecipeHolder (v: View) : RecyclerView.ViewHolder(v) {
        private var view: View
        init {
            this.view = v
        }
        fun setName(name: String) {
            val txt: TextView = view.findViewById(R.id.txt_name_item)
            txt.text = name
        }

        fun getCardLayout ():CardView{
            return view.findViewById(R.id.card_package_item)
        }
        //
//
        fun getImageView () : ImageView {
            return view.findViewById(R.id.img_item)
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.recipe_item,parent,false)
        return (RecipeHolder(view))
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {
        holder.setName(recipeList[position].nombre)

        Glide
            .with(context)
            .load(recipeList[position].url)
            .centerInside()
            .into(holder.getImageView());
//
        holder.getCardLayout().setOnClickListener  () {
            onClick(position)
        }
        }
}