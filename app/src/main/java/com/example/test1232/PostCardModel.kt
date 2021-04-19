package com.example.test1232

import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.ViewModel

class PostCardModel : ViewModel() {
    val titleTextColor = R.color.black
    val avatarRes = R.drawable.ava2

}
fun setField(appCompatTextView: AppCompatTextView, arrayList: ArrayList<String>, count: Int) {
    appCompatTextView.text = arrayList[count]
}
