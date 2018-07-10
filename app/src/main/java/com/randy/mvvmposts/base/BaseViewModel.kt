package com.randy.mvvmposts.base

import android.arch.lifecycle.ViewModel
import com.randy.mvvmposts.injection.component.DaggerViewModelInjector
import com.randy.mvvmposts.injection.module.NetworkModule
import com.randy.mvvmposts.ui.post.PostListViewModel

/**
 * @author randy
 * @since 7/10/18 4:40 PM
 */
abstract class BaseViewModel : ViewModel() {
    private val injector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
        }
    }

}