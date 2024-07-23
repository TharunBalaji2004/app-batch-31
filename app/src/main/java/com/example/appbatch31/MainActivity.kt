package com.example.appbatch31

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

// Activity -> Screen

// Get the user input
// STEP1: Assign unique id to UI Components
// STEP2 : Declare UI variables
// STEP3: Get the ids of components

class MainActivity : AppCompatActivity() {

    // Declaration
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("LIFECYCLE", "onCreate() function called")

        // Definition
        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
        btnLogin = findViewById(R.id.btn_login)

        btnLogin.setOnClickListener {
            val emailAddress = etEmail.text.toString()
            val password = etPassword.text.toString()
            Log.d("INPUT", "Email: ${emailAddress} Password: ${password}")

            // Intent (Java Android) -> This activity, Target Activity
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("email", emailAddress)
            intent.putExtra("password", password)

            // Stack -> [MainActivity]
            startActivity(intent)
            // Stack -> [MainActivity, HomeActivity]
            finish()
            // Stack -> [E]
        }
    }

    override fun onStart() {
        super.onStart()

        Log.d("LIFECYCLE", "onStart() function called")
    }

    override fun onResume() {
        super.onResume()

        Log.d("LIFECYCLE", "onResume() function called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LIFECYCLE", "onPause() function called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LIFECYCLE", "onStop() function called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LIFECYCLE", "onRestart() function called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LIFECYCLE", "onDestroy() function called")
    }
}


// XML Components -> TextView, EditText, Button