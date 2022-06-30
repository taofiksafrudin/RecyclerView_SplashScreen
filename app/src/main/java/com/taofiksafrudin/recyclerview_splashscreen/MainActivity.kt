package com.taofiksafrudin.recyclerview_splashscreen

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.taofiksafrudin.recyclerview_splashscreen.databinding.ActivityMainBinding
import com.taofiksafrudin.recyclerview_splashscreen.model.Teman

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listTeman = ArrayList<Teman>()
        listTeman.add(Teman("Taofik Safrudin",R.drawable.tofik,"311910527", "Menulis", "Indramayu", "28/10/1999"))
        listTeman.add(Teman("Riwan Manurung",R.drawable.riwan,"311910500", "Bermain Musik", "Medan", "08/12/1997"))
        listTeman.add(Teman("Lucky Dwi Putra",R.drawable.luki,"311910248", "Futsal", "Bekasi", "09/08/2001"))
        listTeman.add(Teman("Virza Putra", R.drawable.virza, "311910387" , "Bekerja", "Jakarta", "20/05/1997"))


        binding.List.adapter = AdapterTeman(this,listTeman,object : AdapterTeman.OnClickListener {
            override fun detailData(item: Teman?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_teman)

                    val image = this.findViewById<ImageView>(R.id.image_Teman)
                    val nama = this.findViewById<TextView>(R.id.txtNamateman)
                    val nim = this.findViewById<TextView>(R.id.txtNim)
                    val hobi = this.findViewById<TextView>(R.id.txtHobi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txtTempatLahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txtTanggalLahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    nim.text = "${item?.nim}"
                    hobi.text = "${item?.hobi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tgllahir.text = "${item?.tgllahir}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }
                }.show()
            }
        })



    }

}