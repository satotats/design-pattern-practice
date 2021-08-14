package satotats.practice.designpattern.mement

import kotlin.math.abs
import kotlin.random.Random

interface Memento
interface Originator

class Trader(
    var cash: Int = 1000000,
    var stock: Int = 0,
    val seed: Int = 9999
) : Originator {

    val random = Random(seed)
    fun superIntelligentDecision(price: Int): Int {
        val buy = when {
            stock == 0 -> true
            price > cash -> false
            else -> random.nextBoolean()
        }

        return when (buy) {
            true -> random.nextInt(cash / price) + 1
            false -> -(random.nextInt(if (stock > 0) stock else 1) + 1)
        }
    }


    fun buy(price: Int, amount: Int) {
        cash -= price * amount
        stock += amount
    }

    fun sell(price: Int, amount: Int) {
        cash += price * amount
        stock -= amount
    }

    fun createSnapShot(day: Int, stockPrice: Int): AssetSnapShot = AssetSnapShot(day, cash, stock, stockPrice)

    fun restoreSnapShot(snapShot: AssetSnapShot) {
        cash = snapShot.cash
        stock = snapShot.stock
    }
}

class AssetSnapShot(
    val day: Int,
    val cash: Int,
    val stock: Int,
    val stockPrice: Int
) : Memento {
    val totalAsset: Int
        get() = cash + stock * stockPrice
}

class StockMarket(val seed: Int = 999) {
    private val random: Random = Random(seed)

    var currentPrice: Int = 1
        get() = random.nextInt(10000)
}

fun main() {

    val stockMarket = StockMarket(seed = 452)
    val wai = Trader(seed = 43)

    var price: Int = 0
    var totalAsset: Int
    var snapshot = wai.createSnapShot(1, price)

    var day = 1
    var timewarped = false
    while (true) {
        println()

        println("------ Day $day -------")

        println("天才トレーダー ワイ：『ほんで今日の価格はっと...』")

        price = if (!timewarped) stockMarket.currentPrice else (snapshot.stockPrice).also { timewarped = false }
        println("PC：『${price}円ニキ』")
        println("天才トレーダー ワイ：『ということは...今ワイの資産は』")

        totalAsset = wai.cash + wai.stock * price
        println("PC：『総額：${totalAsset}円ニキ』")
        println("PC：『内訳は 現金${wai.cash}円、${wai.stock}株(${wai.stock * price}円)ニキ』")
        println()
        println("天才トレーダー ワイ：『ほおん』")

        if (totalAsset < snapshot.totalAsset / 2) {
            println("天才トレーダー ワイ：『なんか』")
            println("天才トレーダー ワイ：『えらい少ななったな』")
            println("天才トレーダー ワイ：『なんか${day - snapshot.day}日前あたり景気よかった気ぃする』")
            println("天才トレーダー ワイ：『タイムスリップしとこ』")

            println()
            println("～～～ここで時空が歪む～～～")
            println()
            wai.restoreSnapShot(snapshot)
            day = snapshot.day
            timewarped = true
            continue
        }

        if (snapshot.totalAsset < totalAsset) {
            println("天才トレーダー ワイ：『なんかめっちゃ多なってきたな』")
            println("(もぞもぞ)")
            snapshot = wai.createSnapShot(day, price)
        }


        println("天才トレーダー ワイ：『ほんで今日...どないしょ』")
        println("天才トレーダー ワイ：『...』")
        println()

        val stocksToDeal = wai.superIntelligentDecision(price)
        if (stocksToDeal > 0) {
            println("天才トレーダー ワイ：『\"買い\"やな』")
            wai.buy(price, stocksToDeal)
        } else {
            println("天才トレーダー ワイ：『\"売り\"やな』")
            wai.sell(price, abs(stocksToDeal))
        }
        println("天才トレーダー ワイ：『うっし、果報は寝て待て、や』")
        println("*** Day ${day} END ***")

        day++
        if (day > 10) break
    }

    println()
    println("*** Congratulations!!! ***")
    println()
    println("PC：『最終的な資産総額は ${totalAsset}円ニキ』")
    println("PC：『内訳は 現金${wai.cash}円、株${wai.stock}株(${wai.stock * price}円)ニキ』")
    println("PC：『おめっとさん』")
    println("～完～")
}