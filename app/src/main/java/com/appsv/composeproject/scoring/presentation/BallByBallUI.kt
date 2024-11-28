package com.appsv.composeproject.scoring.presentation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appsv.composeproject.scoring.data.room.Ball

@Composable
fun BallByBallUI(
    balls: List<Ball>, // List of ball details to display
    onAddBallClicked: () -> Unit // Action when "Add Ball" button is clicked
) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Match Header
        Text(
            text = "Match Summary",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // List of Balls
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(balls) { ball ->
                BallItem(ball = ball)
            }
        }

        // Add Ball Button
        Button(
            onClick = onAddBallClicked,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Add New Ball")
        }
    }
}

@Composable
fun BallItem(ball: Ball) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Over and Ball Number
            Text(
                text = "Over: ${ball.overNumber}.${ball.ballNumber}",
                style = MaterialTheme.typography.bodyMedium
            )

            // Runs and Wicket Info
            Text(
                text = if (ball.isWicket) "Wicket!" else "${ball.runsScored} runs",
                style = MaterialTheme.typography.bodySmall,
                color = if (ball.isWicket) Color.Red else Color.Green
            )
        }
    }
}
