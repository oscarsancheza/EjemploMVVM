package com.saodev.ejemplomvvm.domain

import com.saodev.ejemplomvvm.data.QuoteRepository
import com.saodev.ejemplomvvm.data.model.QuoteModel

class GetQuotesUseCase {

  private val repository = QuoteRepository()

  suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()
}