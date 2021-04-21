package com.example.test1232

import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import kotlin.properties.Delegates


class ModelView : ViewModel() {


    val nameHintText: LiveData<String> = MutableLiveData("enter name here")
    val titleHintText: LiveData<String> = MutableLiveData("enter title here")
    val textHint: LiveData<String> = MutableLiveData("enter text here")

    val textColorEditText = R.color.black
    val textColorButton = R.color.white
    val avatarRes = R.drawable.ava

    val nameStr: LiveData<String> = MutableLiveData("Name")
    val titleStr: LiveData<String> = MutableLiveData("Title")
    val textStr: LiveData<String> = MutableLiveData("Text")
    var count = MutableLiveData(1)


    val buttonTestText: LiveData<String> = MutableLiveData("Test")
    val buttonLaunchText: LiveData<String> = MutableLiveData("Launch")

    val buttonLeftRes = R.drawable.outline_arrow_back_24
    val buttonRightRes = R.drawable.outline_arrow_forward_24
    val imageUrl = R.drawable.fjb1

    fun onClickLeft(): Int? {
        if (count.value == 1) {
            count.value = 4
        }
        count.value = count.value?.minus(1)
        //   Log.d("count",count.value.toString())
        return count.value

    }

    fun onClickRight(): Int? {
        if (count.value == 3) {
            count.value = 0
        }
        count.value = count.value?.plus(1)
        //    Log.d("count",count.value.toString())
        return count.value
    }


}

@BindingAdapter("imageUrl")
fun loadImage(layout: LinearLayout, drawable: Drawable?) {
    if (drawable != null) {
        layout.background = drawable
    }
}

@BindingAdapter("imageLoad")
fun load(view: ImageView, drawable: Int?) {
    if (drawable != null) {
        view.setImageResource(drawable)
    }
}





