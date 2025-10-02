package com.jorgeromo.androidClassMp1.secondpartial.home.model.dto

import EjercicioDto
import RutinaDto


data class RoutinesResponse(
    val rutinas: List<RutinaDto> = emptyList(),
    val ejercicios: List<EjercicioDto> = emptyList()
)
