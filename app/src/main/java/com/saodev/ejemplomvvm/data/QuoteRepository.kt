package com.saodev.ejemplomvvm.data

import com.saodev.ejemplomvvm.data.model.QuoteModel
import com.saodev.ejemplomvvm.data.model.QuoteProvider
import com.saodev.ejemplomvvm.data.network.QuoteService

class QuoteRepository {
  private val api = QuoteService()

  suspend fun getAllQuotes():List<QuoteModel> {
    val response = api.getQuotes()
    QuoteProvider.quotes = response
    return response
  }
}