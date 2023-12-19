package com.example.foodiepal_culinarycompanion

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodiepal_culinarycompanion.adapter.RecipeAdapter
import com.example.foodiepal_culinarycompanion.databinding.FragmentRecipesBinding
import com.example.foodiepal_culinarycompanion.model.Recipe


class RecipesFragment : Fragment() {

    private lateinit var recipes: MutableList<Recipe>
    private lateinit var binding: FragmentRecipesBinding
    private lateinit var recipeAdapter: RecipeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        recipes = mutableListOf(
            Recipe(R.drawable.default_recipe_image, "5 mins", 4, "Curry",
                "This is an amazing Indian dish"),
            Recipe(R.drawable.default_recipe_image, "5 mins", 4, "Curry",
                "This is an amazing Indian dish"),
            Recipe(R.drawable.default_recipe_image, "5 mins", 4, "Curry",
                "This is an amazing Indian dish"),
            Recipe(R.drawable.default_recipe_image, "5 mins", 4, "Curry",
                "This is an amazing Indian dish"),
            Recipe(R.drawable.default_recipe_image, "5 mins", 4, "Curry",
                "This is an amazing Indian dish"),
            Recipe(R.drawable.default_recipe_image, "5 mins", 4, "Curry",
                "This is an amazing Indian dish"),
            Recipe(R.drawable.default_recipe_image, "5 mins", 4, "Curry",
                "This is an amazing Indian dish"),
            Recipe(R.drawable.default_recipe_image, "5 mins", 4, "Curry",
                "This is an amazing Indian dish"),
            Recipe(R.drawable.default_recipe_image, "5 mins", 4, "Curry",
                "This is an amazing Indian dish"),
            Recipe(R.drawable.default_recipe_image, "5 mins", 4, "Curry",
                "This is an amazing Indian dish"),
        )

        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_recipes, container, false)
        binding = FragmentRecipesBinding.inflate(inflater, container, false)

        recipeAdapter = RecipeAdapter(recipes)
        binding.recipeRV.adapter = recipeAdapter
        binding.recipeRV.layoutManager = LinearLayoutManager(context)

        binding.fab.setOnClickListener {
            var intent = Intent(context, AddRecipe::class.java)
            resultContract.launch(intent)
        }
        return binding.root
    }

    private var resultContract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            val recipe = it.data?.getSerializableExtra("recipe") as Recipe
            recipes.add(recipe)
            recipeAdapter.notifyItemInserted(recipes.size - 1)
            Toast.makeText(context, recipe.toString(), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "No User data given", Toast.LENGTH_SHORT).show()
        }
    }
}