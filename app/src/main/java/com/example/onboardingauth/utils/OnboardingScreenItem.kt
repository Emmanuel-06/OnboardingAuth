package com.example.onboardingauth.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onboardingauth.R
import com.example.onboardingauth.model.OnboardingUI
import com.example.onboardingauth.model.dataSource

@Composable
fun OnboardingScreenItem(
    onboardingUI: OnboardingUI
) {

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {

        Image(
            painter = painterResource(id = onboardingUI.image),
            contentDescription = "Onboarding Image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(height = 700.dp, width = 500.dp)
                .padding(top = 60.dp)

        )
        Surface(
            color = Color.White,
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
                .align(Alignment.BottomCenter)

        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(horizontal = 21.dp, vertical = 60.dp)
                    .fillMaxSize()
            ) {

                Text(
                    text = onboardingUI.title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = onboardingUI.description,
                    fontSize = 16.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun OnboardingScreenItemPreview() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
//        OnboardingScreenItem()
    }
}