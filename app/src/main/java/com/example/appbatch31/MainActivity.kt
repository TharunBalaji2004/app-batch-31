package com.example.appbatch31

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appbatch31.databinding.ActivityMainBinding


// DAY 3 Agenda
// 1. State Management
// 2. State Preserve
// 3. MVVM Architecture
// 4. Fragments and Navigation


// DAY 2 Agenda
// 1. ViewBinding
// 2. Toast
// 3. Login Page (with Splash Screen)
// 4. Shared Preferences {key, value} login -> true

// View Binding -> Reads XML file -> Stores References -> Binding Class (etPassword)

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // STEP 1: Create instance for sharedPreferences
        val sharedPreferences = getSharedPreferences("sample", Context.MODE_PRIVATE)
        // STEP 2: Create editor instance for sharedPreferences
        val editor = sharedPreferences.edit()

        // STEP 5: Get the stored value from shared preferences
        val isLogin = sharedPreferences.getBoolean("login", false)
        if (isLogin) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnLogin.setOnClickListener {
            val emailAddress = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if (formValidation(emailAddress, password)) {
                // STEP 3: Add data
                editor.putBoolean("login", true)
                editor.putString("email", emailAddress)

                // STEP 4: Commit the data
                editor.apply()

                Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Login Unsuccessful", Toast.LENGTH_LONG).show()
            }

        }
    }

    private fun formValidation(email: String, password: String): Boolean {
        var valid = true

        // Check -> 1. Empty or Blank -> 2. Email structure valid

        val emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$".toRegex()

        if (email.isBlank()) {
            valid = false
            binding.tvErrorEmail.text = "Email address cannot be empty"
        } else if (!email.matches(emailRegex)) {
            valid = false
            binding.tvErrorEmail.text = "Invalid Email"
        } else {
            binding.tvErrorEmail.text = ""
        }

        if (password.isBlank()) {
            valid = false
            binding.tvErrorPassword.text = "Password cannot be empty"
        } else {
            binding.tvErrorPassword.text = ""
        }

        return valid
    }
}


// (1st) Splash Screen -> (2nd) Home Screen