package com.example.quanlichitieukl.Data

import androidx.room.*
import com.example.quanlichitieukl.Data.Model.KhoanThu

@Dao
interface KhoanThuDao {
    @Insert
    suspend fun insert(khoanThu: KhoanThu)

    @Update
    suspend fun update(khoanThu: KhoanThu)

    @Delete
    suspend fun delete(khoanThu: KhoanThu)

    @Query("SELECT * FROM khoan_thu ORDER BY id DESC")
    suspend fun getAll(): List<KhoanThu>
}