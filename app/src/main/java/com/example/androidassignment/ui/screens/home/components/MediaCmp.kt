package com.example.androidassignment.ui.screens.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidassignment.data.DummyData
import com.example.androidassignment.data.MediaSection

@Composable
fun MediaCmp(
    section: MediaSection,
    onItemClick: (String) -> Unit={},
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            text = section.title,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(section.items, key = { it.id }) { item ->
                MediaCard(
                    item = item,
                    onClick = { onItemClick(item.id) }
                )
            }
        }
    }
}


@Preview
@Composable
private fun MediaCmpPreview() {
    MediaCmp(
        section = DummyData.sections.first(),
    )
}