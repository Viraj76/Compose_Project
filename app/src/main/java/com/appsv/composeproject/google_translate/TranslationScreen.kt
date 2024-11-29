package com.appsv.composeproject.google_translate

import KeyboardAwareScreen
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.runtime.Composable
import android.util.Log
import android.view.ViewTreeObserver
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.appsv.composeproject.R
import com.appsv.composeproject.google_translate.LanguageSwitcherRow
import com.appsv.composeproject.google_translate.rememberImeState

@Preview
@Composable
fun TranslationScreen(modifier: Modifier = Modifier) {
    var translationMode by remember { mutableStateOf(true) }
    var isInputTextEmpty by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ){

        Column(
            modifier = Modifier.fillMaxSize()
                .statusBarsPadding()
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* Back navigation */ }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
                Row {

                    if(!isInputTextEmpty){
                        IconButton(onClick = {

                        }) {
                            Icon(
                                painter = painterResource(R.drawable.baseline_close_24),
                                contentDescription = "Close",
                                tint = Color.White
                            )
                        }
                    }
                    else{
                        IconButton(onClick = {

                        }) {
                            Icon(
                                painter = painterResource(R.drawable.baseline_history_24),
                                contentDescription = "History",
                                tint = Color.White
                            )
                        }
                    }
                    if(translationMode){
                        IconButton(onClick = {

                        }) {
                            Icon(
                                painter = painterResource(R.drawable.draw),
                                contentDescription = "Undo",
                                tint = Color.White
                            )
                        }
                    }
                    else{
                        IconButton(onClick = {

                        }) {
                            Icon(
                                painter = painterResource(R.drawable.baseline_star_border_24),
                                contentDescription = "Star",
                                tint = Color.White
                            )
                        }
                    }
                    IconButton(onClick = {

                    }) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "More Options",
                            tint = Color.White
                        )
                    }
                }
            }



            if(translationMode){
                KeyboardAwareScreen(
                    onTranslatedText = {
                        translationMode = false
                    },
                    onEnteringInputText = {it->
                        isInputTextEmpty = it
                    }
                )
            }

            if(!translationMode){
                Spacer(Modifier.height(20.dp))

                TranslatedText()
            }



        }


        if(!translationMode){
            ExtendedFloatingActionButton(
                modifier = Modifier.align(Alignment.BottomEnd).padding(20.dp).navigationBarsPadding(),
                onClick = {
                    translationMode = true
                },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Add, // Use the Add icon
                        contentDescription = "Add",
                        tint = Color.White // Icon color
                    )
                },
                text = {
                    Text(
                        text = "New Translation",
                        color = Color.White, // Text color
                        style = TextStyle(fontSize = 16.sp)
                    )
                },
                containerColor = Color.Blue, // Background color
                contentColor = Color.White // Content color
            )
        }

    }

}