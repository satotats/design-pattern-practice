package satotats.practice.designpattern.facade

fun main() {
    val sr = SushiRestrant()
    sr.open()
    sr.serve()
    sr.close()
}
