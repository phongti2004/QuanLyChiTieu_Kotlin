package com.example.quanlichitieukl.fragment

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quanlichitieukl.R
import com.example.quanlichitieukl.adapter.LoaiKhoanChiAdapter
import com.example.quanlichitieukl.data.AppDatabase
import com.example.quanlichitieukl.data.Model.LoaiKhoanChi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream

class LoaiKhoanChiFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: LoaiKhoanChiAdapter
    private lateinit var db: AppDatabase
    private var list = mutableListOf<LoaiKhoanChi>()
    private var selectedItem: LoaiKhoanChi? = null
    private var selectedImage: String = ""
    private lateinit var edtTen: EditText
    private lateinit var imgBtn: ImageButton
    private lateinit var btnThem: Button
    private lateinit var btnXoa: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_loai_khoan_chi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        edtTen = view.findViewById(R.id.edtTenKhoanChi)
        imgBtn = view.findViewById(R.id.imgLoaiKhoanChi)
        btnThem = view.findViewById(R.id.btnThem)
        btnXoa = view.findViewById(R.id.btnXoa)

        recyclerView = view.findViewById(R.id.rycLoaiKhoanChi)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 4)

        db = AppDatabase.getInstance(requireContext())

        adapter = LoaiKhoanChiAdapter(list) { item ->
            selectedItem = item
            edtTen.setText(item.loaiKC)
            selectedImage = item.imgKC

            if (item.imgKC.isNotEmpty()) {

                // Nếu là file (ảnh chọn từ thư viện)
                val file = File(item.imgKC)
                if (file.exists()) {
                    imgBtn.setImageURI(Uri.fromFile(file))
                } else {
                    // Nếu là drawable (ảnh mặc định)
                    val name = item.imgKC.substringBeforeLast(".")
                    val resId = requireContext().resources.getIdentifier(
                        name, "drawable", requireContext().packageName
                    )
                    if (resId != 0) {
                        imgBtn.setImageResource(resId)
                    } else {
                        imgBtn.setImageResource(R.color.gray)
                    }
                }

            } else {
                imgBtn.setImageResource(R.color.gray)
            }
        }

        recyclerView.adapter = adapter

        btnThem.setOnClickListener { addItem() }
        btnXoa.setOnClickListener { deleteItem() }
        imgBtn.setOnClickListener { pickImage.launch("image/*") }

        loadData()
    }
    private val pickImage = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let {
            val path = copyUriToInternal(it)
            selectedImage = path
            imgBtn.setImageURI(it)
        }
    }

    private fun copyUriToInternal(uri: Uri): String {
        val input = requireContext().contentResolver.openInputStream(uri)
        val file = File(requireContext().filesDir, "${System.currentTimeMillis()}.jpg")
        val output = FileOutputStream(file)

        input?.copyTo(output)
        input?.close()
        output.close()

        return file.absolutePath
    }


    private fun addItem() {
        val ten = edtTen.text.toString().trim()
        if (ten.isEmpty()) return
        val item = LoaiKhoanChi(loaiKC = ten, imgKC = selectedImage)
        lifecycleScope.launch(Dispatchers.IO) {
            db.LoaiKhoanChiDao().insert(item)
            loadData()
            withContext(Dispatchers.Main) { resetForm() }
        }
    }

    private fun deleteItem() {
        val item = selectedItem ?: return
        lifecycleScope.launch(Dispatchers.IO) {
            db.LoaiKhoanChiDao().delete(item)
            loadData()
            withContext(Dispatchers.Main) { resetForm() }
        }
    }

    private fun loadData() {
        db.LoaiKhoanChiDao().getAll().observe(viewLifecycleOwner) { data ->
            list.clear()
            list.addAll(data)
            adapter.notifyDataSetChanged()
        }
    }

    private fun resetForm() {
        selectedItem = null
        selectedImage = ""
        edtTen.setText("")
        imgBtn.setImageResource(R.color.gray)
    }
}