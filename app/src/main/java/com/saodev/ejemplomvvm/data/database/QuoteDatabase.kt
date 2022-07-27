package com.saodev.ejemplomvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.saodev.ejemplomvvm.data.database.dao.QuoteDao
import com.saodev.ejemplomvvm.data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {

  abstract fun getQuoteDao(): QuoteDao
}