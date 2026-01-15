package com.example.quanlichitieukl.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quanlichitieukl.R
import com.example.quanlichitieukl.activity.ThemKhoanThuActivity
import com.example.quanlichitieukl.adapter.KhoanThuAdapter
import com.example.quanlichitieukl.data.Model.KhoanThu


class KhoanThuFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: KhoanThuAdapter
    private lateinit var btnThemKhoanThu: de.hdodenhof.circleimageview.CircleImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_khoan_thu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btnThemKhoanThu = view.findViewById(R.id.themKhoanThu)
        recyclerView = view.findViewById(R.id.recyclerKhoanThu)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val sampleData = listOf(
            KhoanThu(ten = "Bonus", soTien = 2000000.0, ngayTao = "2024-01-01", LoaiKhoanThu = 1),
            KhoanThu(ten = "Bonus", soTien = 200010.4, ngayTao = "2024-01-01", LoaiKhoanThu = 1)
        )

        adapter = KhoanThuAdapter(sampleData)
        recyclerView.adapter = adapter

        btnThemKhoanThu.setOnClickListener{
            var intent = Intent(requireContext(), ThemKhoanThuActivity::class.java)
            startActivity(intent)
        }
    }
}
