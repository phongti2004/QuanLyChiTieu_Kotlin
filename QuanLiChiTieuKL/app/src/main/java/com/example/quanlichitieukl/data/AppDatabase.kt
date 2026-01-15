package com.example.quanlichitieukl.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.quanlichitieukl.data.Dao.KhoanChiDao
import com.example.quanlichitieukl.data.Dao.KhoanThuDao
import com.example.quanlichitieukl.data.Dao.LoaiKhoanChiDao
import com.example.quanlichitieukl.data.Dao.LoaiKhoanThuDao
import com.example.quanlichitieukl.data.Model.KhoanChi
import com.example.quanlichitieukl.data.Model.KhoanThu
import com.example.quanlichitieukl.data.Model.LoaiKhoanChi
import com.example.quanlichitieukl.data.Model.LoaiKhoanThu
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(entities = [LoaiKhoanThu::class, LoaiKhoanChi::class, KhoanThu::class, KhoanChi::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun KhoanThuDao(): KhoanThuDao
    abstract fun KhoanChiDao(): KhoanChiDao
    abstract fun LoaiKhoanThuDao(): LoaiKhoanThuDao
    abstract fun LoaiKhoanChiDao(): LoaiKhoanChiDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "QLCT.db"
                )
                    .addCallback(roomCallback) // <-- thêm dòng này
                    .build()

                INSTANCE = instance
                instance
            }
        }

        private val roomCallback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                // Insert dữ liệu mặc định ở đây
                GlobalScope.launch(Dispatchers.IO) {
                    INSTANCE?.LoaiKhoanThuDao()?.apply {
                        insert(LoaiKhoanThu(loaiKT = "Lương", imgKT = "payroll"))
                        insert(LoaiKhoanThu(loaiKT = "Sở thích", imgKT = "hobby"))
                        insert(LoaiKhoanThu(loaiKT = "Công việc tự do", imgKT = "freelancer"))
                        insert(LoaiKhoanThu(loaiKT = "Đầu tư", imgKT = "dividends"))
                        insert(LoaiKhoanThu(loaiKT = "Bán ra", imgKT = "sell"))
                    }

                    INSTANCE?.LoaiKhoanChiDao()?.apply {
                        insert(LoaiKhoanChi(loaiKC = "Ăn uống", imgKC = "fad"))
                        insert(LoaiKhoanChi(loaiKC = "Mua sắm", imgKC = "shopping"))
                        insert(LoaiKhoanChi(loaiKC = "Hóa đơn", imgKC = "bill"))
                        insert(LoaiKhoanChi(loaiKC = "Quà tặng", imgKC = "present"))
                    }
                }
            }
        }
    }
}

