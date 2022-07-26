package com.saodev.ejemplomvvm.data

import com.saodev.ejemplomvvm.data.model.QuoteModel
import com.saodev.ejemplomvvm.data.model.QuoteProvider
import com.saodev.ejemplomvvm.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
  private val api: QuoteService,
  private val quoteProvider: QuoteProvider
) {

  suspend fun getAllQuotes(): List<QuoteModel> {
    val response = api.getQuotes()
    quoteProvider.quotes = response
    return response
  }
}