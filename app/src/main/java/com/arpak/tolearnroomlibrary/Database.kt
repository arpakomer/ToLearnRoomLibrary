package com.arpak.tolearnroomlibrary

import android.content.Context
import androidx.room.RoomDatabase
import androidx.room.Database
import androidx.room.Room

@Database(entities = [Persons::class], version = 1)
abstract class PersonsDatabase : RoomDatabase() {

    abstract fun getPersonsDao(): PersonsDao

    companion object {

        var INSTANCE: PersonsDatabase? = null

        fun accessToDatabase(context: Context): PersonsDatabase? {
            if (INSTANCE == null) {
                 synchronized(PersonsDatabase::class){
                     INSTANCE = Room.databaseBuilder(context.applicationContext,
                     PersonsDatabase::class.java,
                     "rehberim.db")
                         .createFromAsset("rehberim.db").build()
                 }
            }
            return INSTANCE
        }
    }
}