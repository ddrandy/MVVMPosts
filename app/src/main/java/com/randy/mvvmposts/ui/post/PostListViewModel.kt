package com.randy.mvvmposts.ui.post

import com.randy.mvvmposts.base.BaseViewModel
import com.randy.mvvmposts.network.PostApi
import javax.inject.Inject

/**
 * @author randy
 * @since 7/19/18 11:18 AM
 */
class PostListViewModel : BaseViewModel() {
    @Inject
    lateinit var postApi: PostApi
}