package com.example.appbatch31

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class HomeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")

        Log.d("INTENT","${email} and ${password}")
    }
}