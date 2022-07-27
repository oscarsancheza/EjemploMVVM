package com.saodev.ejemplomvvm.domain

import com.saodev.ejemplomvvm.data.QuoteRepository
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val quoteRepository: QuoteRepository) {

  suspend operator fun invoke(): Quote? {
    val quotes = quoteRepository.getAllQuotesFromDatabase()
    if (quotes.isNotEmpty()) {
      val randomNumber = (quotes.indices).random()
      return quotes[randomNumber]
    }
    return null
  }
}