package com.example.room.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao                                // DataAccessObject интефейс, педоставляющий доступ (абстрактный) к базе данных
interface NoteDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)        // стратегия замены элементов с одинаковыми id
    suspend fun insertItem(note: Note)        // запрос выполняется в фоновом (дополнительном) потоке
    @Delete
    suspend fun deleteItem(note: Note)        // весь элемент вместо id
    @Query("SELECT * FROM note_grid")   // шалон запроса
    fun getAllItems(): Flow<List<Note>>
}