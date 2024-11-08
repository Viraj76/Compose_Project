package com.appsv.composeproject

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.appsv.composeproject.cricket.CricketRankings
import com.appsv.composeproject.retrofit.retrofit
import com.appsv.composeproject.ui.theme.ComposeProjectTheme
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

//
//                    val apiToken = "I7xPMj3ufiPJduZIhA9RDaf6711OXD4tML2Jrc2ZFDuiwD4y7MG1vGF7olBI"
//                    val type = "TEST"
//                    val gender = "men"
//                    val call = apiService.getTeamRankings(type, gender, apiToken)

//                    LaunchedEffect(Unit) {
//
//                        for (i in call.body()?.data!!){
//                            Log.d("GGHJD", i.team.size.toString())
//
//                            i.team.forEach {
//                                Log.d("GGHJD", it.toString())
//                            }
//                        }
//
//                    }
                    Retrofit.Builder()
                        .baseUrl("https://cricket.sportmonks.com/api/v2.0/")  // Base URL of the API
                        .addConverterFactory(GsonConverterFactory.create())   // Use Gson to parse JSON
                        .build()

//                    call.enqueue(object : Callback<CricketRankings> {
//                        override fun onResponse(call: Call<CricketRankings>, response: Response<CricketRankings>) {
//                            if (response.isSuccessful) {
//                                val rankings = response.body()?.data  // Access the list of rankings
//                                println(rankings?.size)
//                                rankings?.forEach {
//                                    println("Team: ${it.team}, Rank: ${it.rating}, Points: ${it.points}")
//                                }
//                            } else {
//                                println("Request failed with status code: ${response.code()}")
//                            }
//                        }
//
//                        override fun onFailure(call: Call<CricketRankings>, t: Throwable) {
//                            println("API call failed: ${t.message}")
//                        }
//                    })

                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
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
        Greeting("Android")
    }
}