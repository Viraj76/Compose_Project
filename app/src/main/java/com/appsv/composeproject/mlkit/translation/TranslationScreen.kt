//package com.appsv.composeproject.mlkit.translation
//
//import android.util.Log
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.OutlinedCard
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import com.google.mlkit.common.model.DownloadConditions
//import com.google.mlkit.nl.translate.TranslateLanguage
//import com.google.mlkit.nl.translate.Translation
//import com.google.mlkit.nl.translate.TranslatorOptions
//
//@Composable
//fun TranslationScreen(modifier: Modifier = Modifier) {
//    var englishTextField by remember { mutableStateOf("") }
//    var translatedText by remember { mutableStateOf("") }
//    var processTranslation by remember { mutableStateOf(false) }
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        contentAlignment = Alignment.Center
//    ) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.spacedBy(8.dp)
//        ) {
//
//            Text(
//                text = translatedText,
//                color = Color.White
//            )
//            TextField(
//                value = englishTextField,
//                onValueChange = { englishTextField = it },
//                label = { Text("Enter text") }
//            )
//
//            Button(onClick = {
//                processTranslation = true
//            }) {
//                Text("OK")
//            }
//        }
//    }
//
//    if(processTranslation){
//        // Create an English-German translator:
//        val options = TranslatorOptions.Builder()
//            .setSourceLanguage(TranslateLanguage.ENGLISH)
//            .setTargetLanguage(TranslateLanguage.HINDI)
//            .build()
//        val englishGermanTranslator = Translation.getClient(options)
//
//        var conditions = DownloadConditions.Builder()
//            .requireWifi()
//            .build()
//
//        englishGermanTranslator.downloadModelIfNeeded(conditions)
//            .addOnSuccessListener {
//                Log.d("TRANSLATION_APP", "Model downloaded!")
//
//                // Model downloaded successfully. Okay to start translating.
//                // (Set a flag, unhide the translation UI, etc.)
//            }
//            .addOnFailureListener { exception ->
//                // Model couldn’t be downloaded or other internal error.
//                // ...
//            }
//
//        englishGermanTranslator.translate(englishTextField)
//            .addOnSuccessListener { translatedTextt ->
//                translatedText = translatedTextt
//            }
//            .addOnFailureListener { exception ->
//                Log.d("TRANSLATION_APP", exception.message.toString())
//                // Error.
//                // ...
//            }
//
//
//    }
//
//}