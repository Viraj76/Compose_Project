package com.appsv.composeproject.google_translate

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appsv.composeproject.R


@Composable
fun HomeScreen(
    navigateToTranslationScreen : () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) {

            Column(
                modifier = Modifier
                    .weight(0.7f)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp))
                    .background(Color.Black)
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Star",
                        tint = Color.White
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            ) {
                                append("Google")
                            }
                            append(" ") // Add a space between the words
                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.Normal,
                                    color = Color.White
                                )
                            ) {
                                append("Translate")
                            }
                        },
                        style = TextStyle(fontSize = 20.sp),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(1f)
                    )

                    Image(
                        modifier = Modifier.clip(CircleShape).size(40.dp),
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Profile",

                    )
                }

                Spacer(modifier = Modifier.height(50.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.weight(0.8f)
                            .clickable(
                                onClick = { navigateToTranslationScreen() },
                                indication = null, // Disables the ripple effect
                                interactionSource = remember { MutableInteractionSource() } // Keeps track of interactions
                            ),
                        text = "Enter text",
                        style = TextStyle(
                            fontSize = 37.sp,
                            color = Color.White
                        ),
                    )
                    Icon(
                        modifier = Modifier.padding(end = 5.dp).size(30.dp),
                        painter = painterResource(id = R.drawable.draw),
                        contentDescription = "Paste",
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(50.dp))

                Button(
                    onClick = { },
                    modifier = Modifier.align(Alignment.Start),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_content_paste_24),
                        contentDescription = "Paste",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Paste", color = Color.White)
                }

                Spacer(Modifier.weight(1f))

                Row(
                    modifier = Modifier
                        .fillMaxWidth().padding(bottom = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .height(5.dp)
                            .width(60.dp )
                            .clip(CircleShape)
                            .background(Color.Gray)
                    )
                }


            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.3f)
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                LanguageSwitcherRow(
                    leftButtonText = "English",
                    rightButtonText = "Hindi",
                    onLeftButtonClick = {}
                ) { }

                ActionRow()
            }
        }
    }
}



