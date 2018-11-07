package com.example.davidamador.roomexamplekotlin.domain

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread
import com.example.davidamador.roomexamplekotlin.model.Word
import com.example.davidamador.roomexamplekotlin.model.WordDao

class WordRepository(private val wordDao: WordDao) {
    val allWords: LiveData<List<Word>> = wordDao.getAllWords()

    //LA inserción tiene que ser hecha en otro hilo, con @WorkerThread nos aseguramos que la llamada a
    //este método tiene que ser en otro hilo, con suspend le decimos al compilador que necesita ser llamado con una
    //corutina u otro método de suspensión
    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}