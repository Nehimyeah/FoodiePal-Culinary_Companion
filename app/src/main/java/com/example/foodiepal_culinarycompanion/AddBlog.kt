package com.example.foodiepal_culinarycompanion

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodiepal_culinarycompanion.databinding.ActivityAddBlogBinding
import com.example.foodiepal_culinarycompanion.model.Blog
import java.time.LocalDate

class AddBlog : AppCompatActivity() {

    private lateinit var binding: ActivityAddBlogBinding;
    private lateinit var prefs: SharedPreferences;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBlogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)


        binding.btnCreateBlog.setOnClickListener {
            var blog = prefs.getString("username", "")?.let { it1 ->
                Blog(
                    binding.editTextTitle.text.toString(),
                    LocalDate.now(),
                    binding.editTextContent.text.toString(),
                    it1,
                    mutableListOf()
                )
            }
            var intent = Intent()
            intent.putExtra("blog", blog)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        super.onBackPressed()
    }
}