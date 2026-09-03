package com.example.room

import android.app.Application
import com.example.room.data.MainDB

class App: Application() {
    val createDatabase by lazy { MainDB.createDB(this) }     // ленивая инициализация. Когда обращаемся впервые она выполняет действие в теле
}