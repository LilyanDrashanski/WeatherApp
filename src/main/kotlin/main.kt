import weatherForecast.WeatherForecast
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

suspend fun main() {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    println("Enter the city for which you want to check the weather!")

    val city = readln()


    // URL for Weather API
    val url = "https://api.weatherbit.io/v2.0/forecast/daily?city=$city&key=81993ff8c6c141348d022cd2e317209a"

    val response = client.get(url)

//    try {

    when (response.status) {
        HttpStatusCode.OK -> {


            // Map response from Weather API to WeatherForecast
            val forecastResponse = response.body<WeatherForecast>()

            //Check for errors
            if (!forecastResponse.error.isNullOrEmpty()) {
                println("API error: ${forecastResponse.error}")
                return
            }

            // Print weather data for the next 4 days
            forecastResponse.data?.let { data ->
                println("Current: ${data[0].temp}, ${data[0].weather.description}, Wind: ${data[0].wind_spd}")
                println("Day 1: ${data[1].temp}, ${data[1].weather.description}")
                println("Day 2: ${data[2].temp}, ${data[2].weather.description}")
                println("Day 3: ${data[3].temp}, ${data[3].weather.description}")
            }
        }

        HttpStatusCode.TooManyRequests -> {
            println("You've made too many requests. Please wait and try again later.")
        }

    }
}
