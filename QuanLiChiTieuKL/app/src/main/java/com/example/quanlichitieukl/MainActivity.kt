package com.example.quanlichitieukl

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.quanlichitieukl.Fragment.BaoCaoFragment
import com.example.quanlichitieukl.Fragment.KhacFragment
import com.example.quanlichitieukl.Fragment.MucTieuFragment
import com.example.quanlichitieukl.Fragment.TaiChinhFragment
import com.example.quanlichitieukl.Fragment.TraoDoiFragment
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