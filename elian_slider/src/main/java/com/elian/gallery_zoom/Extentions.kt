package com.elian.gallery_zoom

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide

fun ViewPager2.reduceDragSensitivity() {
    val recyclerViewField = ViewPager2::class.java.getDeclaredField("mRecyclerView")
    recyclerViewField.isAccessible = true
    val recyclerView = recyclerViewField.get(this) as RecyclerView

    val touchSlopField = RecyclerView::class.java.getDeclaredField("mTouchSlop")
    touchSlopField.isAccessible = true
    val touchSlop = touchSlopField.get(recyclerView) as Int
    touchSlopField.set(recyclerView, touchSlop * 6) // "6" was obtained experimentally
}
fun startFullImageSlider(context: Context, imageArrayList: ArrayList<String>, position:Int){
    val intent = Intent(context,SliderFullImagesActivity::class.java)
    intent.putExtra("position",position)
    intent.putExtra("images",imageArrayList)
    ContextCompat.startActivity(context, intent, null)
}
fun ImageView.loadImageFromUrl(url: String?) {
    val circularProgressDrawable = context.let { CircularProgressDrawable(it) }
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.start()
    Glide.with(this.context)
        .load(url).placeholder(circularProgressDrawable)
        .into(this)
}