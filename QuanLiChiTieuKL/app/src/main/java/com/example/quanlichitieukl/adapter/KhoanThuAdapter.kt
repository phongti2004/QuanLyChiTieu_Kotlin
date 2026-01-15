package com.example.quanlichitieukl.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quanlichitieukl.R
import com.example.quanlichitieukl.data.Model.KhoanThu

class KhoanThuAdapter (
    private val list: List<KhoanThu>
):RecyclerView.Adapter<KhoanThuAdapter.KhoanThuViewHolder>(){
    class KhoanThuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ten = itemView.findViewById<TextView>(R.id.tenKhoanThu)
        val soTien = itemView.findViewById<TextView>(R.id.soTien)
        val ngayTao = itemView.findViewById<TextView>(R.id.ngayTao)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KhoanThuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_khoan_thu, parent, false)
        return KhoanThuViewHolder(view)
    }

    override fun onBindViewHolder(holder: KhoanThuViewHolder, position: Int) {
        val item = list[position]
        holder.ten.text = item.ten
        val formattedSoTien = if (item.soTien % 1 == 0.0) {
            item.soTien.toInt().toString()
        } else {
            item.soTien.toString()
        }
        holder.soTien.text = "$formattedSoTien đ"
        holder.ngayTao.text = item.ngayTao.toString()
    }

    override fun getItemCount(): Int = list.size
}