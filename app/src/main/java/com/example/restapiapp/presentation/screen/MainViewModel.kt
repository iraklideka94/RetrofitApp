package com.example.restapiapp.presentation.screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restapiapp.data.api.model.PostResponse
import com.example.restapiapp.domain.use_cases.DeletePostUseCase
import com.example.restapiapp.domain.use_cases.GetAllPostsUseCase
import com.example.restapiapp.domain.use_cases.PatchPostUseCase
import com.example.restapiapp.domain.use_cases.PostPostUseCase
import com.example.restapiapp.domain.use_cases.PutPostUseCase
import com.example.restapiapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllPostsUseCase: GetAllPostsUseCase,
    private val deletePostUseCase: DeletePostUseCase,
    private val postPostUseCase: PostPostUseCase,
    private val putPostUseCase: PutPostUseCase,
    private val patchPostUseCase: PatchPostUseCase
): ViewModel() {

    private val _allPostsResponse = MutableLiveData<NetworkResult<List<PostResponse>>>()
    val allPostsResponse: LiveData<NetworkResult<List<PostResponse>>>
        get() = _allPostsResponse


    init {
        getAllPosts()
    }

    private fun getAllPosts() {
        viewModelScope.launch {
            getAllPostsUseCase.invoke().let {
                _allPostsResponse.value = it
            }
        }
    }

    fun postPosts(){
        viewModelScope.launch {
            postPostUseCase.invoke(body = PostResponse(title = "Test title",
                body = "Test body"))
        }
    }

    fun putPosts(){
        viewModelScope.launch {
            putPostUseCase.invoke(id = "1",body = PostResponse(title = "Test title",
                body = "Test body")).let {
                Log.d("checkData", "${it.data} ")
            }
        }
    }

    fun patchPosts(){
        viewModelScope.launch {
            patchPostUseCase.invoke(id = "1",body = PostResponse(title = "Test title",
                body = "Test body")).let {
                Log.d("checkData", "${it.data} ")
            }
        }
    }

    fun deletePosts(){
        viewModelScope.launch {
            deletePostUseCase.invoke(id = "1").let {
                Log.d("checkData", "${it.data} ")
            }
        }
    }

}