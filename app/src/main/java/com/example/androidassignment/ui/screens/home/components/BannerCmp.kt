package com.example.androidassignment.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.androidassignment.R
import com.example.androidassignment.ui.screens.common_components.PlayNowButton

@Composable
fun BannerCmp(
    searchInput: String = "",
    onValueChange: (String) -> Unit = {},
    modifier: Modifier = Modifier,
    onPlayClick: () -> Unit = {},
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(0.75f)
    ) {


        // first the image then the gradient
        // the search bar to the top
        // button at the bottom

        Image(
            painter = painterResource(R.drawable.banner_image),
            contentDescription = "Irrfan Khan",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.7f)
                        ),
                        startY = 300f
                    )
                )
        )

        SearchBarCmp(
            input = searchInput,
            onValueChange = {
                onValueChange(it)
            },
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 59.dp, start = 16.dp, end = 16.dp)
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "THE CREATIVE NETWORK ORIGINALS",
                fontSize = 15.sp,
                color = Color.White,
                letterSpacing = 1.sp
            )
            Text(
                text = "IRRFAN KHAN",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
            PlayNowButton(onClick = {
                onPlayClick()
            })
            Spacer(Modifier.height(8.dp))
            Text(
                text = "More Details",
                color = Color.White.copy(alpha = 0.9f),
                fontSize = 12.sp,
            )
        }
    }


}


@Preview
@Composable
private fun BannerCmpPreview() {
    BannerCmp(

    )
}