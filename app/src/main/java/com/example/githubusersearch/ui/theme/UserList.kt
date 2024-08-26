package com.example.githubusersearch.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.githubusersearch.data.model.Item

@Composable
fun UserList(users: List<Item>) {
    Column {
        users.forEach { user ->
            UserItem(user)
        }
    }
}

@Composable
fun UserItem(user: Item) {
    Row(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = rememberAsyncImagePainter(user.avatar_url),
            contentDescription = null,
            modifier = Modifier.size(50.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = user.login, style = MaterialTheme.typography.body1)
            Text(text = "ID: ${user.id}", style = MaterialTheme.typography.body2)
        }
    }
}
