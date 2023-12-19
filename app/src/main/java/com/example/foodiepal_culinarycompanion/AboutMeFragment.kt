package com.example.foodiepal_culinarycompanion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.foodiepal_culinarycompanion.databinding.FragmentAboutMeBinding


class AboutMeFragment : Fragment(), AddInfoBottomSheetFragment.BottomSheetListener {
    private lateinit var binding: FragmentAboutMeBinding;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutMeBinding.inflate(inflater, container, false)
        binding.aboutRv.adapter = ArrayAdapter(binding.root.context, android.R.layout.simple_list_item_1, listOf("Nehi", "Aman", "Tefera"))

        binding.fab.setOnClickListener {
            val bottomSheetFragment = AddInfoBottomSheetFragment(this)
            bottomSheetFragment.show(childFragmentManager, bottomSheetFragment.tag)
        }
        return binding.root
    }

    override fun onAddInfoClicked(info: String) {
        TODO("Not yet implemented")
        Toast.makeText(context, info, Toast.LENGTH_SHORT).show()
    }
}