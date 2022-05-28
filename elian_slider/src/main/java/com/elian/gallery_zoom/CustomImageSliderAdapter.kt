package com.elian.gallery_zoom

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CustomImageSliderAdapter(val context: Context, private val imagesList:ArrayList<String>,
                               val scaleType: ImageView.ScaleType) :
    RecyclerView.Adapter<CustomImageSliderAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.item_slider_image,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imagesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = imagesList[position]
        holder.imageView.loadImageFromUrl(data)
        holder.imageView.scaleType = scaleType
        holder.imageView.setOnClickListener {
            startFullImageSlider(context,imagesList,position)
        }
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageView : ImageView = view.findViewById(R.id.iv_image)

    }




}