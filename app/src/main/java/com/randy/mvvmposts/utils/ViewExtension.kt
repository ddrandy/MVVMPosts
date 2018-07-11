package com.randy.mvvmposts.utils

import android.content.ContextWrapper
import android.support.v7.app.AppCompatActivity
import android.view.View

/**
 * @author randy
 * @since 7/11/18 10:29 AM
 */
fun View.getParentActivity(): AppCompatActivity? {
    var context = this.context
    while (context is ContextWrapper) {
        if (context is AppCompatActivity) {
            return context
        } else {
            context = context.baseContext
        }
    }
    return null
}