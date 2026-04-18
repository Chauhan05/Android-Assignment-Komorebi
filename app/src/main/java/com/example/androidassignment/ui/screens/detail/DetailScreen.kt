package com.example.androidassignment.ui.screens.detail


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidassignment.R
import com.example.androidassignment.ui.screens.detail.components.MovieDetail
import com.example.androidassignment.ui.screens.detail.components.MovieImage
import com.example.androidassignment.ui.screens.detail.components.TabSwitch
import com.example.androidassignment.ui.screens.detail.components.TrailerCard
import com.example.androidassignment.data.MediaItem
import com.example.androidassignment.ui.theme.BackgroundColor

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    movieId: String = "",
    onBackClick: () -> Unit = {},
    viewModel: DetailViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(movieId) {
        viewModel.loadMovie(movieId)
    }

    Scaffold(containerColor = BackgroundColor) { innerPadding ->
        DetailScreenContent(
            media = uiState.media,
            onBackClick = onBackClick,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun DetailScreenContent(
    media: MediaItem,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedTab by rememberSaveable { mutableStateOf(0) }  // 0 Trailers  1Artist

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        item { MovieImage(media = media, onBackClick = onBackClick) }
        item { MovieDetail(media = media) }
        item {
            TabSwitch(
                selected = selectedTab,
                onSelect = { selectedTab = it }
            )
        }

        if (selectedTab == 0) {
            items(media.trailers, key = { it.id }) { trailer ->
                TrailerCard(trailer = trailer)
            }
        } else {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Artist info coming soon.",
                        color = Color.White.copy(alpha = 0.6f),
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}


@Composable
fun BadgeCmp(text: String) {
    Box(
        modifier = Modifier
            .border(1.dp, Color.White.copy(alpha = 0.3f), RoundedCornerShape(4.dp))
            .padding(horizontal = 8.dp, vertical = 3.dp)
    ) {
        Text(text = text, color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Medium)
    }
}


@Preview
@Composable
private fun DetailScreenContentPreview() {
    DetailScreenContent(
        media = MediaItem("0", "Irrfan Khan", R.drawable.card_0),
        onBackClick = {}
    )
}