package com.randy.mvvmposts.ui.post

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.randy.mvvmposts.databinding.ActivityPostListBinding

/**
 * @author randy
 * @since 7/13/18 5:06 PM
 */
class PostListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostListBinding
    private lateinit var viewModel: PostListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_post_list)
    }
}