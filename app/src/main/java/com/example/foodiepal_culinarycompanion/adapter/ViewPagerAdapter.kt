package com.example.foodiepal_culinarycompanion.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.foodiepal_culinarycompanion.AboutMeFragment
import com.example.foodiepal_culinarycompanion.BlogFragment
import com.example.foodiepal_culinarycompanion.ContactFragment
import com.example.foodiepal_culinarycompanion.MealPlannerFragment
import com.example.foodiepal_culinarycompanion.RecipesFragment

class ViewPagerAdapter(fm: FragmentManager, lc: Lifecycle) : FragmentStateAdapter(fm, lc) {
    override fun getItemCount() = 5

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> RecipesFragment()
            1 -> MealPlannerFragment()
            2 -> BlogFragment()
            3 -> ContactFragment()
            4 -> AboutMeFragment()
            else -> Fragment()
        }
    }
}