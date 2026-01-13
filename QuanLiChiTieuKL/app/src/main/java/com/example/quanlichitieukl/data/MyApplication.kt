package com.example.quanlichitieukl

import android.app.Application
import androidx.room.Room
import com.example.quanlichitieukl.data.AppDatabase

class MyApplication : Application() {

    companion object {
        lateinit var db: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "chi_tieu_db"
        ).build()
    }
}
