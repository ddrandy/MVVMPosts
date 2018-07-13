package com.randy.mvvmposts.injection.component

import com.randy.mvvmposts.injection.module.NetworkModule
import com.randy.mvvmposts.ui.post.PostListViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * @author randy
 * @since 7/13/18 4:19 PM
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [NetworkModule::class])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified PostListViewModel.
     * @param postListViewModel PostListViewModel in which to inject the dependencies
     */
    fun inject(postListViewModel: PostListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector
        fun networkModule(networkModel: NetworkModule): Builder
    }
}