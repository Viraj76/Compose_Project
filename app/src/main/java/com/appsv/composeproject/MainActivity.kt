package com.appsv.composeproject

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.appsv.composeproject.google_sign_in.GoogleAuthenticator
import com.appsv.composeproject.google_sign_in.SignInScreen
import com.appsv.composeproject.google_translate.AutomatedGoogleSignIn
import com.appsv.composeproject.google_translate.EmailAccountsScreenn
import com.appsv.composeproject.google_translate.navigation.SetUpNavigation
import com.appsv.composeproject.scoring.data.room.Ball
import com.appsv.composeproject.scoring.data.room.BallDao
import com.appsv.composeproject.scoring.presentation.BallByBallUI
import com.appsv.composeproject.ui.theme.ComposeProjectTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                Color.Black.toArgb()
            )
        )
        setContent {
            ComposeProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->


//
//                    LaunchedEffect(Unit) {
//
//                        val database = CricketDatabase.getDatabase(applicationContext)
//
//
//                        val ballDao = database.ballDao()
//                        addBallsToDatabase(ballDao,this)
//
//                    }

//                    SetUpNavigation()
//                    EmailAccountsScreenn()
//                    val context = LocalContext.current
//                    CustomGoogleSignInPicker(context)
//                    val context = LocalContext.current
//
//                    AutomatedGoogleSignIn(context = context) { selectedEmail ->
//                        Log.d("SelectedEmail", "Selected Account Email: $selectedEmail")
//                    }
                    val scope = rememberCoroutineScope()
                    SignInScreen(){

                        val googleAuthenticator = GoogleAuthenticator(this)
                        scope.launch  {
                            googleAuthenticator.authenticate().collect{credential->
                                if (credential != null) {
                                    Log.d("Detailsss" , credential.id)
                                } else {
                                }
                            }}
                    }


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeProjectTheme {
//        Greeting("Android")

    }
}

@Composable
fun BallByBallUIPreview() {
    val mockBalls = listOf(
        Ball(
            matchId = 1,
            innings = 1,
            overNumber = 1,
            ballNumber = 1,
            bowlerId = 2,
            batsmanId = 3,
            nonStrikerId = 4,
            runsScored = 4,
            extrasType = null,
            isWicket = false,
            wicketType = "catch"
        ),
        Ball(
            matchId = 1,
            innings = 1,
            overNumber = 1,
            ballNumber = 2,
            bowlerId = 2,
            batsmanId = 3,
            nonStrikerId = 4,
            runsScored = 0,
            extrasType = "wide",
            isWicket = false,
            wicketType = "bowled"
        ),
        Ball(
            matchId = 1,
            innings = 1,
            overNumber = 1,
            ballNumber = 3,
            bowlerId = 2,
            batsmanId = 3,
            nonStrikerId = 4,
            runsScored = 1,
            extrasType = null,
            isWicket = true,
            wicketType = "bowled"
        )
    )
    BallByBallUI(
        balls = mockBalls,
        onAddBallClicked = { /* Add Ball Logic */ }
    )
}


fun addBallsToDatabase(ballDao: BallDao, coroutineScope: CoroutineScope) {
    for (i in 1..1000) {
        // Calculate over and ball number within the over
        val overNumber = (i - 1) / 6 + 1
        val ballNumber = (i - 1) % 6 + 1

        // Generate random IDs for players
        val bowlerId = (1..11).random()
        val batsmanId = (1..11).random()
        var nonStrikerId = (1..11).random()

        // Ensure batsman and non-striker are not the same
        while (batsmanId == nonStrikerId) {
            nonStrikerId = (1..11).random()
        }

        // Randomize runs, extras, and wicket status
        val runsScored = (0..6).random()
        val isWicket = (0..10).random() == 0 // 1 in 10 chance of a wicket
        val extrasType = if (runsScored == 0 && !isWicket) "Wide" else null
        val wicketType = if (isWicket) "catch" else null

        // Create Ball instance
        val ball = Ball(
            matchId = 1,
            innings = 1,
            overNumber = overNumber,
            ballNumber = ballNumber,
            bowlerId = bowlerId,
            batsmanId = batsmanId,
            nonStrikerId = nonStrikerId,
            runsScored = runsScored,
            extrasType = extrasType,
            isWicket = isWicket,
            wicketType = wicketType
        )

        coroutineScope.launch {
            ballDao.insertBall(ball)
        }
    }

}






