package com.saodev.ejemplomvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saodev.ejemplomvvm.model.QuoteModel
import com.saodev.ejemplomvvm.model.QuoteProvider

class QuoteViewModel : ViewModel() {

  val quoteModel = MutableLiveData<QuoteModel>()

  fun randomQuote() {
    val currentQuote: QuoteModel = QuoteProvider.random()
    quoteModel.postValue(currentQuote)
  }
}