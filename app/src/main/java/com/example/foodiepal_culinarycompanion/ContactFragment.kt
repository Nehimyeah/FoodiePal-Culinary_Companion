package com.example.foodiepal_culinarycompanion

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment


class ContactFragment : Fragment(), OnClickListener {
    private lateinit var phone: TextView
    private lateinit var email: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_contact, container, false)
        phone = view.findViewById(R.id.phoneNumberTextView)
        phone.setOnClickListener(this)
        email = view.findViewById(R.id.emailAddressTextView)
        email.setOnClickListener(this)

        return view
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.phoneNumberTextView -> {
                val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 2063219547))
                startActivity(dialIntent)
            }
            R.id.emailAddressTextView -> {
                val emailIntent = Intent(Intent.ACTION_SENDTO)
                emailIntent.data = Uri.parse("mailto:nehemiah.tefera1@gmail.com")
                startActivity(emailIntent)
            }
        }
    }
}