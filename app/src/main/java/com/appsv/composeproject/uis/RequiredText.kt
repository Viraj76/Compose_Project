import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun RequiredText(
    text : String
) {
    Row {
        Text(
            text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF333366), // Replace with the desired color for the label
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.width(2.dp)) // Adjust spacing between "DATE" and "*"
        Text(
            text = "*",
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Red, // Red color for the asterisk
            textAlign = TextAlign.Start
        )
    }
}

