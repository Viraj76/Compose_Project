//package com.appsv.composeproject
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.gestures.detectDragGestures
//import androidx.compose.foundation.gestures.detectTapGestures
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateListOf
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.Path
//import androidx.compose.ui.input.pointer.pointerInput
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun WhiteBoardApp(modifier: Modifier = Modifier) {
//
//    var currentPath = remember { mutableStateOf<Path?>(null) }
//
//
//    Column(modifier = Modifier.padding(8.dp)
//        .fillMaxWidth().background(Color.White)
//        .pointerInput(Unit){
//            detectDragGestures(
//                onDragStart = {
//                    currentPath.value = Path().apply { moveTo(it.x,it.y) }
//                },
//                onDragEnd = {
//                    currentPath?.let {
//
//                    }
//                },
//                onDrag = {change,_->
//                    val path = currentPath?: return@detectDragGestures
//                    path.
//                }
//            )
//        }
//    ) {
//
//    }
//
//}