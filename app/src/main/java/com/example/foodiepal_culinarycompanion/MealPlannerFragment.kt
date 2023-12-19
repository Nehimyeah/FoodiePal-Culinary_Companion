package com.example.foodiepal_culinarycompanion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodiepal_culinarycompanion.adapter.MealPlannerAdapter
import com.example.foodiepal_culinarycompanion.adapter.RecipeAdapter
import com.example.foodiepal_culinarycompanion.model.MealPlan
import com.example.foodiepal_culinarycompanion.model.Recipe


class MealPlannerFragment : Fragment() {

    private lateinit var mealPlans: List<MealPlan>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mealPlans = listOf(
            MealPlan(
                "Vegetarian Pasta",
                listOf("Whole Wheat Pasta", "Tomato Sauce", "Broccoli", "Bell Peppers", "Parmesan Cheese"),
                "1. Cook pasta according to package instructions.\n2. Sauté broccoli and bell peppers.\n3. Mix with tomato sauce and serve with grated Parmesan."
            ),
            MealPlan(
                "Chicken Stir-Fry",
                listOf("Chicken Breast", "Soy Sauce", "Vegetables (Broccoli, Carrots, Bell Peppers)", "Garlic", "Ginger"),
                "1. Sauté chicken with garlic and ginger.\n2. Add chopped vegetables and soy sauce.\n3. Stir-fry until cooked and serve."
            ),
            MealPlan(
                "Quinoa Salad",
                listOf("Quinoa", "Cherry Tomatoes", "Cucumber", "Feta Cheese", "Olive Oil"),
                "1. Cook quinoa and let it cool.\n2. Mix with cherry tomatoes, cucumber, and feta cheese.\n3. Drizzle with olive oil and season to taste."
            ),
            MealPlan(
                "Vegan Buddha Bowl",
                listOf("Brown Rice", "Chickpeas", "Avocado", "Spinach", "Tahini Dressing"),
                "1. Cook brown rice and chickpeas.\n2. Arrange in a bowl with sliced avocado and spinach.\n3. Drizzle with tahini dressing."
            ),
            MealPlan(
                "Salmon with Asparagus",
                listOf("Salmon Fillet", "Asparagus", "Lemon", "Olive Oil", "Garlic"),
                "1. Bake salmon with asparagus, lemon, and garlic.\n2. Drizzle with olive oil and serve."
            )
        )
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_meal_planner, container, false)

        val rv = view.findViewById<RecyclerView>(R.id.meal_rv)
        rv.adapter = MealPlannerAdapter(mealPlans)
        rv.layoutManager = LinearLayoutManager(view.context)

        return view
    }


}