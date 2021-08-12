package satotats.practice.designpattern.mediator

interface Mediator {
    fun colleagueChanged(changed: Colleague): Unit
}

abstract class Colleague(open val mediator: Mediator) {
    abstract fun controlColleague(): Unit
}
