package com.example.bingdaily.ui.image

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bingdaily.BingDailyApplication
import com.example.bingdaily.databinding.ImageCardBinding
import com.example.bingdaily.logic.modal.ImageData

class ImageAdapter(val list:List<ImageData>) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val holder = ViewHolder(ImageCardBinding.inflate(LayoutInflater.from(parent.context)))
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        Glide.with(BingDailyApplication.context).load(item.url).into(holder.img)
        holder.title.text = item.title
        holder.copyright.text = item.copyright
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(binding: ImageCardBinding) : RecyclerView.ViewHolder(binding.root) {
        val img: ImageView = binding.cardImg
        val title: TextView = binding.cardTitle
        val copyright: TextView = binding.cardCopyright
    }
}