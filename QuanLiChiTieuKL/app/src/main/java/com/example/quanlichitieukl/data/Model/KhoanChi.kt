package com.example.quanlichitieukl.data.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "khoan_thu")
class KhoanChi (
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var ten: String,
    var soTien: Double,
    var danhMuc: String,
    var hinhAnh: String,
    var ngayTao: Long
)