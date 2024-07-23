package com.example.appbatch31

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.appbatch31.databinding.ActivityHomeBinding
import com.example.appbatch31.databinding.ActivityMainBinding

class HomeActivity: AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val sharedPreferences = getSharedPreferences("sample", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        binding.btnLogout.setOnClickListener {
            editor.remove("login")
            editor.clear()
            editor.apply()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}