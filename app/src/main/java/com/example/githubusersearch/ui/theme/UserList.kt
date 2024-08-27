package com.example.githubusersearch.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.githubusersearch.data.model.Item

@Composable
fun UserList(users: List<Item>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(users) { user ->
            UserItem(user)
        }
    }
}

@Composable
fun UserItem(user: Item) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = rememberAsyncImagePainter(user.avatar_url),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = user.login,
                style = MaterialTheme.typography.bodyMedium // Update style for Material3
            )
            Text(
                text = "ID: ${user.id}",
                style = MaterialTheme.typography.bodySmall // Update style for Material3
            )
        }
    }
}
