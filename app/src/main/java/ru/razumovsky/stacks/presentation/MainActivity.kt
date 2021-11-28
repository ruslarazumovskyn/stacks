package ru.razumovsky.stacks.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import ru.razumovsky.stacks.ui.theme.StacksTheme

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StacksTheme {
                Navigation()
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun Navigation(){
    StacksTheme() {
        val navController = rememberAnimatedNavController()
        AnimatedNavHost(navController = navController, startDestination = "intro"){
            composable("intro", enterTransition = { slideIntoContainer(AnimatedContentScope.SlideDirection.Start,
                tween(300))}){ IntroScreen(navController = navController)}
            composable("home", enterTransition = { slideIntoContainer(AnimatedContentScope.SlideDirection.Start,
                tween(300))}){ HomeScreen(navController = navController) }
        }
    }
}