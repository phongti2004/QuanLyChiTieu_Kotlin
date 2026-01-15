package com.example.quanlichitieukl.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quanlichitieukl.R
import com.example.quanlichitieukl.data.Model.LoaiKhoanChi
import de.hdodenhof.circleimageview.CircleImageView
import java.io.File

class LoaiKhoanChiAdapter(
    private val list: List<LoaiKhoanChi>,
    private val onClickItem: (LoaiKhoanChi) -> Unit
) : RecyclerView.Adapter<LoaiKhoanChiAdapter.ViewHolder>() {
    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val imgLoaiKhoanChi = item.findViewById<CircleImageView>(R.id.imgLoaiKhoanChi)
        val tvLoaiKhoanChi = item.findViewById<TextView>(R.id.tvLoaiKhoanChi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoaiKhoanChiAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_loai_khoan_chi, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: com.example.quanlichitieukl.adapter.LoaiKhoanChiAdapter.ViewHolder, position: Int) {
        val item = list[position]
        holder.tvLoaiKhoanChi.text = item.loaiKC

        if (item.imgKC.isNotEmpty()) {

            if (item.imgKC.contains("/")) {
                // Trường hợp ảnh là file path
                val file = File(item.imgKC)
                if (file.exists()) {
                    holder.imgLoaiKhoanChi.setImageURI(Uri.fromFile(file))
                } else {
                    holder.imgLoaiKhoanChi.setImageResource(R.color.gray)
                }

            } else {
                // Trường hợp ảnh drawable
                val resId = holder.itemView.context.resources.getIdentifier(
                    item.imgKC.substringBeforeLast("."),
                    "drawable",
                    holder.itemView.context.packageName
                )
                if (resId != 0) holder.imgLoaiKhoanChi.setImageResource(resId)
                else holder.imgLoaiKhoanChi.setImageResource(R.color.gray)
            }

        } else {
            holder.imgLoaiKhoanChi.setImageResource(R.color.gray)
        }

        holder.itemView.setOnClickListener { onClickItem(item) }
    }

    override fun getItemCount() = list.size
}