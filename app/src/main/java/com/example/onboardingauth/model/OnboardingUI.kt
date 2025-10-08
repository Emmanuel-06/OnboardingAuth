package com.example.onboardingauth.model

import android.icu.text.CaseMap.Title
import androidx.annotation.DrawableRes
import androidx.compose.ui.res.painterResource
import com.example.onboardingauth.R

class OnboardingUI(
    @DrawableRes val image: Int,
    val title: String,
    val description: String
)

val dataSource = listOf(
    OnboardingUI(
        R.drawable.onboard1,
        "Match strap style with your personality",
        "Now explore the world of watch strap with us."
        ),
    OnboardingUI(
        R.drawable.onboard2,
        "Control your watch effortlessly",
        "Manage brightness, notifications, and modes—all from one easy dashboard."
        ),
    OnboardingUI(
        R.drawable.onboard3,
        "Never miss what matters",
        "Sync your calls, messages, and fitness updates in real time—right on your wrist."
        ),
)