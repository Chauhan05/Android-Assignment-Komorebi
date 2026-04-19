package com.example.androidassignment.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidassignment.R
import com.example.androidassignment.ui.theme.AndroidAssignmentTheme

@Composable
fun PlanCard(modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 50.dp,
                end = 16.dp,
                bottom = 50.dp,
                start = 16.dp
            )
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {

            Image(
                painter = painterResource(R.drawable.plan_image),
                contentDescription = "planImage",
                modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            Text(
                "Choose your plan and\nsubscribe!",
                fontSize = 24.sp,
                modifier = Modifier
                    .align(
                        Alignment.TopCenter
                    )
                    .padding(top = 64.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                lineHeight = 30.sp
            )

            Text(
                "Join The Creative Network and select from our flexible subscription options tailored to suit your viewing preferences",
                fontSize = 14.sp,
                modifier=Modifier.align(
                    Alignment.Center
                ),
                textAlign = TextAlign.Center
            )

            Button(
                onClick = {},
                modifier=Modifier.align(
                    Alignment.BottomCenter
                ).
                padding(
                    bottom = 32.dp
                )
                ,
                shape = RoundedCornerShape(8.dp),
            ) {
                Text("Buy Subscription", fontSize = 14.sp,modifier=Modifier.padding(4.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PlanCardPreview() {
    AndroidAssignmentTheme { PlanCard() }
}