package com.example.androidassignment.ui.screens.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TabSwitch(selected: Int, onSelect: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White.copy(alpha = 0.05f))
            .padding(top = 12.dp, start = 20.dp, bottom = 12.dp, end = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        TabItem(
            label = "Trailers & More",
            isSelected = selected == 0,
            onClick = { onSelect(0) },
            modifier = Modifier.weight(1f)
        )
        TabItem(
            label = "Artist",
            isSelected = selected == 1,
            onClick = { onSelect(1) },
            modifier = Modifier.weight(1f)
        )
    }
}