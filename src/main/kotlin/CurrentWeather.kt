import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeather(
    val count: Int,
    val data: List<WeatherInfo>,
//    val minutely: List<String>?
)
