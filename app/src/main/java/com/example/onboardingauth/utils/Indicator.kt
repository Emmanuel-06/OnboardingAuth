package com.example.onboardingauth.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Indicator(
    pageSize: Int,
    currentPage: Int,
    selectedColor: Color = Color(0xFF400A24),
    unSelectedColor: Color = Color(0xFFB6B6B5)
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        modifier = Modifier.width(100.dp)
    ) {
        repeat(pageSize) {
            if(it == currentPage){
                Box(
                    modifier = Modifier
                        .height(8.dp)
                        .width(30.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(color = selectedColor)
                )
            } else {
                Box(
                    modifier = Modifier
                        .height(8.dp)
                        .width(8.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(color = unSelectedColor)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun IndicatorPreview() {
    Indicator(pageSize = 3, currentPage = 0)
}
