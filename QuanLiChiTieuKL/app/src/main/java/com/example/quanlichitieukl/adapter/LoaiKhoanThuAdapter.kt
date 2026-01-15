package com.example.quanlichitieukl.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quanlichitieukl.R
import com.example.quanlichitieukl.data.Model.LoaiKhoanThu
import de.hdodenhof.circleimageview.CircleImageView
import java.io.File


class LoaiKhoanThuAdapter(
    private val list: List<LoaiKhoanThu>,
    private val onClickItem: (LoaiKhoanThu) -> Unit
) : RecyclerView.Adapter<LoaiKhoanThuAdapter.ViewHolder>() {
    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val imgLoaiKhoanThu = item.findViewById<CircleImageView>(R.id.imgKhoanThu)
        val tvLoaiKhoanThu = item.findViewById<TextView>(R.id.LoaiKhoanThu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_loai_khoan_thu, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.tvLoaiKhoanThu.text = item.loaiKT

        if (item.imgKT.isNotEmpty()) {

            if (item.imgKT.contains("/")) {
                // Trường hợp ảnh là file path
                val file = File(item.imgKT)
                if (file.exists()) {
                    holder.imgLoaiKhoanThu.setImageURI(Uri.fromFile(file))
                } else {
                    holder.imgLoaiKhoanThu.setImageResource(R.color.gray)
                }

            } else {
                // Trường hợp ảnh drawable
                val resId = holder.itemView.context.resources.getIdentifier(
                    item.imgKT.substringBeforeLast("."),
                    "drawable",
                    holder.itemView.context.packageName
                )
                if (resId != 0) holder.imgLoaiKhoanThu.setImageResource(resId)
                else holder.imgLoaiKhoanThu.setImageResource(R.color.gray)
            }

        } else {
            holder.imgLoaiKhoanThu.setImageResource(R.color.gray)
        }

        holder.itemView.setOnClickListener { onClickItem(item) }
    }


    override fun getItemCount() = list.size
}
