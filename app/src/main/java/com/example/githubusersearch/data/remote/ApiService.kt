package com.example.githubusersearch.data.remote

import com.example.githubusersearch.data.model.UserData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
        @GET("search/users")
        suspend fun searchUsers(
            @Query("q") query: String,
            @Query("page") page: Int
        ): Response<UserData>
    }
