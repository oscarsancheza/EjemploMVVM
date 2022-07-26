package com.saodev.ejemplomvvm.domain

import com.saodev.ejemplomvvm.data.QuoteRepository
import com.saodev.ejemplomvvm.data.model.QuoteModel
import com.saodev.ejemplomvvm.data.model.QuoteProvider

class GetRandomQuoteUseCase {

  private val repository = QuoteRepository()

  operator fun invoke(): QuoteModel? {
    val quotes = QuoteProvider.quotes
    if (!quotes.isNullOrEmpty()) {
      val randomNumber = (quotes.indices).shuffled().random()
      return quotes[randomNumber]
    }
    return null
  }
}