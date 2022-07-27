package com.saodev.ejemplomvvm.domain

import com.saodev.ejemplomvvm.data.QuoteRepository
import com.saodev.ejemplomvvm.data.database.entities.toDatabase
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {

  suspend operator fun invoke(): List<Quote> {
    val quotes = repository.getAllQuotesFromApi()

    return if (quotes.isNotEmpty()) {
      repository.clearQuotes()
      repository.insertQuotes(quotes.map { it.toDatabase() })
      quotes
    } else {
      repository.getAllQuotesFromDatabase()
    }
  }
}