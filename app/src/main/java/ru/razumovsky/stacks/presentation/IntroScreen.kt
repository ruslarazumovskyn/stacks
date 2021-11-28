package ru.razumovsky.stacks.presentation

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import ru.razumovsky.stacks.R
import ru.razumovsky.stacks.ui.theme.StacksTheme

@Composable
fun IntroScreen(navController: NavController){
    StacksTheme() {
        val subtitle = buildAnnotatedString {
            append("This is a project for beginner android enginners.This app use modern stack list,you can learn basic of android development using this app and his source ")
            withStyle(style = SpanStyle(MaterialTheme.colors.primary)){
                append("code.")
            }

        }
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(
            R.raw.question))
        val progress by animateLottieCompositionAsState(composition = composition)
            Box(modifier = Modifier.fillMaxSize()) {
                Spacer(modifier = Modifier.height(100.dp))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    LottieAnimation(composition, progress, modifier = Modifier.size(200.dp))
                    Text(
                        text = "Hi! This is Stacks",
                        fontFamily = FontFamily.SansSerif,
                        color = MaterialTheme.colors.secondary,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = subtitle,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Gray,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp, end = 10.dp)
                    )

                    Spacer(modifier = Modifier.height(250.dp))
                    Button(onClick = { navController.navigate("home") }, shape = RoundedCornerShape(16.dp), colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary, contentColor = MaterialTheme.colors.secondary), modifier = Modifier.height(60.dp)){
                        Text(text = "Ok", letterSpacing = 0.sp, fontSize = 16.sp)

                    }

                }
            }
    }
}