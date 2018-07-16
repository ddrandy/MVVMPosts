package com.randy.mvvmposts.ui.post

import android.arch.lifecycle.MutableLiveData
import com.randy.mvvmposts.base.BaseViewModel
import com.randy.mvvmposts.model.Post

/**
 * @author randy
 * @since 7/16/18 9:51 AM
 */
class PostViewModel : BaseViewModel() {
    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()

    fun bind(post: Post) {
        postTitle.value = post.title
        postBody.value = post.body
    }

    fun getPostTitle(): MutableLiveData<String> {
        return postTitle
    }

    fun getPostBody(): MutableLiveData<String> {
        return postBody
    }
}