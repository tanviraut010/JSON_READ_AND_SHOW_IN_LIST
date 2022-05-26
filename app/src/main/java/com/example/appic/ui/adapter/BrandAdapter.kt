package com.example.appic.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appic.R

class BrandAdapter(private val brandList: ArrayList<String>?) :
    RecyclerView.Adapter<BrandAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvAccountNo.text =
            brandList?.get(position)
    }

    override fun getItemCount(): Int {
        return brandList!!.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvAccountNo: TextView = view.findViewById(R.id.tvName)
    }
}