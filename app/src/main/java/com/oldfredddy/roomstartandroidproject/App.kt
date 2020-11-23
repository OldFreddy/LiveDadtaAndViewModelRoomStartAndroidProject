package com.oldfredddy.roomstartandroidproject

import android.app.Application
import androidx.room.Room


class App : Application() {

    companion object {
        var database: AppDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .fallbackToDestructiveMigration()
            .build()

    }
}