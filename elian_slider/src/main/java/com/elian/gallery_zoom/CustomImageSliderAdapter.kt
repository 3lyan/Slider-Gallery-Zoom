package com.elian.gallery_zoom

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop

class CustomImageSliderAdapter(
    private val context: Context, private val imagesList:ArrayList<String>,
    private val scaleType: BitmapTransformation, private val errorDrawable:Drawable?
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
            startFullImageSlider(context,imagesList,position)
        }
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageView : ImageView = view.findViewById(R.id.iv_image)

    }




}