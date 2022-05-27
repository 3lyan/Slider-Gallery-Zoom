package com.elian.gallery_zoom

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.viewpager2.widget.ViewPager2


class SliderFullImagesActivity : AppCompatActivity() {

    private lateinit var imageClose:ImageView
    private lateinit var vpImages:ViewPager2
    private lateinit var tvCount:TextView
    private var position:Int = 0
    private var images:ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider_full_show)
        initViews()
        receiveData()
        handleClicks()
        handleViewPager()
    }

    private fun initViews(){
        imageClose = findViewById(R.id.image_close)
        vpImages = findViewById(R.id.vp_images)
        tvCount = findViewById(R.id.tv_count)
    }

    private fun receiveData(){
        position = intent.getIntExtra("position",0)
        images = intent.getStringArrayListExtra("images")
    }

    private fun handleClicks(){
        imageClose.setOnClickListener { onBackPressed() }
    }

    @SuppressLint("SetTextI18n")
    private fun handleViewPager(){
        val adapter = images?.let { SliderFullImagesAdapter(it) }
        vpImages.adapter = adapter
        vpImages.currentItem = position
        tvCount.text = "${position+1} ${getString(R.string.of)} ${images?.size}"
        vpImages.requestDisallowInterceptTouchEvent(true)
        val myPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tvCount.text = "${position+1} ${getString(R.string.of)} ${images?.size}"
            }
        }
        vpImages.registerOnPageChangeCallback(myPageChangeCallback)
        vpImages.reduceDragSensitivity()
    }

}
fun startFullImageSlider(context: Context,imageArrayList: ArrayList<String>,position:Int){
    val intent = Intent(context,SliderFullImagesActivity::class.java)
    intent.putExtra("position",position)
    intent.putExtra("images",imageArrayList)
    startActivity(context,intent,null)
}