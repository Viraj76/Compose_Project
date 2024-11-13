//package com.appsv.composeproject.google_sign_in
//
//import android.credentials.GetCredentialRequest
//import android.os.Build
//import androidx.annotation.RequiresApi
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import com.google.android.libraries.identity.googleid.GetGoogleIdOption
//import java.security.MessageDigest
//import java.util.UUID
//
//object Constants{
//    const val clientID = "648700745815-jk1780fl6qkn72flpt1hhs6k9j7d21ta.apps.googleusercontent.com"
//}
//@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
//@Composable
//fun GoogleSignInButton(modifier: Modifier = Modifier) {
//
//    val context = LocalContext.current
//
//    val onClick : () -> Unit ={
//        val rawNonce = UUID.randomUUID().toString()
//        val bytes = rawNonce.toByteArray()
//        val md = MessageDigest.getInstance("SHA-256")
//        val digest = md.digest(bytes)
//        val hashedNonce = digest.fold( "") { str, it -> str + "%02x".format(it) }
//
//        val googleIdOption: GetGoogleIdOption = GetGoogleIdOption.Builder()
//            .setFilterByAuthorizedAccounts(false)
//            .setServerClientId("867753687091-r6bqa20g78ci2ea57q15ujr4kuvr7hpo.apps.googleusercontent.com")
//            .setNonce(hashedNonce)
//            .build()
//
//        val request: GetCredentialRequest = GetCredentialRequest.Builder()
//            .addCredentialOption(googleIdOption)
//            .build()
//
//        coroutineScope.launch {
//            try {
//                val result = credentialManager.getCredential(
//                    request = request,
//                    context = context,
//                )
//
//                val credential = result.credential
//
//                val googleIdTokenCredential = GoogleIdTokenCredential
//                    .createFrom(credential.data)
//
//                val googleIdToken = googleIdTokenCredential.idToken
//
//                Log.i(TAG, googleIdToken)
//
//                Toast.makeText(context, "You are signed in!", Toast.LENGTH_SHORT).show()
//            } catch (e: GetCredentialException) {
//                Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
//            }
//            catch (e: GoogleTokenParsingEsception) {
//                Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
//            }
//        }
//
//
//
//    }
//
//}