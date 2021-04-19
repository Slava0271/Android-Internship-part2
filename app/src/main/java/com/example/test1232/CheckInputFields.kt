package com.example.test1232

import androidx.appcompat.widget.AppCompatEditText

class CheckInputFields {
    private fun checkInputField(appCompatEditText: AppCompatEditText): Boolean {
        return appCompatEditText.text!!.isNotEmpty()
    }

    fun checkAllInputField(appCompatEditText: AppCompatEditText, appCompatEditText2:
    AppCompatEditText, appCompatEditText3: AppCompatEditText): Boolean {
        return checkInputField(appCompatEditText) && checkInputField(appCompatEditText2) && checkInputField(appCompatEditText3)
    }
}