package com.randy.mvvmposts.injection

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import com.randy.mvvmposts.model.database.AppDatabase
import com.randy.mvvmposts.ui.post.PostListViewModel

/**
 * @author randy
 * @since 7/11/18 3:15 PM
 */
class ViewModelFactory(private val activity: AppCompatActivity) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostListViewModel::class.java)) {
            val db = Room.databaseBuilder(activity.applicationContext,
                    AppDatabase::class.java, "posts")
                    .build()
            @Suppress("UNCHECKED_CAST")
            return PostListViewModel(db.postDao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}