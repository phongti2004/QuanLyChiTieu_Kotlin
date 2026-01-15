package com.example.quanlichitieukl.data.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "loai_khoan_thu")
data class LoaiKhoanThu(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var loaiKT: String,
    var imgKT: String,
)