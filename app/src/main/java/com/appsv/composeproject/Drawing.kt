//package com.appsv.composeproject
//
//import androidx.compose.runtime.Composable
//import android.graphics.Paint
//import android.widget.Toast
//import androidx.compose.foundation.Canvas
//import androidx.compose.foundation.background
//import androidx.compose.foundation.gestures.detectDragGestures
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.ColumnScopeInstance.weight
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.shadow
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.graphics.*
//import androidx.compose.ui.graphics.drawscope.DrawScope
//import androidx.compose.ui.graphics.drawscope.Stroke
//import androidx.compose.ui.input.pointer.consumeDownChange
//import androidx.compose.ui.input.pointer.consumePositionChange
//import androidx.compose.ui.input.pointer.pointerInput
//import androidx.compose.ui.input.pointer.positionChange
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.unit.dp
//
//
//@Composable
//fun Drawing(
//    strokePath : List<Pair<Path,Boolean>>,
//) {
//
////    val currentPath by remember { mutableStateOf<Path?>(null) }
//    val paths = remember { mutableStateListOf<Pair<Path, PathProperties>>() }
//    var currentPath by remember { mutableStateOf(Path()) }
//    var motionEvent by remember { mutableStateOf(MotionEvent.Idle) }
//    var previousPosition by remember { mutableStateOf(Offset.Unspecified) }
//    var currentPosition by remember { mutableStateOf(Offset.Unspecified) }
//    var drawMode by remember { mutableStateOf(DrawMode.Draw) }
//
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//    ) {
//        val drawModifier = Modifier
//            .padding(8.dp)
//            .shadow(1.dp)
//            .fillMaxWidth()
//            .weight(1f)
//            .background(Color.White)
////            .background(getRandomColor())
//            .pointerInput(Unit){
//                detectDragGestures(
//                    onDragStart = { pointerInputChange ->
//                        motionEvent = MotionEvent.Down
//                        currentPosition = pointerInputChange.po
//                        pointerInputChange.consumeDownChange()
//
//                    },
//                    onDrag = { pointerInputChange ->
//                        motionEvent = MotionEvent.Move
//                        currentPosition = pointerInputChange.position
//
//                        if (drawMode == DrawMode.Touch) {
//                            val change = pointerInputChange.positionChange()
//                            println("DRAG: $change")
//                            paths.forEach { entry ->
//                                val path: Path = entry.first
//                                path.translate(change)
//                            }
//                            currentPath.translate(change)
//                        }
//                        pointerInputChange.consumePositionChange()
//
//                    },
//                    onDragEnd = { pointerInputChange ->
//                        motionEvent = MotionEvent.Up
//                        pointerInputChange.consumeDownChange()
//                    }
//                )
//            }
//    }
//
//}