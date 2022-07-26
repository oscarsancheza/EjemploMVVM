package com.saodev.ejemplomvvm.domain

import com.saodev.ejemplomvvm.data.model.QuoteModel
import com.saodev.ejemplomvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val quoteProvider: QuoteProvider) {

  operator fun invoke(): QuoteModel? {
    val quotes = quoteProvider.quotes
    if (!quotes.isNullOrEmpty()) {
      val randomNumber = (quotes.indices).shuffled().random()
      return quotes[randomNumber]
    }
    return null
  }
}