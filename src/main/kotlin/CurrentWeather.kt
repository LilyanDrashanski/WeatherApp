import java.sql.Date

data class CurrentWeather(
    val temperature: Int, val weatherDescription: Double, val windSpeed: Double, val date: Date
)
