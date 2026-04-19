package com.example.androidassignment.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidassignment.R
import com.example.androidassignment.data.DummyData
import com.example.androidassignment.data.MediaSection
import com.example.androidassignment.ui.screens.common_components.PlayNowButton
import com.example.androidassignment.ui.screens.home.components.BannerCmp
import com.example.androidassignment.ui.screens.home.components.MediaCmp
import com.example.androidassignment.ui.screens.home.components.PlanCard
import com.example.androidassignment.ui.screens.home.components.SearchBarCmp
import com.example.androidassignment.ui.theme.AndroidAssignmentTheme
import com.example.androidassignment.ui.theme.BackgroundColor

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: (String) -> Unit = {},
    onPlayClick: () -> Unit = {},
    viewModel: HomeViewModel = viewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Scaffold(
        containerColor = BackgroundColor,
    ) { innerPadding ->

        HomeScreenContent(
            searchInput = uiState.searchInput,
            onValueChange = { viewModel.changeInput(it) },
            sections = uiState.sections,
            onPlayClick = onPlayClick,
            modifier = Modifier.padding(innerPadding),
            onItemClick = navigateToDetail
        )

    }
}

@Composable
fun HomeScreenContent(
    searchInput: String = "",
    onValueChange: (String) -> Unit = {},
    sections: List<MediaSection>,
    modifier: Modifier = Modifier,
    onItemClick: (String) -> Unit = {},
    onPlayClick: () -> Unit = {},
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {

        // For baner
        item {
            BannerCmp(
                searchInput = searchInput,
                onValueChange = {
                    onValueChange(it)
                },
                onPlayClick = onPlayClick,
            )
        }


        // for the rest of the screen
        items(sections, key = { it.title }) { section ->
            MediaCmp(
                section = section,
                onItemClick = onItemClick
            )
        }

        item{
            PlanCard()
        }
    }
}




@Preview(showSystemUi = true)
@Composable
private fun HomeScreenContentPreview() {
    AndroidAssignmentTheme {
        Scaffold(
            containerColor = BackgroundColor,
        ) { innerPadding ->
            HomeScreenContent(
                sections = DummyData.sections,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}