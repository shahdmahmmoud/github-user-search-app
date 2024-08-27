package com.example.githubusersearch.data.model

import coil.request.ImageRequest

data class UserData(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int,
    val avatarUrl: ImageRequest,
    val login: Any
) {
}