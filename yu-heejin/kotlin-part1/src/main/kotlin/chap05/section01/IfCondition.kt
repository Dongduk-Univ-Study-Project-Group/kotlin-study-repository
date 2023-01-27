package chap05.section01

fun main() {
    val a = 17
    val b = 7

    val max = if (a > b) {
        println("a: $a")
        a
    } else {
        println("b: $b")
        b
    }

    println(max)
}