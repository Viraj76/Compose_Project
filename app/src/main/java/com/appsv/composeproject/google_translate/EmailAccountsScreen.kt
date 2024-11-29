package com.appsv.composeproject.google_translate
import android.accounts.Account
import android.accounts.AccountManager
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import android.util.Patterns
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat

@Composable
fun EmailAccountsScreenn() {
    var emailAccounts by remember { mutableStateOf(listOf<String>()) }
    val context = LocalContext.current

    // Launch permission request
    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            emailAccounts = fetchEmailAccounts(context)
        }
    }

    // Check and request permission
    LaunchedEffect(Unit) {
        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.GET_ACCOUNTS_PRIVILEGED) == PackageManager.PERMISSION_GRANTED) {
            emailAccounts = fetchEmailAccounts(context)
        } else {
            requestPermissionLauncher.launch(android.Manifest.permission.GET_ACCOUNTS)
        }
    }

    // UI
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Available Email Accounts", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(emailAccounts) { email ->
                Text(text = email, style = MaterialTheme.typography.bodyLarge)
                Divider(modifier = Modifier.padding(vertical = 8.dp))
            }
        }
    }
}

fun fetchEmailAccounts(context: Context): List<String> {
    Log.d("VBFDINOIEU","fetch")

    val emailPattern = Patterns.EMAIL_ADDRESS // Email pattern
    val accountManager = AccountManager.get(context)
    val accounts: Array<Account> = accountManager.accounts // Get all accounts

    // Filter and return only valid email accounts
    return accounts.mapNotNull { account ->
        if (emailPattern.matcher(account.name).matches()) {
            Log.d("VBFDINOIEU", account.name)
            account.name
        } else {
            Log.d("VBFDINOIEU", "null")
            null
        }
    }
}