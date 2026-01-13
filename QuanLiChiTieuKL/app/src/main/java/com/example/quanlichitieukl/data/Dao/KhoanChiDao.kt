package com.example.quanlichitieukl.data.Dao

import androidx.room.*
import com.example.quanlichitieukl.data.Model.KhoanChi
import kotlinx.coroutines.flow.Flow

@Dao
interface KhoanChiDao {
    @Insert
    suspend fun insert(khoanChi: KhoanChi)

    @Update
    suspend fun update(khoanChi: KhoanChi)

    @Delete
    suspend fun  delete(khoanChi: KhoanChi)

    @Query("SELECT * FROM khoan_chi ORDER BY id DESC")
    fun getAll(): Flow<List<KhoanChi>>
}