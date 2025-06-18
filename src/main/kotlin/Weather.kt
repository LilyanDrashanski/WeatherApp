import kotlinx.serialization.Serializable

@Serializable
data class Weather(
    val icon: String,
    val code: Int,
    val description: String,
)