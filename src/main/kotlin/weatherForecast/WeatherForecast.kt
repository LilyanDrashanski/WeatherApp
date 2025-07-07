package weatherForecast

import kotlinx.serialization.Serializable

@Serializable
data class WeatherForecast(
    val city_name: String? = null,
    val country_code: String? = null,
    val data: List<WeatherForecastInfo>? = null,
    val lat: String? = null,
    val lon: String? = null,
    val state_code: String? = null,
    val timezone: String? = null,
    val error: String? = null
)
