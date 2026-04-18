package com.example.androidassignment.ui.screens.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androidassignment.ui.screens.common_components.PlayNowButton
import com.example.androidassignment.data.MediaItem

@Composable
fun MovieImage(media: MediaItem, onBackClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(0.75f)
    ) {
        Image(
            painter = painterResource(media.image),
            contentDescription = media.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )


        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(12.dp)
                .size(32.dp)
                .clip(RoundedCornerShape(50))
                .background(Color.Black.copy(alpha = 0.5f))
                .clickable(onClick = onBackClick),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Default.Close, "Close", tint = Color.White, modifier = Modifier.size(18.dp))
        }

        PlayNowButton(
            onClick = {

            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        )
    }
}