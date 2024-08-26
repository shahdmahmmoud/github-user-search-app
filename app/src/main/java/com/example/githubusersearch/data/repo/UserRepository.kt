package com.example.githubusersearch.data.repo

    import com.example.githubusersearch.data.model.UserData
    import com.example.githubusersearch.data.remote.RetrofitInstance
    import retrofit2.Response

    class UserRepository {

        private val apiService = RetrofitInstance.apiService

        suspend fun searchUsers(query: String, page: Int): Response<UserData> {
            return apiService.searchUsers(query, page)
        }
}