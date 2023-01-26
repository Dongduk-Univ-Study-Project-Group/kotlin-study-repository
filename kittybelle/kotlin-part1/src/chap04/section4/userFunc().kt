package chap04.section4

var global = 10

fun main() {
    global = 15
    val local1 = 15
    println("global $global") // global 15
    userFunc() // 여기서 global이 20으로 바뀌어서
    println("final - global $global, local1: $local1") // 전역변수이므로 global 20, 지역변수이므로 local1 15
    println()
}

fun userFunc() {
    global = 20
    val local1 = 20
    println("userFunc - global: $global, local1: $local1") // 20 출력
}