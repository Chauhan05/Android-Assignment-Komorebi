package com.example.androidassignment.ui.screens.detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidassignment.data.MediaItem
import com.example.androidassignment.ui.screens.detail.BadgeCmp

@Composable
fun MovieDetail(media: MediaItem) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "THE CREATIVE NETWORK ORIGINALS",
            color = Color.White.copy(alpha = 0.6f),
            fontSize = 10.sp,
            letterSpacing = 1.sp
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = media.title,
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Icon(
                    Icons.Default.Download,
                    "Download",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
                Icon(
                    Icons.Default.Share,
                    "Share",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
                Icon(
                    Icons.Default.FavoriteBorder,
                    "Like",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }
        }

        Text(
            text = "${media.year} • ${media.duration}",
            color = Color.White.copy(alpha = 0.7f),
            fontSize = 13.sp
        )
        Text(
            text = media.genres,
            color = Color.White.copy(alpha = 0.7f),
            fontSize = 13.sp
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(top = 4.dp)
        ) {
            BadgeCmp("4K")
            BadgeCmp("ATMOS")
            BadgeCmp("IMDb")
        }

        Spacer(Modifier.height(4.dp))

        Text(
            text = media.description,
            color = Color.White.copy(alpha = 0.8f),
            fontSize = 13.sp,
            lineHeight = 20.sp
        )
    }
}