package com.example.room.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_grid")                         // сущность. Создание таблицы для сущности заметки
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val text: String
)