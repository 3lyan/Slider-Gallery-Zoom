# Slider-Gallery-Zoom

full screen image slider with swipe and pinch zoom gestures like gallery,just pass your images and the position of the current image.


https://user-images.githubusercontent.com/43176203/170790787-6d53f24a-a080-4b0a-a809-3447e4ca7d3a.mp4



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
    
 <b>Step 3. Passing context,arraylist of urls and the current image position to the method
    
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
    
    
   
