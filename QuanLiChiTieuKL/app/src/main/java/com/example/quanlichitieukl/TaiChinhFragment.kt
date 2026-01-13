package com.example.quanlichitieukl

import android.graphics.Paint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class TaiChinhFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tai_chinh, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvThu = view.findViewById<TextView>(R.id.tvKhoanThu)
        val tvChi = view.findViewById<TextView>(R.id.tvKhoanChi)

        setActive(tvThu, tvChi)
        // Load mặc định Khoản Thu
        loadFragment(KhoanThuFragment())

        tvThu.setOnClickListener {
            setActive(tvThu, tvChi)
            loadFragment(KhoanThuFragment())
        }

        tvChi.setOnClickListener {
            setActive(tvChi, tvThu)
            loadFragment(KhoanChiFragment())
        }
    }

    private fun setActive(active: TextView, inactive: TextView) {
        active.setTextColor(requireContext().getColor(R.color.blue))
        active.paintFlags = active.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        inactive.setTextColor(requireContext().getColor(R.color.black))
        inactive.paintFlags = inactive.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
    }

    private fun loadFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
