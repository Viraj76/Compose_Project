package com.appsv.composeproject.google_sign_in

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.GetCredentialResponse
import com.google.android.datatransport.BuildConfig
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "Testing"

class GoogleCredSignIn(private val ctx: Context, serverClientId: String) {


object Constants{
    const val clientID = com.appsv.composeproject.BuildConfig.GOOGLE_CLIENT_ID
}

    private val credentialManager = CredentialManager.create(ctx)

    // GetGoogleIdOption used to retrieve a user's Google ID Token. 
    private val request = GetGoogleIdOption.Builder()
        .setFilterByAuthorizedAccounts(false)
        .setServerClientId(serverClientId)
        .setAutoSelectEnabled(true)
        .build().let {
            GetCredentialRequest.Builder()
                .addCredentialOption(it)
                .build()
        }


    fun googleLogin(callback: GoogleIdTokenCredential.() -> Unit) {
//        if (ctx !is AppCompatActivity) {
//            throw Exception("Please use Activity Context")
//        }

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val result = credentialManager.getCredential(
                    request = request,
                    context = ctx,
                )
                handleSignIn(callback, result)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


    private fun handleSignIn(
        callback: GoogleIdTokenCredential.() -> Unit,
        result: GetCredentialResponse
    ) {
        val credential = result.credential
        if (credential is CustomCredential && credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
            try {
                val googleIdTokenCredential = GoogleIdTokenCredential
                    .createFrom(credential.data)
                callback(googleIdTokenCredential)
                Log.i(TAG, "handleSignIn: $googleIdTokenCredential")
            } catch (e: GoogleIdTokenParsingException) {
                Log.e(TAG, "Received an invalid google id token response", e)
            }
        }
    }
}