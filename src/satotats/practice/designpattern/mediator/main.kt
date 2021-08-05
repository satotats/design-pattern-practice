package satotats.practice.designpattern.mediator

fun main() {
    val clock = Clock()
    repeat(86400) {
        clock.clock()
        clock.printTime()
    }
}