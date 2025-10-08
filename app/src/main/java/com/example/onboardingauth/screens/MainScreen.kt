package com.example.onboardingauth.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun ShowOnboardingScreen() {

    val context = LocalContext.current

    Toast.makeText(context, "Onboarding Completed", Toast.LENGTH_LONG)
        .show()
}