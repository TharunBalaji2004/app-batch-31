package com.example.appbatch31

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.appbatch31.databinding.ActivityCounterBinding
import com.example.appbatch31.viewmodels.CounterViewModel

// View -> Activity -> (4 Fragments)

// onCreate -> onStart -> onResume -> onPause -> onStop -> onDestroy
// Counter  0

// 3 methods
// 1. Modify in manifest file
// 2. SavedInstanceState (preferred)
// 3. VieModel (best)

class CounterActivity: AppCompatActivity() {

    private lateinit var binding: ActivityCounterBinding
    private val viewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.counter.observe(this) {
            binding.tvCounter.text = it.toString()
        }

        binding.btnClick.setOnClickListener {
            viewModel.addCount()
        }
    }

}

