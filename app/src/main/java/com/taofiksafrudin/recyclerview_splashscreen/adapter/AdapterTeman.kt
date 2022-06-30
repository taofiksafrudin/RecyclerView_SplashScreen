package com.taofiksafrudin.recyclerview_splashscreen

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.taofiksafrudin.recyclerview_splashscreen.databinding.ListItemTemanBinding
import com.taofiksafrudin.recyclerview_splashscreen.model.Teman

class AdapterTeman (private val Context : Context,
                       private var data : List<Teman>?,
                       private val  itemclik : OnClickListener)
    : RecyclerView.Adapter<AdapterTeman.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemTemanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)
        holder.foto.setImageResource(item?.foto ?:0)
        holder.nama.text = item?.nama

        holder.itemView.setOnClickListener {
            itemclik.detailData(item)
        }
    }

    override fun getItemCount(): Int = data?.size ?:0

    inner class ViewHolder(val binding : ListItemTemanBinding): RecyclerView.ViewHolder(binding.root) {
        var foto = binding.image
        var nama = binding.txtnama

    }
    interface OnClickListener {
        fun  detailData(item : Teman?)

    }

}
