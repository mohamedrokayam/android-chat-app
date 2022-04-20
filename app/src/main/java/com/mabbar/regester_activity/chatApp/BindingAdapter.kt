package com.mabbar.regester_activity.chatApp

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("app:Error")

fun setError(textInputLayout: TextInputLayout,error:String?){
    textInputLayout.error=error
}