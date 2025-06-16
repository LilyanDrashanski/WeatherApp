import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*

suspend fun main() {
    val client = HttpClient(CIO)

    println("Enter the city for which you want to check the weather!")

    val city = readln()

    val response : CurrentWeather = client.get("https://api.weatherbit.io/v2.0/current?key=81993ff8c6c141348d022cd2e317209a&city=$city").body()

    println(response)

}
