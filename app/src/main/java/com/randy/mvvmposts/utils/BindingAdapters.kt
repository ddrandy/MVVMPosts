package com.randy.mvvmposts.utils

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.databinding.BindingAdapter
import android.support.v7.app.AppCompatActivity
import android.view.View

/**
 * @author randy
 * @since 7/11/18 10:25 AM
 */
@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null) {
        visibility?.observe(parentActivity,
                Observer { value -> view.visibility = value ?: View.VISIBLE })
    }
}