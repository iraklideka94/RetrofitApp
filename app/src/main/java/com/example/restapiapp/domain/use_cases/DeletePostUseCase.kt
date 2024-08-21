package com.example.restapiapp.domain.use_cases

import com.example.restapiapp.data.PostRepository
import javax.inject.Inject

class DeletePostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend fun invoke(id: String) = postRepository.deletePost(id = id)

}