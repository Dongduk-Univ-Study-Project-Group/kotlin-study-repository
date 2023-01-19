package chap02.section04

fun main() {
    val x = 4    // 십진표기법(10) - 0100(2)
    val y = 0b0000_1010   // 이진표기법(2) - 5(10)
    val z = 0x0f    // 16진표기법 - 0b0000_1111(2) - 15(10)

    println("x shl 2 -> ${x.shl(2)}")   // 0100 -> 0001_0000(2), 16(10)
    println("x inv -> ${x.inv()}")   // 0100 -> 1011
}