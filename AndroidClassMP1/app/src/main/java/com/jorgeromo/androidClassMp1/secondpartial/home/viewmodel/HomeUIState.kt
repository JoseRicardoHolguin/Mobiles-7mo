package com.jorgeromo.androidClassMp1.secondpartial.home.viewmodel

import EjercicioDto
import RutinaDto

data class HomeUiState(
    val rutinas: List<RutinaDto> = emptyList(),
    val ejercicios: List<EjercicioDto> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)