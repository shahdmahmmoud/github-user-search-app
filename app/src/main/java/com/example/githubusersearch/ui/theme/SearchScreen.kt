package com.example.githubusersearch.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.githubusersearch.ui.theme.UserList
import com.example.githubusersearch.viewmodel.UserViewModel

@Composable
fun SearchScreen(viewModel: UserViewModel = viewModel()) {
    var query by remember { mutableStateOf(TextFieldValue("")) }

    Column(modifier = Modifier.padding(16.dp)) {
        BasicTextField(
            value = query,
            onValueChange = { query = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .padding(8.dp)
                ) {
                    innerTextField()
                }
            }
        )
        Button(onClick = { viewModel.searchUsers(query.text, 1) }) {
            Text("Search")
        }
        Spacer(modifier = Modifier.height(16.dp))
        val data = viewModel.userData.observeAsState()
        UserList(users = data.value?.items ?: emptyList())
    }
}
