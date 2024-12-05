package com.appsv.composeproject.uis

import android.R.attr.angle
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable
fun AmountTextField(
    modifier: Modifier = Modifier,
    value : String= "0.00",
    isEnteringAmount  : Boolean = false
) {

   if(isEnteringAmount){
       BasicTextField(
           value = value,
           onValueChange = { newValue ->

           },
           textStyle = androidx.compose.ui.text.TextStyle(
               fontSize = 22.sp,
               color = Color(0xFF1D1F1C)
           ),
           singleLine = true,
           modifier = Modifier
               .width(120.dp)
               .background(
                   color = Color.LightGray.copy(alpha = 0.2f),
                   shape = RoundedCornerShape(4.dp)
               )
               .padding(8.dp),
           keyboardOptions = KeyboardOptions(
               keyboardType = KeyboardType.Number,
               imeAction = ImeAction.Done
           ),
           keyboardActions = KeyboardActions(
               onDone = {
               }
           )
       )
   }
    else{
       UnderlinedText(
           text = "23423.0",
           color = Color.Black,
           backgroundColor = Color.Transparent
       )
   }

}