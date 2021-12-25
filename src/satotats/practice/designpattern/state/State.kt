package satotats.practice.designpattern.state

import kotlin.random.Random

object Sunny : Weather {
    override fun clock(ctx: Planet, num: Int) {
        when {
            num % 3 == 0 -> ctx.weatherChange(Cloudy)
            num % 7 == 0 -> ctx.weatherChange(Rainy)
            else -> {}/* no-op */
        }
    }

    override fun temperatureChange(ctx: Planet) {
        ctx.updateTemperature(+1)
    }

    override fun humidityChange(ctx: Planet) {
        ctx.updateHumidity(-10)
    }
}

object Rainy : Weather {
    override fun clock(ctx: Planet, num: Int) {
        when {
            num % 3 == 0 -> ctx.weatherChange(Cloudy)
            num % 5 == 0 -> ctx.weatherChange(Sunny)
            else -> {}/* no-op */
        }
    }

    override fun temperatureChange(ctx: Planet) {
        ctx.updateTemperature(-1)
    }

    override fun humidityChange(ctx: Planet) {
        ctx.updateHumidity(+20)
    }
}

object Cloudy : Weather {
    override fun clock(ctx: Planet, num: Int) {
        when {
            num % 2 == 0 -> ctx.weatherChange(Sunny)
            num % 3 == 0 -> ctx.weatherChange(Rainy)
            else -> {}/* no-op */
        }
    }

    override fun temperatureChange(ctx: Planet) {
        ctx.updateTemperature(+-0)
    }

    override fun humidityChange(ctx: Planet) {
        ctx.updateTemperature(+10)
    }
}

sealed interface Weather {
    fun clock(ctx: Planet, num: Int)
    fun temperatureChange(ctx: Planet)
    fun humidityChange(ctx: Planet)
}


interface Planet {
    fun clock()
    fun weatherChange(newWeather: Weather)
    fun updateTemperature(diffsInC: Int)
    fun updateHumidity(diffsInPercentage: Int)
}


/**
 *  @param temperature in Ceisius
 *  @param humidity in %
 * */
class PlanetEarth(
    private val planetSecret: Random = Random.Default,
    private var weather: Weather = Sunny,
    private var temperature: Int = 20,
    private var humidity: Int = 40,
) : Planet {

    override fun clock() {
        val randomNumber = planetSecret.nextInt()
        weather.clock(this, randomNumber)
        weather.temperatureChange(this)
        weather.humidityChange(this)
        println("weather=$weather, temperature=$temperature, humidity=$humidity")
    }

    override fun weatherChange(newWeather: Weather) {
        this.weather = newWeather
    }

    override fun updateTemperature(diffsInC: Int) {
        temperature += diffsInC
    }

    override fun updateHumidity(diffsInPercentage: Int) {
        humidity += diffsInPercentage
    }
}

fun main() {
    val earth = PlanetEarth()
    for (n in 1..100) {
        println("day $n")
        earth.clock()
    }
}