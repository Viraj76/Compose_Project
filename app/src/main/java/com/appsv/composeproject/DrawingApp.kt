package com.appsv.composeproject

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Line(
    val start: Offset,
    val end: Offset,
    val color: Color = Color.Black,
    val isEraser: Boolean = false
)

@Composable
fun DrawingScreen() {
    var isEraseMode by remember { mutableStateOf(false) }
    val lines = remember { mutableStateListOf<Line>() }

    // State for tracking current coordinates
    var currentCoordinates by remember { mutableStateOf("") }
    var deletedLineInfo by remember { mutableStateOf("") }
    var lastDeletedCount by remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        // Control buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { isEraseMode = !isEraseMode }
            ) {
                Text(if (isEraseMode) "Draw" else "Erase")
            }

            Button(
                onClick = {
                    lines.clear()
                    currentCoordinates = ""
                    deletedLineInfo = "Cleared all lines"
                }
            ) {
                Text("Clear")
            }
        }

        // Coordinates display
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.LightGray.copy(alpha = 0.3f))
        ) {
            Text(
                text = "Mode: ${if (isEraseMode) "Eraser" else "Draw"}",
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = "Current Position: $currentCoordinates",
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier.padding(4.dp)
            )
            if (deletedLineInfo.isNotEmpty()) {
                Text(
                    text = deletedLineInfo,
                    style = TextStyle(fontSize = 14.sp, color = Color.Red),
                    modifier = Modifier.padding(4.dp)
                )
            }
        }

        // Drawing canvas
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectDragGestures(
                        onDragStart = { offset ->
                            currentCoordinates = "Start: (${offset.x.toInt()}, ${offset.y.toInt()})"
                        },
                        onDragEnd = {
                            if (isEraseMode) {
                                deletedLineInfo = "Last action: Deleted $lastDeletedCount lines"
                            }
                        }
                    ) { change, dragAmount ->
                        change.consume()

                        val currentPosition = change.position
                        val previousPosition = currentPosition - dragAmount

                        // Update current coordinates
                        currentCoordinates = "Current: (${currentPosition.x.toInt()}, ${currentPosition.y.toInt()})"

                        if (isEraseMode) {
                            // Count lines before deletion
                            val beforeCount = lines.size

                            // When in erase mode, remove lines that are close to the touch point
                            lines.removeAll { line ->
                                isPointNearLine(
                                    point = currentPosition,
                                    lineStart = line.start,
                                    lineEnd = line.end,
                                    threshold = 20f
                                )
                            }

                            // Calculate how many lines were deleted
                            lastDeletedCount = beforeCount - lines.size
                            if (lastDeletedCount > 0) {
                                deletedLineInfo = "Deleting... (${lastDeletedCount} lines removed)"
                            }
                        } else {
                            // Add new line in draw mode
                            val line = Line(
                                start = previousPosition,
                                end = currentPosition,
                                isEraser = false
                            )
                            lines.add(line)
                            deletedLineInfo = ""
                        }
                    }
                }
        ) {
            lines.forEach { line ->
                drawLine(
                    color = line.color,
                    start = line.start,
                    end = line.end,
                    strokeWidth = 5.dp.toPx(),
                    cap = StrokeCap.Round
                )
            }
        }
    }
}

private fun isPointNearLine(point: Offset, lineStart: Offset, lineEnd: Offset, threshold: Float): Boolean {
    val numerator = ((point.x - lineStart.x) * (lineEnd.x - lineStart.x) +
            (point.y - lineStart.y) * (lineEnd.y - lineStart.y))
    val denominator = ((lineEnd.x - lineStart.x) * (lineEnd.x - lineStart.x) +
            (lineEnd.y - lineStart.y) * (lineEnd.y - lineStart.y))

    if (denominator == 0f) return false

    val t = (numerator / denominator).coerceIn(0f, 1f)

    val projectionX = lineStart.x + t * (lineEnd.x - lineStart.x)
    val projectionY = lineStart.y + t * (lineEnd.y - lineStart.y)

    val distance = kotlin.math.sqrt(
        (point.x - projectionX) * (point.x - projectionX) +
                (point.y - projectionY) * (point.y - projectionY)
    )

    return distance < threshold
}