package com.appsv.composeproject.cricket_scoring.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Preview
@Composable
fun CricketScoringScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF003366)) // Dark Blue Background
            .padding(16.dp)
    ) {
        HeaderSection()
        Spacer(modifier = Modifier.height(8.dp))
        ScoreSection()
        Spacer(modifier = Modifier.height(8.dp))
        PlayerStatsSection()
        Spacer(modifier = Modifier.height(16.dp))
        OverSection()
        Spacer(modifier = Modifier.height(16.dp))
        ExtrasSection()
        Spacer(modifier = Modifier.height(8.dp))
        ActionButtonsSection()
    }
}


@Preview
@Composable
fun HeaderSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Team A vs Team B",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Text(
            text = "CRR: 0.00",
            color = Color.White,
            fontSize = 16.sp
        )
    }
}

@Composable
fun ScoreSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF0055AA), RoundedCornerShape(10.dp))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Score",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Text(
                text = "0 - 0 (0.0)",
                color = Color.White,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun PlayerStatsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(10.dp))
            .padding(8.dp)
    ) {
        PlayerStatRow("Batsman 1", 0, 0, 0, 0, 0.0)
        PlayerStatRow("Batsman 2", 0, 0, 0, 0, 0.0)
        PlayerStatRow("Bowler", 0, 0, 0, 0, 0.0)
    }
}

@Composable
fun PlayerStatRow(name: String, runs: Int, balls: Int, fours: Int, sixes: Int, sr: Double) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = name, modifier = Modifier.weight(1f))
        Text(text = "$runs")
        Text(text = "$balls")
        Text(text = "$fours")
        Text(text = "$sixes")
        Text(text = String.format("%.2f", sr))
    }
}

@Composable
fun OverSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray, RoundedCornerShape(10.dp))
            .padding(8.dp)
    ) {
        Text(
            text = "This Over:",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}

@Composable
fun ExtrasSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFAAE8FF), RoundedCornerShape(10.dp))
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ExtraButton("Wide")
        ExtraButton("No Ball")
        ExtraButton("Bye")
        ExtraButton("Leg Bye")
        ExtraButton("Wicket")
    }
}

@Composable
fun ExtraButton(label: String) {
    Button(
        onClick = { /* Handle extra */ },
        modifier = Modifier.padding(horizontal = 4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0066CC))
    ) {
        Text(label, color = Color.White, fontSize = 12.sp)
    }
}

@Composable
fun ActionButtonsSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ScoreButton("0")
        ScoreButton("1")
        ScoreButton("2")
        ScoreButton("3")
        ScoreButton("4")
        ScoreButton("5")
        ScoreButton("6")
        ScoreButton("...")
    }
}

@Composable
fun ScoreButton(label: String) {
    Button(
        onClick = { /* Handle score */ },
        modifier = Modifier
            .size(60.dp),
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
    ) {
        Text(label, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}
