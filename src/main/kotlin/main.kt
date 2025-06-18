import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.math.BigDecimal

suspend fun main() {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }

    println("Enter the city for which you want to check the weather!")

    val city = readln()

//    println(client.get("https://api.weatherbit.io/v2.0/current?key=81993ff8c6c141348d022cd2e317209a&city=$city"))

    val response: CurrentWeather = client.get("https://api.weatherbit.io/v2.0/current?key=81993ff8c6c141348d022cd2e317209a&city=$city").body<CurrentWeather>().apply {
        WeatherResponse(
            temperature = this.data[0].temp,
                    weatherDescription = this.data[0].weather.description,
                    windSpeed = this.data[0].wind_spd,
                    date = this.data[0].datetime,
        )
    }

    println(response)

}

object BigDecimalSerializer: KSerializer<BigDecimal> {
    override fun deserialize(decoder: Decoder): BigDecimal {
        return decoder.decodeString().toBigDecimal()
    }

    override fun serialize(encoder: Encoder, value: BigDecimal) {
        encoder.encodeString(value.toPlainString())
    }

    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor("BigDecimal", PrimitiveKind.STRING)
}
