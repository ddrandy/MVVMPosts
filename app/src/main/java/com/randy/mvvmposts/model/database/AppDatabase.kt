package com.randy.mvvmposts.model.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.randy.mvvmposts.model.Post
import com.randy.mvvmposts.model.PostDao

/**
 * @author randy
 * @since 7/11/18 3:07 PM
 */
@Database(entities = [Post::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}