# Slider-Gallery-Zoom

image slider for android supporting indicator and auto scroll with clicking on image to open full screen image slider swipe and pinch zoom gestures like gallery,just pass your images and the position of the current image.


https://user-images.githubusercontent.com/43176203/170810838-da47529f-159d-4dfd-97d5-019ff7cf6cb1.mp4



# How to use

<b>Step 1. Add the JitPack repository to your build file</b>

```
allprojects {          
    repositories {
	    ...
	    maven { url 'https://jitpack.io' }
	}
}
```   
   
   
<b>Step 2. Add the dependency</b>

```
dependencies {
    implementation 'com.github.3lyan:slider-gallery-zoom:1.0.1'
    }
```
    
  <b>Step 3. Add CustomSliderView to your layout</b>
    
```
	<com.elian.gallery_zoom.CustomSliderView
               android:id="@+id/rv_slider"
               android:layout_width="match_parent"
               android:layout_height="match_parent"/>
```

  <b>Step4.Passing context and your arraylist</b>
```
	val rvSlider = findViewById<CustomSliderView>(R.id.rv_slider)
        rvSlider.setImages(requireContext(),arrayListOf("https://img.wallpapersafari.com/desktop/1366/768/35/40/clygNA.jpg",
            "https://img.wallpapersafari.com/desktop/1366/768/90/90/4Ak2Rp.jpg"))
	
```

# Features

<b>you can make the slider auto scroll every value in seconds you entered</b>
```
	rvSlider.autoScroll(3) //time in seconds
```

<b>set custom indicator thanks to [CircleIndicator](https://github.com/ongakuer/CircleIndicator)
add me.relex.circleindicator.CircleIndicator2 to your view</b>
```
	<me.relex.circleindicator.CircleIndicator2
                  android:id="@+id/intro_indicator"
                  android:layout_width="wrap_content"
                  android:layout_height="wrap_content"
                  app:ci_height="8dp"
                  app:ci_width="8dp"
                  app:ci_orientation="vertical"/>
```
<b>in code</b>
```
	val indicator = findViewById<CircleIndicator2>(R.id.indicator);
	rvSlider.setCustomIndicator(introIndicator) // attach to our CustomSliderView
```

<b>Change images scale type in slider (the default scale type is FIT_CENTER)</b>
```
	val rvSlider = findViewById<CustomSliderView>(R.id.rv_slider)
        rvSlider.setImages(requireContext(),arrayListOf("https://img.wallpapersafari.com/desktop/1366/768/35/40/clygNA.jpg",
            "https://img.wallpapersafari.com/desktop/1366/768/90/90/4Ak2Rp.jpg",ImageView.ScaleType.FIT_CENTER))
	
```
<b>You still can use full screen slider only, passing context,arraylist of urls and the current image position to the method</b>
```
	startFullImageSlider(context,imagesArrayList,position)
```
    
if you’re planning on loading images from urls or over a network connection,
     you should add the INTERNET  permissions to your AndroidManifest.xml
    
` <uses-permission android:name="android.permission.INTERNET" />
`
# Thanks to
  
  [Glide](https://github.com/bumptech/glide)
  </br>
  [ZoomLayout](https://github.com/natario1/ZoomLayout)
  </br>
  [CircleIndicator](https://github.com/ongakuer/CircleIndicator)
    
    
   
