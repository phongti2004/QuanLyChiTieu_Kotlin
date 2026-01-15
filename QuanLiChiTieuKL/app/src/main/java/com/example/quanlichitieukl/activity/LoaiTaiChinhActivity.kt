package com.example.quanlichitieukl.activity

import android.graphics.Paint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.quanlichitieukl.R
import com.example.quanlichitieukl.fragment.LoaiKhoanChiFragment
import com.example.quanlichitieukl.fragment.LoaiKhoanThuFragment
import androidx.fragment.app.Fragment

class LoaiTaiChinhActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_loai_tai_chinh)

        val tvThu = findViewById<TextView>(R.id.tvKhoanThu)
        val tvChi = findViewById<TextView>(R.id.tvKhoanChi)

        // Set mặc định selected là Thu
        setActive(tvThu, tvChi)
        loadFragment(LoaiKhoanThuFragment())

        tvThu.setOnClickListener {
            setActive(tvThu, tvChi)
            loadFragment(LoaiKhoanThuFragment())
        }

        tvChi.setOnClickListener {
            setActive(tvChi, tvThu)
            loadFragment(LoaiKhoanChiFragment())
        }
    }

    private fun setActive(active: TextView, inactive: TextView) {
        active.setTextColor(getColor(R.color.blue))
        active.paintFlags = active.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        inactive.setTextColor(getColor(R.color.black))
        inactive.paintFlags = inactive.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
