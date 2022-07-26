package com.saodev.ejemplomvvm.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.saodev.ejemplomvvm.databinding.ActivityMainBinding
import com.saodev.ejemplomvvm.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding
  private val quoteViewModel: QuoteViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    quoteViewModel.onCreate()

    quoteViewModel.quoteModel.observe(this) { currentQuote ->
      binding.tvQuote.text = currentQuote.quote
      binding.tvAuthor.text = currentQuote.author
    }

    quoteViewModel.isLoading.observe(this) {
      binding.progressBar.isVisible = it
    }

    binding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }
  }
}