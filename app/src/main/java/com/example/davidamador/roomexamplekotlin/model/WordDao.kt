package com.example.davidamador.roomexamplekotlin.model

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.example.davidamador.roomexamplekotlin.model.Word

@Dao
interface WordDao {

    @Insert//(onConflict = OnConflictStrategy.REPLACE) <- Si existe esa palabra cómo actuar, como es primaryKey aquí no pasa nada
    fun insert(word: Word)

    @Query("DELETE FROM word_table")
    fun deleteAll()

    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getAllWords(): LiveData<List<Word>>
}