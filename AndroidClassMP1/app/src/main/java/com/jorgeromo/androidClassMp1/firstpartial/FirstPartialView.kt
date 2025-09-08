package com.jorgeromo.androidClassMp1.firstpartial

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jorgeromo.androidClassMp1.navigation.ScreenNavigation

@Composable
fun FirstPartialView(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text(
            text = "Primer Parcial Moviles I",
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            navController.navigate(ScreenNavigation.Login.route)
        }) {
            Text("Ir a Login")
        }
        Button(onClick = {
            navController.navigate(ScreenNavigation.Lottie.route)
        }) {
            Text("Ir a Lottie")
        }

    }
}
