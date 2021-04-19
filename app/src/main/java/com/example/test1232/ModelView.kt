package com.example.test1232

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.annotation.IdRes
import androidx.appcompat.widget.AppCompatEditText
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ModelView : ViewModel() {
    val nameHintText: LiveData<String> = MutableLiveData("enter name here")
    val titleHintText: LiveData<String> = MutableLiveData("enter title here")
    val textHint: LiveData<String> = MutableLiveData("enter text here")

    val textColorEditText = R.color.black
    val textColorButton = R.color.white
    val avatarRes = R.drawable.ava

    val nameStr:LiveData<String> = MutableLiveData("Name")
    val titleStr:LiveData<String> = MutableLiveData("Title")
    val textStr:LiveData<String> = MutableLiveData("Text")

    val buttonTestText:LiveData<String> = MutableLiveData("Test")
    val buttonLaunchText:LiveData<String> = MutableLiveData("Launch")


}

@BindingAdapter("imageUrl")
fun loadImage(layout: LinearLayout, drawable: Drawable?) {
    if (drawable != null) {
        layout.background = drawable
    }
}



