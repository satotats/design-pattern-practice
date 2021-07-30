package satotats.practice.designpattern.facade

class SushiRestrant(
    private val master: SushiMaster = SushiStaffingAgency.offerMaster(),
    private val apprentice: Apprentice = SushiStaffingAgency.offerApprentice()
) {

    fun open() {
        apprentice.open()
        apprentice.cleanRoom()
        println()
    }

    fun serve() {
        master.makeSushi();
        master.call();
        println()
    }

    fun close() {
        apprentice.washDish()
        apprentice.cleanRoom()
        apprentice.close()
    }
}

class SushiMaster(
    private val fishCought: Array<String>) {

    private fun makeSashimi(fish: String): String {
        return "$fish sashimi"
    }

    private fun formRiceBall() {
        println("""
            The master's brilliant handwork!!!
            A pretty rice ball was created...
        """.trimIndent())
    }

    fun makeSushi() {
        for (fish in fishCought) {
            val sashimi = makeSashimi(fish)
            formRiceBall()
            println("$sashimi & rice ball -> $fish sushi!!!!")
            println()
        }
    }

    fun call() {
        println("HEY OMACHI!")
    }
}


class Apprentice() {

    fun open() {
        println("Open the restaurant key...")
    }

    fun cleanRoom() {
        println("Wipe the tables and other equipments...")
    }

    fun washDish() {
        println("Wash the dishes remaining")
    }

    fun close() {
        println("close the restaurant key...")
    }
}