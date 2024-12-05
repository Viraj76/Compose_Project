package com.appsv.composeproject.uis

import RequiredText
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.util.trace
import com.appsv.composeproject.R
import com.appsv.composeproject.ui.theme.ColorPrimary
import com.appsv.composeproject.ui.theme.ColorSecondaryVariant
import com.appsv.composeproject.ui.theme.LightGrayishBlue


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun RecordExpenseScreen() {
    var isExpense by remember { mutableStateOf(true) }
    var date by remember { mutableStateOf("15 Dec 2024") }
    var description by remember { mutableStateOf("Electricity Bill") }
    var amount by remember { mutableStateOf("3500.0") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Record Expense",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Back Icon"
                        )
                    }
                }
            )
        },
        containerColor = ColorSecondaryVariant,
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                // Toggle between Expense and Income
                ExpenseIncomeToggle()

                var show by remember { mutableStateOf(false) }
                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier.fillMaxWidth().background(Color.White),

                ){
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        RequiredText("DATE")
                        Spacer(modifier = Modifier.height(10.dp))
                        CustomTextField(
                            trailingIcon = {
                                IconButton(
                                    onClick = {
                                        show = true
                                    }
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.baseline_calendar_today_24),
                                        contentDescription = "Calendar Icon",
                                        tint = Color.Gray
                                    )
                                }
                            }
                        )
                    }
                }
                if(show){
                    DatePickerModal(
                        onDateSelected = {

                        },
                        onDismiss = {

                        }
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Box(
                    modifier = Modifier.fillMaxWidth().background(Color.White),

                    ){
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        RequiredText("DESCRIPTION")
                        Spacer(modifier = Modifier.height(10.dp))
                        CustomTextField(
                            value = "Electricity bill",
                            trailingIcon = {

                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier.fillMaxWidth().background(Color.White),
                    ){

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Total Amount",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black
                        )
                        AmountTextField(
                            isEnteringAmount = false
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))



                Spacer(modifier = Modifier.weight(1f))

                Box(
                    modifier = Modifier.fillMaxWidth().background(Color.White),
                ){
                    Button(
                        onClick = { /* Save action */ },
                        modifier = Modifier
                            .fillMaxWidth().padding(10.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors().copy(
                            containerColor = ColorPrimary
                        )
                        ) {
                        Text(
                            modifier = Modifier.padding(vertical = 8.dp),
                            text = "Save",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

            }
        }
    )
}

@Composable
fun ToggleButton(selected: Boolean, onSelect: () -> Unit, text: String) {
    val backgroundColor = if (selected) Color.Black else Color.White
    val contentColor = if (selected) Color.White else Color.Black

    Button(
        onClick = onSelect,

        shape = RoundedCornerShape(50),
    ) {
        Text(text = text, fontSize = 14.sp, fontWeight = FontWeight.Medium)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecordExpenseScreen() {
    RecordExpenseScreen()
}
