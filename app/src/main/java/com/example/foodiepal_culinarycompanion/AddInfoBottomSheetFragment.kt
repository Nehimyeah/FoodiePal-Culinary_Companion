package com.example.foodiepal_culinarycompanion// AddInfoBottomSheetFragment.kt

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodiepal_culinarycompanion.databinding.FragmentAddInfoBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AddInfoBottomSheetFragment(private var listener: BottomSheetListener) : BottomSheetDialogFragment() {

    interface BottomSheetListener {
        fun onAddInfoClicked(info: String)
    }

    private lateinit var binding: FragmentAddInfoBottomSheetBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentAddInfoBottomSheetBinding.inflate(inflater, container, false)

        Log.i("nehi", binding.btnAddInfo.text.toString())
        binding.btnAddInfo.setOnClickListener {
            Log.i("Nehi", "happening")
            val info = binding.editTextInfo.text.toString().trim()
            if (info.isNotEmpty()) {
                Log.i("Nehi", info)
                listener.onAddInfoClicked(info)
                dismiss()
            } else {
                binding.editTextInfo.error = "Please enter information"
            }
        }
        return inflater.inflate(R.layout.fragment_add_info_bottom_sheet, container, false)
    }
}
