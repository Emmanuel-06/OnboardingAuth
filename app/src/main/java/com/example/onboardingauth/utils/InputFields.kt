package com.example.onboardingauth.utils

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onboardingauth.R

@Preview(showBackground = true)
@Composable
fun Email(
    userInput: MutableState<String> = remember { mutableStateOf("") },
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = userInput.value,
        onValueChange = {
            userInput.value = it
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "email icon",
                tint = colorResource(id = R.color.grey300)
            )
        },
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = colorResource(id = R.color.grey100),
            focusedBorderColor = colorResource(id = R.color.primaryColor)
        ),
        label = {
            Text(
                text = "Email",
                color = colorResource(id = R.color.grey300)
            )
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun Password(
    userInput: MutableState<String> = remember { mutableStateOf("") },
    label: String = "Password",
    onTrailingIconClicked: ()-> Unit = {},
    text: String = "SHOW",
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = userInput.value,
        onValueChange = {
            userInput.value = it
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "password icon",
                tint = colorResource(id = R.color.grey300)
            )
        },
        label = {
            Text(
                text = label,
                color = colorResource(id = R.color.grey300)
            )
        },
        colors = OutlinedTextFieldDefaults.colors (
            unfocusedBorderColor = colorResource(id = R.color.grey100),
            focusedBorderColor = colorResource(id = R.color.primaryColor)
        ),
        shape = RoundedCornerShape(12.dp),
        trailingIcon = {
            androidx.compose.material3.TextButton(
                onClick = { onTrailingIconClicked()}
            ) {
                Text(
                    text = text,
                    fontSize = 10.sp,
                    color = Color(0xFF400A24)
                )
            }
        },
        modifier = modifier
    )

}

