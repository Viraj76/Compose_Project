package com.appsv.composeproject.google_translate.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.appsv.composeproject.google_translate.HomeScreen
import com.appsv.composeproject.google_translate.TranslationScreen

@Composable
fun SetUpNavigation(modifier: Modifier = Modifier) {

    val navController = rememberNavController()
    NavHost(navController  = navController, startDestination = HomeScreen){
        composable<HomeScreen> {
            HomeScreen(){
                navController.navigate(TranslationScreen)
            }
        }

        composable<TranslationScreen> {
            TranslationScreen(){
                navController.navigate(HomeScreen){
                    popUpTo<HomeScreen>(){
                        inclusive = true
                    }
                }
            }
        }
    }

}