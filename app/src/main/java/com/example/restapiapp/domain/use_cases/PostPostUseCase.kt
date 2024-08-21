package com.example.restapiapp.domain.use_cases

import com.example.restapiapp.data.PostRepository
import com.example.restapiapp.data.api.model.PostResponse
import javax.inject.Inject

class PostPostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {

   suspend fun invoke(body: PostResponse) =
        postRepository.postPost(body = body )

}