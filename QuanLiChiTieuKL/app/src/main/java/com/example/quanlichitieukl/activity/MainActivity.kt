package com.example.quanlichitieukl.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.quanlichitieukl.fragment.BaoCaoFragment
import com.example.quanlichitieukl.fragment.KhacFragment
import com.example.quanlichitieukl.fragment.MucTieuFragment
import com.example.quanlichitieukl.fragment.TaiChinhFragment
import com.example.quanlichitieukl.fragment.TraoDoiFragment
import com.example.quanlichitieukl.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        loadFragment(TaiChinhFragment())
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.itmTaiChinh -> loadFragment(TaiChinhFragment())
                R.id.itmMucTieu -> loadFragment(MucTieuFragment())
                R.id.itmBaoCao -> loadFragment(BaoCaoFragment())
                R.id.itmTraoDoi -> loadFragment(TraoDoiFragment())
                R.id.itmKhac -> loadFragment(KhacFragment())
            }
            true
        }
    }
    private fun loadFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}