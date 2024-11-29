package com.appsv.composeproject.google_translate

import KeyboardAwareScreen
import TranslationViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appsv.composeproject.R
import com.appsv.composeproject.google_translate.mvvm.TranslationRepository


@Composable
fun TranslationScreen(
    modifier: Modifier = Modifier,
    navigateToHomeScreen : () -> Unit
) {
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
                IconButton(onClick = {
                    navigateToHomeScreen()
                }) {
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
                val repository = TranslationRepository()
                val viewModel = TranslationViewModel(repository)
                viewModel.fetchDownloadedLanguages()
                KeyboardAwareScreen(
                    viewModel = viewModel,
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