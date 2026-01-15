package com.example.quanlichitieukl.data.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "loai_khoan_chi")
data class LoaiKhoanChi(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var loaiKC: String,
    var imgKC: String,
)
