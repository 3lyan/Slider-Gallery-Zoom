package com.elian.gallery_zoom

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import me.relex.circleindicator.CircleIndicator2

class CustomSliderView : RecyclerView {

    private var pagerSnapHelper: PagerSnapHelper
    private lateinit var mainHandler: Handler
    private lateinit var runnable: Runnable

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)


    init {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(this)
    }

    fun setImages(
        context: Context, images: ArrayList<String>?,
        scaleType: ImageView.ScaleType = ImageView.ScaleType.FIT_CENTER
    ) {
        images?.let {
            val customImageSliderAdapter =
                CustomImageSliderAdapter(context, it,scaleType)
            adapter = customImageSliderAdapter
        }
    }

    fun setCustomIndicator(indicator: CircleIndicator2) {
        indicator.attachToRecyclerView(this, pagerSnapHelper)
    }

    fun autoScroll(timeInSec: Int) {
        val timer: Long = (timeInSec * 1000).toLong()
        Handler(Looper.getMainLooper()).postDelayed({
            mainHandler = Handler(Looper.getMainLooper())
            runnable = object : Runnable {
                override fun run() {
                    if (adapter != null) {
                        val count =
                            (this@CustomSliderView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                        if (count + 1 < adapter!!.itemCount) {
                            this@CustomSliderView.smoothScrollToPosition(count + 1)
                        } else {
                            this@CustomSliderView.smoothScrollToPosition(0)
                        }
                        mainHandler.postDelayed(this, timer)
                    }
                }
            }
            mainHandler.post(runnable)
        }, timer)

    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        if (this::mainHandler.isInitialized)
            mainHandler.removeCallbacks(runnable)
    }
}