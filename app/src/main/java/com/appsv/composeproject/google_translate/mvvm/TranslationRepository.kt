package com.appsv.composeproject.google_translate.mvvm

import android.util.Log
import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.common.model.RemoteModelManager
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.TranslateRemoteModel
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.Translator
import com.google.mlkit.nl.translate.TranslatorOptions


class TranslationRepository {
    private val translator: Translator
    private val modelManager = RemoteModelManager.getInstance()

    init {
        val options = TranslatorOptions.Builder()
            .setSourceLanguage(TranslateLanguage.ENGLISH)
            .setTargetLanguage(TranslateLanguage.HINDI)
            .build()
        translator = Translation.getClient(options)
    }

    fun translateText(
        text: String,
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit
    ) {
        val conditions = DownloadConditions.Builder()
            .requireWifi()
            .build()

        translator.downloadModelIfNeeded(conditions)
            .addOnSuccessListener {
                translator.translate(text)
                    .addOnSuccessListener { translatedText ->
                        onSuccess(translatedText)
                    }
                    .addOnFailureListener { exception ->
                        Log.e("TranslationRepository", "Translation error: ${exception.message}")
                        onError("Translation failed")
                    }
            }
            .addOnFailureListener { exception ->
                Log.e("TranslationRepository", "Model download error: ${exception.message}")
                onError("Model download failed")
            }
    }

    fun getDownloadedLanguages(
        onSuccess: (List<String>) -> Unit,
        onError: (String) -> Unit
    ) {
        modelManager.getDownloadedModels(TranslateRemoteModel::class.java)
            .addOnSuccessListener { translateRemoteModels ->
                val languages = translateRemoteModels.mapNotNull { model ->
                    TranslateLanguage.fromLanguageTag(model.language)
                }

                if (languages.isNotEmpty()) {
                    Log.d("TranslationRepository", "Downloaded languages: $languages")
                    onSuccess(languages)
                } else {
                    Log.d("TranslationRepository", "No languages downloaded")
                    onError("No languages downloaded")
                }
            }
            .addOnFailureListener { exception ->
                Log.e("TranslationRepository", "Error fetching languages: ${exception.message}")
                onError("Failed to fetch downloaded languages: ${exception.message}")
            }
    }

}
