package com.example.quanlichitieukl.data.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.quanlichitieukl.data.Model.LoaiKhoanChi

@Dao
interface LoaiKhoanChiDao {
    @Insert
    suspend fun insert(loaiKhoanChi: LoaiKhoanChi)

    @Delete
    suspend fun delete(item: LoaiKhoanChi)

    @Query("SELECT * FROM loai_khoan_chi")
    fun getAll(): LiveData<List<LoaiKhoanChi>>
}
