package com.example.room.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        Note::class                     // ссылка на дата класс Note
    ],
    version =  1                        // впоследствие база может меняться. Для изменения версий. Очень важно!
)
abstract class MainDB: RoomDatabase() {   // логика раскрывается потом. С реализацией. RoomDatabase -
                                                // конструктор, указывающий что внутри него производятся действия по созданию базы
    abstract val dao: NoteDAO           // viewModel будет обращаться к базе данных. А база обращается к dao
    companion object{                   // обезличенный класс, без имени, но с логикой
        fun createDB(context: Context): MainDB {  // context - связь между оболочкой Андроид и приложением
            return Room.databaseBuilder(
                context = context,
                klass = MainDB::class.java,     // обязательная конвертация в java, тк изначально Room сделана на java
                name = "note_base"
            ).build()
        }
    }

}