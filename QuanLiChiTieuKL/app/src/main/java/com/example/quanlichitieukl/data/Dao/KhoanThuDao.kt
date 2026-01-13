package com.example.quanlichitieukl.data.Dao

import androidx.room.*
import com.example.quanlichitieukl.data.Model.KhoanThu
import kotlinx.coroutines.flow.Flow

@Dao
interface KhoanThuDao {
    @Insert
    suspend fun insert(khoanThu: KhoanThu)

    @Update
    suspend fun update(khoanThu: KhoanThu)

    @Delete
    suspend fun delete(khoanThu: KhoanThu)

    @Query("SELECT * FROM khoan_thu ORDER BY id DESC")
    fun getAll(): Flow<List<KhoanThu>>
}