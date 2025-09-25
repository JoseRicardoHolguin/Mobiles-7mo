package com.jorgeromo.androidClassMp1.navigation

import LoginView
import SecondPartialView
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import com.jorgeromo.androidClassMp1.firstpartial.FirstPartialView
import com.jorgeromo.androidClassMp1.ids.imc.views.IMCView
import com.jorgeromo.androidClassMp1.ids.location.views.LocationListScreen
import com.jorgeromo.androidClassMp1.ids.student.views.StudentView
import com.jorgeromo.androidClassMp1.ids.sum.views.SumView
import com.jorgeromo.androidClassMp1.ids.temperature.views.TempView
import com.jorgeromo.androidClassMp1.thirdpartial.ThirdPartialView
import androidx.compose.ui.graphics.Color
import com.jorgeromo.androidClassMp1.firstpartial.lottieanimation.LottieAnimationView
import com.jorgeromo.androidClassMp1.ids.IdsView
import com.jorgeromo.androidClassMp1.secondpartial.home.HomeView
import com.jorgeromo.androidClassMp1.secondpartial.qrcode.QrCodeView


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabBarNavigationView(navController: NavHostController = rememberNavController()) {
    val items = listOf(
        ScreenNavigation.Ids,
        ScreenNavigation.FirstPartial,
        ScreenNavigation.SecondPartial,
        ScreenNavigation.ThirdPartial
    )

    // Mapa de títulos por ruta (incluye tabs y pantallas internas)
    val routeTitles = remember {
        mapOf(
            ScreenNavigation.FirstPartial.route to ScreenNavigation.FirstPartial.label,
            ScreenNavigation.SecondPartial.route to ScreenNavigation.SecondPartial.label,
            ScreenNavigation.ThirdPartial.route to ScreenNavigation.ThirdPartial.label,

            // Rutas internas (ajusta a tus strings preferidos)
            ScreenNavigation.IMC.route to "IMC",
            ScreenNavigation.Login.route to "Login",
            ScreenNavigation.Sum.route to "Suma",
            ScreenNavigation.Temperature.route to "Temperatura",
            ScreenNavigation.StudentList.route to "Estudiantes",
            ScreenNavigation.Locations.route to "Ubicaciones",
            ScreenNavigation.Home.route to "Home"
        )
    }

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    // Si usas nested graphs, puedes leer la jerarquía; aquí basta con la route actual:
    val currentRoute = navBackStackEntry?.destination?.route
    val currentTitle = routeTitles[currentRoute] ?: ""

    Scaffold(
        topBar = {
            // Puedes usar SmallTopAppBar o CenterAlignedTopAppBar
            CenterAlignedTopAppBar(
                title = { Text(text = "Android Jose Holguin 13375") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFF4A148C), // Azul
                titleContentColor = Color.White
            )
            )
        },
        bottomBar = {
            if (currentRoute in listOf(
                    ScreenNavigation.Ids.route,
                    ScreenNavigation.FirstPartial.route,
                    ScreenNavigation.SecondPartial.route,
                    ScreenNavigation.ThirdPartial.route
                )
            ) {
                NavigationBar {
                    items.forEach { screen ->
                        val selected = currentRoute == screen.route
                        NavigationBarItem(
                            icon = { Icon(screen.icon, contentDescription = screen.label) },
                            label = { Text(screen.label) },
                            selected = selected,
                            onClick = {
                                if (!selected) {
                                    navController.navigate(screen.route) {
                                        popUpTo(navController.graph.startDestinationId) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ScreenNavigation.Ids.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(ScreenNavigation.Home.route) { HomeView() }
            composable(ScreenNavigation.FirstPartial.route) { FirstPartialView(navController) }
            composable(ScreenNavigation.SecondPartial.route) { SecondPartialView(navController) }
            composable(ScreenNavigation.ThirdPartial.route) { ThirdPartialView(navController) }
            composable(ScreenNavigation.Ids.route) { IdsView(navController) }


            // Rutas internas
            composable(ScreenNavigation.IMC.route) { IMCView() }
            composable(ScreenNavigation.Login.route) { LoginView(navController) }
            composable(ScreenNavigation.Sum.route) { SumView() }
            composable(ScreenNavigation.Temperature.route) { TempView() }
            composable(ScreenNavigation.StudentList.route) { StudentView() }
            composable(ScreenNavigation.Locations.route) { LocationListScreen() }
            composable(ScreenNavigation.Lottie.route) {LottieAnimationView()}
            composable(ScreenNavigation.QrCode.route) { QrCodeView() }

        }
    }
}