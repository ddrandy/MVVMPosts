package com.randy.mvvmposts.network

import com.randy.mvvmposts.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * @author randy
 * @since 7/10/18 4:44 PM
 *
 * The interface which provides methods to get result of webservices
 */
interface PostApi {
    /**
     * Get the list of the post from the API
     */
    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}