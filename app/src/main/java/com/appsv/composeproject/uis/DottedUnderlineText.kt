package com.appsv.composeproject.uis

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UnderlinedText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color,
    backgroundColor: Color? = null
) {
    Column(
        modifier = modifier
            .padding(bottom = 2.dp)
            .drawWithContent {
                drawContent()
                val width = size.width
                val y = size.height + 2.dp.toPx() // Adjusts line position slightly below text
                drawLine(
                    color = color,
                    start = Offset(0f, y),
                    end = Offset(width, y),
                    strokeWidth = 1.dp.toPx() // Continuous line with 1.dp thickness
                )
            }
    ) {
        Box(
            modifier = modifier
                .background(backgroundColor ?: Color.Transparent)
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Text(
                text = "₹ $text",
                color = color,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Example() {
    UnderlinedText(
        text = "Electricity Bill",
        color = Color.Black,
        backgroundColor = Color.Transparent
    )
}
