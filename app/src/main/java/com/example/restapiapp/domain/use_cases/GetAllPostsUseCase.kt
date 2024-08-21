package com.example.restapiapp.domain.use_cases

import com.example.restapiapp.data.PostRepository
import javax.inject.Inject

class GetAllPostsUseCase @Inject constructor(
    private val postRepository: PostRepository
) {

    suspend fun invoke() = postRepository.getAllPosts()

}