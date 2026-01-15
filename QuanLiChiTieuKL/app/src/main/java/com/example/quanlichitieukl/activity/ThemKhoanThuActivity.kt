package com.example.quanlichitieukl.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quanlichitieukl.R
import com.google.android.material.appbar.MaterialToolbar

class ThemKhoanThuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_them_khoan_thu)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbarThem)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Thêm khoản thu"

        toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}

