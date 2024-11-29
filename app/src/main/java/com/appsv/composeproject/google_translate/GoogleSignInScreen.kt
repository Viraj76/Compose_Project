package com.appsv.composeproject.google_translate


import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import android.accounts.Account
import android.accounts.AccountManager
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import android.util.Patterns
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient


@Composable
fun AutomatedGoogleSignIn(context: Context, onAccountSelected: (String) -> Unit) {
    var selectedAccount by remember { mutableStateOf<GoogleSignInAccount?>(null) }

    // Configure Google Sign-In
    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestEmail()
        .build()
    val googleSignInClient: GoogleSignInClient = GoogleSignIn.getClient(context, gso)

    // Google Sign-In Launcher
    val signInLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        val account = task.result
        if (account != null) {
            selectedAccount = account
            onAccountSelected(account.email ?: "No email")
        }
    }

    // Automatically check for the last signed-in account or trigger sign-in
    LaunchedEffect(Unit) {
        val lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(context)
        if (lastSignedInAccount != null) {
            selectedAccount = lastSignedInAccount
            onAccountSelected(lastSignedInAccount.email ?: "No email")
        } else {
            // Launch sign-in process if no account is found
            signInLauncher.launch(googleSignInClient.signInIntent)
        }
    }

    // Display selected account for debugging purposes (optional)
    if (selectedAccount != null) {
        Text(
            text = "Automatically Selected Account: ${selectedAccount?.email}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(16.dp)
        )
    }
}


