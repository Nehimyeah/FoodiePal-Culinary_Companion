package com.example.foodiepal_culinarycompanion

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.foodiepal_culinarycompanion.databinding.ActivityAddRecipeBinding
import com.example.foodiepal_culinarycompanion.model.Recipe

class AddRecipe : AppCompatActivity() {
    private lateinit var binding: ActivityAddRecipeBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            var recipe = Recipe(
                1,
                binding.editTextCookingTime.text.toString(),
                binding.editTextRating.text.toString().toInt(),
                binding.editTextTitle.text.toString(),
                binding.editTextDescription.text.toString()
                )
            var intent = Intent()
            intent.putExtra("recipe", recipe)
            setResult(Activity.RESULT_OK, intent)
            finish();
        }

    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        super.onBackPressed()
    }


}