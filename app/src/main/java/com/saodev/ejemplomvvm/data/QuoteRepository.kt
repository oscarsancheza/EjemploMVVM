package com.saodev.ejemplomvvm.data

import com.saodev.ejemplomvvm.data.database.dao.QuoteDao
import com.saodev.ejemplomvvm.data.database.entities.QuoteEntity
import com.saodev.ejemplomvvm.data.network.QuoteService
import com.saodev.ejemplomvvm.domain.Quote
import com.saodev.ejemplomvvm.domain.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
  private val api: QuoteService,
  private val quoteDao: QuoteDao
) {

  suspend fun getAllQuotesFromApi(): List<Quote> {
    return api.getQuotes().map { it.toDomain() }
  }

  suspend fun getAllQuotesFromDatabase(): List<Quote> {
    return quoteDao.getAllQuotes().map { it.toDomain() }
  }

  suspend fun insertQuotes(quotes: List<QuoteEntity>) {
    quoteDao.insertAll(quotes)
  }

  suspend fun clearQuotes() {
    quoteDao.deleteAllQuotes()
  }
}