package com.randy.mvvmposts.utils

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.view.View

/**
 * @author randy
 * @since 7/19/18 11:50 AM
 */
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentActivity = view.getParentActivity()
    if (parentActivity != null) {
        visibility?.observe(parentActivity, Observer { view.visibility = it ?: View.VISIBLE })
    }
}