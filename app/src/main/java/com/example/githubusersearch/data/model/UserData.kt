package com.example.githubusersearch.data.model

data class UserData(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)