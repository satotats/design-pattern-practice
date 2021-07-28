package satotats.practice.designpattern.facade

object SushiStaffingAgency {
    fun offerMaster() = SushiMaster(arrayOf("Tai", "Kanpachi", "Aji", "Tuna"))
    fun offerApprentice() = Apprentice()
}
