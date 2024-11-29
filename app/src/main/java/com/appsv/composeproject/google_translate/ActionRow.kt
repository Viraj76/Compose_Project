package com.appsv.composeproject.google_translate

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appsv.composeproject.R

@Composable
fun ActionRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            IconButton(
                onClick = { /* Handle Conversation Click */ },
                modifier = Modifier
                    .size(64.dp)
                    .background(Color.Blue, CircleShape)
            ) {
                Icon(
                    painter = painterResource(R.drawable.conversation_icon),
                    contentDescription = "Conversation",
                    tint = Color.White
                )
            }
            Text(
                text = "Conversation",
                color = Color.White,
                fontSize = 12.sp
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                onClick = { /* Handle Microphone Click */ },
                modifier = Modifier
                    .size(100.dp)
                    .background(Color(0xFFCAE9FF), CircleShape)
            ) {
                Icon(
                    modifier = Modifier.size(35.dp),
                    painter = painterResource(R.drawable.mic_icon),
                    contentDescription = "Microphone",
                    tint = Color.Black
                )
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            IconButton(
                onClick = { /* Handle Camera Click */ },
                modifier = Modifier
                    .size(64.dp)
                    .background(Color.Blue, CircleShape)
            ) {
                Icon(
                    painter = painterResource(R.drawable.camera_icon),
                    contentDescription = "Camera",
                    tint = Color.White
                )
            }
            Text(
                text = "Camera",
                color = Color.White,
                fontSize = 12.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewActionRow() {
    ActionRow()
}
