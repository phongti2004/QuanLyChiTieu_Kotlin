package com.example.quanlichitieukl.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.quanlichitieukl.data.Dao.KhoanChiDao
import com.example.quanlichitieukl.data.Dao.KhoanThuDao
import com.example.quanlichitieukl.data.Model.KhoanChi
import com.example.quanlichitieukl.data.Model.KhoanThu

@Database(entities = [KhoanThu::class,KhoanChi::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun khoanThuDao(): KhoanThuDao
    abstract fun khoanChiDao(): KhoanChiDao
}
