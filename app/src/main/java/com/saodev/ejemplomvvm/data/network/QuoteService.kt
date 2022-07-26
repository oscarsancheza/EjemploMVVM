package com.saodev.ejemplomvvm.data.network

import com.saodev.ejemplomvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteService @Inject constructor(private val api: QuoteApiClient) {

  suspend fun getQuotes(): List<QuoteModel> {
    return withContext(Dispatchers.IO) {
      val response = api.getAllQuotes()
      response.body() ?: emptyList()
    }
  }

}