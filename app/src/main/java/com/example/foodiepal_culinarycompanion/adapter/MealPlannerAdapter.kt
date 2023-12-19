package com.example.foodiepal_culinarycompanion.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodiepal_culinarycompanion.R
import com.example.foodiepal_culinarycompanion.model.MealPlan

class MealPlannerAdapter(val mealPlans: List<MealPlan>) : RecyclerView.Adapter<MealPlannerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MealPlannerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.meal_plan_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealPlannerAdapter.ViewHolder, position: Int) {
        holder.title.text = mealPlans[position].title
//        holder.ingredients.apply {
//            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//            adapter = MealPlannerInnerAdapter(mealPlans[position].ingredients)
//        }
        holder.ingredients.text = mealPlans[position].ingredients.joinToString("\n","", "")
        holder.instruction.text = mealPlans[position].instruction
    }

    override fun getItemCount() = mealPlans.size

    inner class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView
        val ingredients: TextView
        val instruction: TextView

        init {
            title = itemView.findViewById(R.id.mealTitleTextView)
            ingredients = itemView.findViewById(R.id.ingredientsTextView)
            instruction = itemView.findViewById(R.id.instructionsTextView)
        }
    }
}