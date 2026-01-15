package com.example.quanlichitieukl.data.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.quanlichitieukl.data.Model.LoaiKhoanThu

@Dao
interface LoaiKhoanThuDao {
    @Insert
    suspend fun insert(loaiKhoanThu: LoaiKhoanThu)

    @Delete
    suspend fun delete(item: LoaiKhoanThu)

    @Query("SELECT * FROM loai_khoan_thu")
    fun getAll(): LiveData<List<LoaiKhoanThu>>
}
