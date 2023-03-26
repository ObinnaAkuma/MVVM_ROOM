package com.example.mvvmtutorial.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmtutorial.models.Note
import com.example.mvvmtutorial.utilities.DATABASE_NAME
import kotlinx.coroutines.internal.synchronized


@Database(entities = arrayOf(Note::class), version = 1, exportSchema = false)
abstract class NoteDataBase : RoomDatabase(){

    abstract fun getNoteDao() : NoteDao

    companion object{

        @Volatile
        private var INSTANCE : NoteDataBase? = null

        fun getDataBase (context : Context) : NoteDataBase{
            return INSTANCE ?: kotlin.synchronized(this ){

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDataBase::class.java,
                    DATABASE_NAME
                ).build()

                INSTANCE = instance

                instance
            }
        }

    }

}