package com.appsv.composeproject.google_sign_in

import android.content.Context
import android.renderscript.ScriptGroup.Builder2
import androidx.credentials.ClearCredentialStateRequest
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.GetCredentialResponse
import androidx.credentials.exceptions.GetCredentialCancellationException
import androidx.credentials.exceptions.GetCredentialException
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow


/**
 * Handles user authentication via Gmail accounts.
 * Displays all logged-in emails, and authenticates the user upon selection.
 */

class GoogleAuthenticator(private val context: Context) {
    val CLIENT_ID: String =
        "401047126786-i6cqr63g6153nvpvd2vc2kco89j2omai.apps.googleusercontent.com"

    val credentialManager = CredentialManager.create(context)

    val request: GetCredentialRequest = GetGoogleIdOption.Builder()
        .setFilterByAuthorizedAccounts(true)
        .setServerClientId(CLIENT_ID)
        .setAutoSelectEnabled(true)
        .build().let {
            GetCredentialRequest.Builder()
                .addCredentialOption(it)
                .build()
        }


    fun authenticate(): Flow<GoogleIdTokenCredential?> = callbackFlow {
        try {
            val result = credentialManager.getCredential(
                request = request,
                context = context,
            )
            val credentials = handleSignIn(result)
            trySend(credentials)

        } catch (e: GetCredentialException) {
            trySend(null)
        }
        awaitClose {}
    }

    private fun handleSignIn(result: GetCredentialResponse): GoogleIdTokenCredential? {

        when (val credential = result.credential) {

            is CustomCredential -> {

                return if (credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                    try {
                        GoogleIdTokenCredential.createFrom(credential.data)
                    } catch (e: GoogleIdTokenParsingException) {
                        null
                    }
                } else {

                    null
                }
            }

            else -> {
                return null
            }
        }
    }
}
