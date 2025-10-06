import com.google.gson.annotations.SerializedName

data class RoutinesResponse(
    val rutinas: List<RutinaDto> = emptyList(),
    val ejercicios: List<EjercicioDto> = emptyList()
)

data class RutinaDto(
    val id: Int,
    val nombre: String? = null,
    val descripcion: String? = null,
    val musculo: String? = null,
    val imagen: String? = null,
    val duracion: String? = null
)

data class EjercicioDto(
    val id: Int,
    val nombre: String? = null,
    val repeticiones: String? = null,
    val categoria: String? = null
)