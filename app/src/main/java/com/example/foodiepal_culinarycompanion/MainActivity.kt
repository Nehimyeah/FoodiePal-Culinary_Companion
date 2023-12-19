package com.example.foodiepal_culinarycompanion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodiepal_culinarycompanion.adapter.ViewPagerAdapter
import com.example.foodiepal_culinarycompanion.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adp = ViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.pager.adapter = adp

        TabLayoutMediator(binding.tlayout, binding.pager) { tab, position ->
            when(position) {
                0 -> tab.text = "Recipe"
                1 -> tab.text = "Meal Planner"
                2 -> tab.text = "Blog"
                3 -> tab.text = "Contact"
                4 -> tab.text = "About Me"
            }
        }.attach()

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.recipe -> binding.pager.setCurrentItem(0, true)
                R.id.meal_planner -> binding.pager.setCurrentItem(1, true)
                R.id.blog -> binding.pager.setCurrentItem(2, true)
            }
            true
        }
    }
}