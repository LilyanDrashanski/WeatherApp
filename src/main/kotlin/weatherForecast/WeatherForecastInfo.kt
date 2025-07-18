package weatherForecast

import kotlinx.serialization.Serializable

@Serializable
data class WeatherForecastInfo(
    val app_min_temp: Double,
    val app_max_temp: Double,
    val clouds: Int,
    val clouds_hi: Int,
    val clouds_low: Int,
    val clouds_mid: Int,
    val datetime: String,
    val dewpt: Double,
    val high_temp: Double,
    val low_temp: Double,
    val max_dhi: Int?,
    val max_temp: Double,
    val min_temp: Double,
    val moon_phase: Double,
    val moon_phase_lunation: Double,
    val moonrise_ts: Int,
    val moonset_ts: Int,
    val ozone: Int,
    val pop: Int,
    val precip: Double,
    val pres: Int,
    val rh: Int,
    val slp: Int,
    val snow: Int,
    val snow_depth: Int,
    val sunrise_ts: Int,
    val sunset_ts: Int,
    val temp: Double,
    val ts: Int,
    val uv: Int,
    val valid_date: String,
    val vis: Double,
    val weather: Weather,
    val wind_cdir: String,
    val wind_cdir_full: String,
    val wind_dir: Int,
    val wind_gust_spd: Double,
    val wind_spd: Double
)

