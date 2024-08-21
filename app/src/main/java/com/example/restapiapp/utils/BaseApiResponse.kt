package com.example.restapiapp.utils

import retrofit2.Response

abstract class BaseApiResponse {

    suspend fun <T> safeApiCall(api: suspend () -> Response<T>): NetworkResult<T> {

        try {
            val response = api()

            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return NetworkResult.Success(body)
                } ?: return errorMessage("No data available")

            }else{
                return errorMessage("${response.code() } ${response.message()}")
            }
        } catch (e: Exception) {
            return errorMessage(e.message.toString())
        }
    }

    private fun <T> errorMessage(e: String): NetworkResult<T> {
        return NetworkResult.Error("Error: ${e}")
    }
}