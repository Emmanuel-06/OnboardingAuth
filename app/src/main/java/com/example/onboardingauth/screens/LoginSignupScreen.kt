package com.example.onboardingauth.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.onboardingauth.R
import com.example.onboardingauth.utils.ButtonUILarge
import com.example.onboardingauth.utils.Email
import com.example.onboardingauth.utils.Password
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun LoginSignUp() {

    Column(
        verticalArrangement = Arrangement.spacedBy(32.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.primaryColor))
    ) {
        Column(
            modifier = Modifier
                .padding(start = 21.dp, top = 60.dp, end = 21.dp, bottom = 20.dp)
        ) {

            Text(
                text = "Get Started Now",
                fontSize = 24.sp,
                color = Color(0xFFFFFFFF)
            )

            Text(
                text = "Create an account or log in to explore about our app",
                fontSize = 12.sp,
                color = Color(0xFFFFFFFF)
            )
        }
        Tabs(
            modifier = Modifier.fillMaxSize().weight(1f)
        )
    }
}

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun Tabs(
    modifier: Modifier = Modifier
) {

    val tabs = listOf("Login", "Signup")

    val pagerState = rememberPagerState(initialPage = 0, pageCount = { tabs.size })
    val coroutineScope = rememberCoroutineScope()
    val selectedTabIndex = remember { derivedStateOf { pagerState.currentPage } }

    Surface(
        color = colorResource(id = R.color.white),
        shape = RoundedCornerShape(
            topStart = 16.dp,
            topEnd = 16.dp,
            bottomStart = 0.dp,
            bottomEnd = 0.dp
        )
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(top = 30.dp)
        ) {
            TabRow(
                selectedTabIndex = selectedTabIndex.value,
                containerColor = colorResource(id = R.color.grey100),
                indicator = { tabPositions: List<TabPosition> ->
                    Box(
                        modifier = modifier
                            .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                            .fillMaxHeight()
                            .padding(horizontal = 6.dp, vertical = 6.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(colorResource(id = R.color.white))
                            .zIndex(1f)
                    )
                },
                divider = {},
                contentColor = colorResource(id = R.color.black600),
                //rounded corner shape for tab row
                modifier = Modifier
                    .padding(horizontal = 21.dp)
                    .clip(RoundedCornerShape(12.dp))

            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex.value == index,
                        unselectedContentColor = colorResource(id = R.color.grey300),
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                        text = {
                            Text(text = title)
                        },
                        //rounded corner shape for click effect
                        modifier = Modifier
                            .padding(horizontal = 6.dp, vertical = 6.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .height(36.dp)
                            .zIndex(2f)
                    )
                }
            }

            HorizontalPager(
                state = pagerState,
                userScrollEnabled = false,
                verticalAlignment = Alignment.Top,
                modifier = Modifier.weight(1f)

            ) { page ->
                when (tabs[page]) {
                    "Login" -> LoginFormSection()
                    "Signup" -> SignUpFormSection()
                }
            }
        }
    }
}

@Composable
fun LoginFormSection(
    modifier: Modifier = Modifier
) {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = modifier
                .padding(21.dp)
                .fillMaxWidth()

        ) {
            Email(
                modifier = Modifier.fillMaxWidth()
            )
            Password(
                modifier = Modifier.fillMaxWidth()
            )
            ButtonUILarge(
                backgroundColor = colorResource(id = R.color.secondaryColor),
                text = "Login",
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

@Composable
fun SignUpFormSection(
    modifier: Modifier = Modifier
) {
    Surface(
        color = colorResource(id = R.color.white),
        shape = RoundedCornerShape(
            topStart = 16.dp,
            topEnd = 16.dp,
            bottomStart = 0.dp,
            bottomEnd = 0.dp
        )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier
                .padding(21.dp)
                .fillMaxWidth()
        ) {
            Email(
                modifier = Modifier.fillMaxWidth()
            )
            Password(
                modifier = Modifier.fillMaxWidth()
            )
            Password(
                label = "Confirm Password",
                modifier = Modifier.fillMaxWidth()
            )
            ButtonUILarge(
                backgroundColor = colorResource(id = R.color.secondaryColor),
                text = "SignUp",
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}