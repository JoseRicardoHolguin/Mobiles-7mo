import com.google.gson.annotations.SerializedName

data class RutinaDto(
    val id: Int = 0,
    val nombre: String = "",
    val descripcion: String = "",
    val musculo: String = "",
    val imagen: String = "",
    val duracion: String = ""
)

data class EjercicioDto(
    val id: Int = 0,
    val nombre: String = "",
    val repeticiones: String = "",
    @SerializedName("categoria") val categoria: String = ""
)

