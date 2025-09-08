package com.jorgeromo.androidClassMp1.firstpartial.lottieanimation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.LottieConstants
import com.jorgeromo.androidClassMp1.R


@Composable
fun LottieAnimationView() {
    // Cargar el archivo JSON desde res/raw
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.animacion)
    )

    // Controlar la animación (ejemplo: loop infinito)
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )

    // Mostrar animación
    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Fit
    )
}

