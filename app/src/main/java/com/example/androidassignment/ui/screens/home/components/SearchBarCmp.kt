package com.example.androidassignment.ui.screens.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchBarCmp(
    input: String = "",
    onValueChange: (String) -> Unit = {},
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = input,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        placeholder = {
            Text(
                text = "Search your documentaries here",
                color = Color.White.copy(alpha = 0.6f),
                fontSize = 13.sp
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.White.copy(alpha = 0.7f),
                modifier = Modifier.size(18.dp)
            )
        },
        singleLine = true,
        shape = RoundedCornerShape(6.dp),
        textStyle = LocalTextStyle.current.copy(color = Color.White, fontSize = 13.sp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.Black,
            unfocusedContainerColor = Color.Black,
            focusedBorderColor = Color.White.copy(alpha = 0.2f),
            unfocusedBorderColor = Color.White.copy(alpha = 0.2f),
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
        )
    )
}