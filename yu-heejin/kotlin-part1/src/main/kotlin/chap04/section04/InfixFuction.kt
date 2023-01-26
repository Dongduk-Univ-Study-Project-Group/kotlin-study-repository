package chap04.section04

fun main() {
    val num = 3
    // val str = num.strPlus("kotlin")
    val str = num strPlus "Kotlin"    // 중위 표현법

    println(str)
}

infix fun Int.strPlus(x: String): String {
    return "$x version $this"
}