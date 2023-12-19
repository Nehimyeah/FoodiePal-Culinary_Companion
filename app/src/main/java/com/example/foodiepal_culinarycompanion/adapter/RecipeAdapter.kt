package com.example.foodiepal_culinarycompanion.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodiepal_culinarycompanion.R
import com.example.foodiepal_culinarycompanion.model.Recipe

class RecipeAdapter(val recipes: List<Recipe>) : RecyclerView.Adapter<RecipeAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeAdapter.MyViewHolder, position: Int) {
        holder.bannerImage.setImageResource(R.drawable.default_recipe_image)
        holder.title.text = recipes[position].title
        holder.description.text = recipes[position].description
        holder.timeToCook.text = recipes[position].cookingTime
        holder.rating.text = recipes[position].rating.toString()
    }

    override fun getItemCount() = recipes.size

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bannerImage: ImageView;
        val title: TextView
        val description: TextView
        val timeToCook: TextView
        val rating: TextView
        init {
            bannerImage = itemView.findViewById(R.id.recipeImageView)
            title = itemView.findViewById(R.id.recipeTitleTextView)
            description = itemView.findViewById(R.id.recipeDescriptionTextView)
            timeToCook = itemView.findViewById(R.id.timeToCookTextView)
            rating = itemView.findViewById(R.id.ratingTextView)
        }
    }
}