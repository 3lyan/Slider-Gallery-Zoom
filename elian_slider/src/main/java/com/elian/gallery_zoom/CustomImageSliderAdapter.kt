package com.elian.gallery_zoom

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation

class CustomImageSliderAdapter(
    private val imagesList:ArrayList<String>,
    private val scaleType: BitmapTransformation, private val errorDrawable:Drawable?,
    private val onImageClick: (images: ArrayList<String>, position:Int)->Unit
) :
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
        holder.imageView.loadImageWithScale(data,scaleType,errorDrawable)
        holder.imageView.setOnClickListener {
            onImageClick.invoke(imagesList,position)
        }
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageView : ImageView = view.findViewById(R.id.iv_image)

    }




}