package com.appsv.composeproject.uis

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appsv.composeproject.ui.theme.GrayishPurple
import java.nio.file.WatchEvent


@Preview
@Composable
fun ExpenseIncomeToggle() {
    var selectedOption by remember { mutableStateOf("Expense") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ToggleButton(
            isSelected = selectedOption == "Expense",
            text = "Expense",
            onClick = { selectedOption = "Expense" }
        )
        Spacer(modifier = Modifier.width(8.dp))
        ToggleButton(
            isSelected = selectedOption == "Income",
            text = "Income",
            onClick = { selectedOption = "Income" }
        )
    }
}

@Composable
fun ToggleButton(
    isSelected: Boolean,
    text: String,
    onClick: () -> Unit
) {
    val backgroundColor = if (isSelected) Color(0xFFF5F3FF) else Color.White
    val borderColor = if (isSelected) Color(0xFF6200EE) else Color(0xFFB0B0B0)
    val textColor = GrayishPurple

    Button(
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = backgroundColor,
            contentColor = textColor
        ),
        border = BorderStroke(1.dp, borderColor),
    ) {
        Row(
            modifier = Modifier.padding(vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            RadioButton(
                selected = isSelected,
                onClick = null, // Already handled by the button's onClick
                colors = RadioButtonDefaults.colors().copy(
                    selectedColor = Color(0xFF6200EE),
                    unselectedColor = Color.Gray
                )
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = text,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = textColor
            )
        }
    }
}
