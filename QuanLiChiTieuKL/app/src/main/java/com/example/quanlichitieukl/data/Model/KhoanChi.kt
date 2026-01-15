package com.example.quanlichitieukl.data.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "khoan_chi")
class KhoanChi (
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var ten: String,
    var soTien: Double,
    var LoaiKhoanChi: Int,
    var hinhAnh: String,
    var ngayTao: Long
)