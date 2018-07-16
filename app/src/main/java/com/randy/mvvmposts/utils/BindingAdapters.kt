package com.randy.mvvmposts.utils

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.databinding.BindingAdapter
import android.view.View

/**
 * @author randy
 * @since 7/13/18 4:59 PM
 */
@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentActivity = view.getParentActivity()
    if (parentActivity != null) {
        visibility?.observe(parentActivity, Observer { view.visibility = it ?: View.VISIBLE })
    }
}