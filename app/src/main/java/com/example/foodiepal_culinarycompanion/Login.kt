package com.example.foodiepal_culinarycompanion

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.foodiepal_culinarycompanion.databinding.ActivityLoginBinding
import com.example.foodiepal_culinarycompanion.model.User

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var prefs: SharedPreferences
    private val users: MutableList<User> = mutableListOf(
        User("nehimyeah", "nehemiaha1@outlook.com", "1", "Nehemiah", "Tefera"),
        User("ruth", "ruti@gmail.com", "1", "Ruth", "Tefera")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater);
        setContentView(binding.root)

        prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        if (prefs.getBoolean("isLoggedIn", false)) {
            startHomeActivity()
            finish()
        }
        binding.btnLogin.setOnClickListener {
            val username = binding.editTextUsername.text.toString()
            val pass = binding.editTextPassword.text.toString()

            if (authentic(username, pass)) {
                saveLoginState(true)
                saveUserInfo(username)
                startHomeActivity()
            }
        }
    }

    private fun saveUserInfo(username: String) {
        val editor = prefs.edit()
        editor.putString("username", username)
        editor.apply()
    }

    private fun saveLoginState(isLoggedIn: Boolean) {
        val editor = prefs.edit()
        editor.putBoolean("isLoggedIn", isLoggedIn)
        editor.apply()
    }

    private fun authentic(username: String, pass: String): Boolean {
        val user = users.filter { it.username == username && it.password == pass }
        return user.isNotEmpty()
    }

    private fun startHomeActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}