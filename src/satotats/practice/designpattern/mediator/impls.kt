package satotats.practice.designpattern.mediator

abstract class ClockHand(
    override val mediator: Mediator,
    val maxDigit: Int = 60
    ): Colleague(mediator) {

    var digit: Int = 0

    fun clock(): Unit {
        incrementDigit()

        if (isOver()) {
            resetDigit()
            mediator.colleagueChanged(this)
        }
    }

    private fun incrementDigit(): Unit {
        digit++
    }

    private fun resetDigit(): Unit {
        digit = 0
    }

    private fun isOver(): Boolean = digit >= maxDigit
}


class LongClockHand(override val mediator: Mediator):
    ClockHand(mediator = mediator, maxDigit = 24) {
    override fun controlColleague() {
        clock()
    }
}

class ShortClockHand(override val mediator: Mediator): ClockHand(mediator) {
    override fun controlColleague() {
        clock()
    }
}

class SecClockHand(override val mediator: Mediator): ClockHand(mediator) {
    override fun controlColleague() {
        clock()
    }
}

class Clock: Mediator {
    private val longClockHand: LongClockHand
    private val shortClockHand: ShortClockHand
    private val secClockHand: SecClockHand

    init {
        longClockHand = LongClockHand(this)
        shortClockHand=  ShortClockHand(this)
        secClockHand = SecClockHand(this)
    }

    override fun colleagueChanged(changed: Colleague) {
        when (changed) {
            is SecClockHand -> shortClockHand.controlColleague()
            is ShortClockHand -> longClockHand.controlColleague()
            is LongClockHand -> println("A day is gone...")
        }
    }

    fun clock() = secClockHand.controlColleague()

    fun printTime() = println("${longClockHand.digit}時${shortClockHand.digit}分${secClockHand.digit}秒 です。")
}