package com.randy.mvvmposts.ui.post

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.randy.mvvmposts.R
import com.randy.mvvmposts.base.BaseViewModel
import com.randy.mvvmposts.model.Post
import com.randy.mvvmposts.network.PostApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author randy
 * @since 7/19/18 11:18 AM
 */
class PostListViewModel : BaseViewModel() {
    @Inject
    lateinit var postApi: PostApi
    private val disposable: CompositeDisposable = CompositeDisposable()
    val loadingVisibility = MutableLiveData<Int>()
    val errorMessage = MutableLiveData<Int>()
    val errorClickListener = View.OnClickListener { loadPosts() }
    val postListAdapter = PostListAdapter()

    init {
        loadPosts()
    }

    private fun loadPosts() {
        disposable.add(
                postApi.getPosts()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe { onRetrievePostListStart() }
                        .doOnTerminate { onRetrievePostListFinish() }
                        .subscribe(
                                { onRetrievePostListSuccess(it) },
                                { onRetrievePostListError() }
                        )
        )
    }

    private fun onRetrievePostListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
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
        disposable.dispose()
    }
}