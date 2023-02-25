
class Car {
    val wheel: Int = 4

    fun start() {
        println("Engine Start!")
    }
}

class Bird

fun main() {
    val sonata = Car() // 생성자

    println(sonata.wheel)
    sonata.start()
}