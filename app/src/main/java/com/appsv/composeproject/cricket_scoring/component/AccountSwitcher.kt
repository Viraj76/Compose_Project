package com.appsv.composeproject.cricket_scoring.component

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AccountSwitcher(
    accountNames: List<String> // List of account names
) {
    var currentAccountIndex by remember { mutableStateOf(0) }
    val accountCount = accountNames.size

    // Animation settings
    val transition = updateTransition(targetState = currentAccountIndex, label = "Account Transition")
    val scale by transition.animateFloat(
        label = "Scale Animation",
        transitionSpec = { tween(durationMillis = 300) }
    ) { if (it == currentAccountIndex) 1f else 0.8f }

    val offsetY by transition.animateFloat(
        label = "Offset Animation",
        transitionSpec = { tween(durationMillis = 300, easing = FastOutSlowInEasing) }
    ) { targetIndex ->
        if (targetIndex == currentAccountIndex) 0f else 100f
    }

    Box(
        modifier = Modifier
            .size(120.dp, 60.dp) // Adjust size to fit text content
            .pointerInput(Unit) {
                detectVerticalDragGestures { change, dragAmount ->
                    if (dragAmount < -10) { // Swipe up
                        currentAccountIndex = (currentAccountIndex + 1) % accountCount
                    } else if (dragAmount > 10) { // Swipe down
                        currentAccountIndex =
                            (currentAccountIndex - 1 + accountCount) % accountCount
                    }
                    change.consume() // Consume the gesture
                }
            },
        contentAlignment = Alignment.Center
    ) {
        // Display the current account name with scaling and translation animation
        Text(
            text = accountNames[currentAccountIndex],
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier
                .background(
                    Color(0xFF6200EE),
                    MaterialTheme.shapes.medium
                ) // Purple background with rounded shape
                .padding(16.dp)
                .scale(scale)
                .offset(y = offsetY.dp)
        )
    }
}


@Preview
@Composable
private fun AccountSwitcherPreview() {

    AccountSwitcher(
        listOf("A","B","C")
    )

}