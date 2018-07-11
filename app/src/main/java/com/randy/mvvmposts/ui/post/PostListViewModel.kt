package com.randy.mvvmposts.ui.post

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.randy.mvvmposts.R
import com.randy.mvvmposts.base.BaseViewModel
import com.randy.mvvmposts.model.Post
import com.randy.mvvmposts.network.PostApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author randy
 * @since 7/10/18 5:10 PM
 */
class PostListViewModel : BaseViewModel() {
    @Inject
    lateinit var postApi: PostApi

    private lateinit var subscription: Disposable

    val postListAdapter = PostListAdapter()

    val loadingVisibility = MutableLiveData<Int>()

    val errorMessage = MutableLiveData<Int>()
    val errorClickListener = View.OnClickListener { loadPosts() }

    init {
        loadPosts()
    }

    private fun loadPosts() {
        subscription = postApi.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrievePostListStart() }
                .doOnTerminate { onRetrievePostListFinish() }
                .subscribe(
                        // Add result
                        { onRetrievePostListSuccess(it) },
                        { onRetrievePostListError() })
    }

    private fun onRetrievePostListStart() {
        loadingVisibility.value = View.VISIBLE
    }

    private fun onRetrievePostListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListSuccess(postList: List<Post>) {
        postListAdapter.updatePostList(postList)
    }

    private fun onRetrievePostListError() {
        errorMessage.value = R.string.post_error
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}