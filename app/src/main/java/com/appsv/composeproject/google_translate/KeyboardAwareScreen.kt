import android.util.Log
import android.view.ViewTreeObserver
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.appsv.composeproject.R
import com.appsv.composeproject.google_translate.LanguageSwitcherRow
import com.appsv.composeproject.google_translate.rememberImeState


@Composable
fun KeyboardAwareScreen(
    onTranslatedText : () -> Unit,
    onEnteringInputText : (Boolean) -> Unit
) {
    var inputText by remember { mutableStateOf("") }

    val isInputTextEmpty by remember {
        derivedStateOf {
            inputText.isEmpty()
        }
    }
    LaunchedEffect(isInputTextEmpty) {
        onEnteringInputText(isInputTextEmpty)
    }
    val isKeyboardOpen by rememberImeState()
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    LaunchedEffect(isKeyboardOpen) {
        Log.d("IMEKEYBOARD", "Keyboard Open: $isKeyboardOpen")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp)
                    .clip(RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp))
                    .background(Color.Black)
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            ) {



                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(1f)
                ) {
                    // Text Input Field
                    OutlinedTextField(
                        value = inputText,
                        onValueChange = { inputText = it },
                        placeholder = {
                            Text(
                                text = "Enter text",
                                modifier = Modifier.padding(0.dp), // Remove padding
                                style = TextStyle(
                                    fontSize = 37.sp,
                                    color = Color.White
                                )
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .focusRequester(focusRequester),
                        textStyle = TextStyle(color = Color.White, fontSize = 37.sp), // Adjusted text size
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(onNext = {
                            onTranslatedText()
                        }),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            cursorColor = Color.Blue,
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                        ),
                    )

                    Spacer(modifier = Modifier.height(50.dp))

                    if(inputText.isEmpty()){
                        Button(
                            onClick = { },
                            modifier = Modifier.align(Alignment.Start),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                            shape = RoundedCornerShape(20.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_content_paste_24),
                                contentDescription = "Paste",
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = "Paste", color = Color.White)
                        }
                    }
                    else{
                        Row(
                            modifier = Modifier
                                .fillMaxWidth().padding(bottom = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .height(5.dp)
                                    .width(150.dp )
                                    .clip(CircleShape)
                                    .background(Color.Blue)
                            )
                        }
                        Spacer(modifier = Modifier.height(30.dp))
                        Text(
                            modifier = Modifier.weight(0.8f),
                            text = inputText,
                            style = TextStyle(
                                fontSize = 37.sp,
                                color = Color.White
                            ),
                        )
                    }




                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ){
                LanguageSwitcherRow(
                    leftButtonText = "English",
                    rightButtonText = "Hindi",
                    onLeftButtonClick = {}
                ) { }
            }

        }

    }
    
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewKeyboardAwareScreen() {
    KeyboardAwareScreen(
        onTranslatedText = {}
    ){}
}