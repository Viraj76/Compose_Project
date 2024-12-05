package com.appsv.composeproject.uis

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.appsv.composeproject.R
import com.appsv.composeproject.ui.theme.LightGrayishBlue

@Preview(showBackground = true)
@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value  : String = "15 Dec 2024",
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    var date by remember { mutableStateOf("15 Dec 2024") }
    OutlinedTextField(
        value = value,
        onValueChange = { date = it },
        trailingIcon = trailingIcon,
        modifier = Modifier.fillMaxWidth(),
        colors = OutlinedTextFieldDefaults.colors().copy(
            focusedIndicatorColor = LightGrayishBlue,
            unfocusedIndicatorColor = LightGrayishBlue
        )
    )

}