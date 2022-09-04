package com.example.android.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.android.R
import com.example.android.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getArticles()

        viewModel.response.observe(this) { result ->
            when (result) {
                is Resource.Success -> {
                    Toast.makeText(this, "num_results: ${result.data?.num_results}", Toast.LENGTH_SHORT).show()
                }
                is Resource.Error -> {
                    Toast.makeText(this, result.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {

                }
            }
        }
    }
}