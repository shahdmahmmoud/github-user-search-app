package com.example.githubusersearch.viewmodel

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubusersearch.data.model.UserData
import com.example.githubusersearch.data.repo.UserRepository
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.reflect.Modifier

class UserViewModel : ViewModel() {

    private val userRepository = UserRepository()

    // LiveData to observe user data
    private val _userData = MutableLiveData<UserData>()
    val userData: LiveData<UserData> get() = _userData

    // LiveData for error messages
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error



    // LiveData for loading state
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun searchUsers(query: String, page: Int) {
        _isLoading.value = true
        Log.d("name", "searchUsers: ")
        viewModelScope.launch {
            try {
                val response: Response<UserData> = userRepository.searchUsers(query, page)
                Log.d("name", "searchUsers:$response ")
                if (response.isSuccessful) {
                    _userData.value = response.body()
                } else {
                    _error.value = "Error: ${response.message()}"
                }
            } catch (e: Exception) {
                _error.value = "Exception: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}

