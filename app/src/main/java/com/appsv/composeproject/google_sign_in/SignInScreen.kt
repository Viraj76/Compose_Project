package com.appsv.composeproject.google_sign_in

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    onGoogleSignIn : () -> Unit = {}
) {
    val isDark = isSystemInDarkTheme()


    Column(
        modifier = modifier.fillMaxSize().background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = if(isDark) Color.White else Color.Black
                    )
                ) {
                    append("Google ")
                }
                withStyle(
                    style = SpanStyle(
                        color = if(isDark) Color.White else Color(0xFF5F6368)
                    )
                ) {
                    append("Translate")
                }
            },
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Click on the button below to sign in with Google",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = if(isDark) Color.White else Color.Black
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                onGoogleSignIn()
            },
            modifier = Modifier
                .height(48.dp)
                .padding(horizontal = 12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = if(isDark) Color.White else Color.Black),
            border = BorderStroke(2.dp,Color.LightGray)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "Sign in with Google",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = if(isDark) Color.Black else Color.White
                )
            }
        }
    }
}
