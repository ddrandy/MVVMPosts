package com.randy.mvvmposts.ui.post

import com.randy.mvvmposts.base.BaseViewModel
import com.randy.mvvmposts.network.PostApi
import javax.inject.Inject

/**
 * @author randy
 * @since 7/13/18 4:17 PM
 */
class PostListViewModel : BaseViewModel() {
    @Inject
    lateinit var postApi: PostApi
}