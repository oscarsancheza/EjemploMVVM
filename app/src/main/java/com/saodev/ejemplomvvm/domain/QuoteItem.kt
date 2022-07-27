package com.saodev.ejemplomvvm.domain

import com.saodev.ejemplomvvm.data.database.entities.QuoteEntity
import com.saodev.ejemplomvvm.data.model.QuoteModel

data class Quote(val quote: String, val author: String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)