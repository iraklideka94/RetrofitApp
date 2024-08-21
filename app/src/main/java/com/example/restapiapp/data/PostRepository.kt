package com.example.restapiapp.data

import com.example.restapiapp.data.api.RemoteDataSource
import com.example.restapiapp.data.api.model.PostResponse
import com.example.restapiapp.utils.BaseApiResponse
import com.example.restapiapp.utils.NetworkResult
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : BaseApiResponse() {

    suspend fun getAllPosts(): NetworkResult<List<PostResponse>> {
        return safeApiCall {
            remoteDataSource.getAllPosts()
        }
    }

    suspend fun postPost(body: PostResponse): NetworkResult<PostResponse> {
        return safeApiCall {
            remoteDataSource.postPost(body = body)
        }
    }


    suspend fun putPost(id: String, body: PostResponse): NetworkResult<PostResponse> {
        return safeApiCall {
            remoteDataSource.putPost(id = id, body = body)
        }
    }

    suspend fun patchPost(id: String, body: PostResponse): NetworkResult<PostResponse> {
        return safeApiCall {
            remoteDataSource.patchPost(id = id, body = body)
        }
    }

    suspend fun deletePost(id: String): NetworkResult<PostResponse> {
        return safeApiCall {
            remoteDataSource.deletePost(id = id)
        }
    }
}