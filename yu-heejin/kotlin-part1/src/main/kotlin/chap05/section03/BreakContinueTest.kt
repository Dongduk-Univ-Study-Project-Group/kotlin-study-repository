package chap05.section03

fun main() {
    labelBreak()
}

fun labelBreak() {
    println("labelBreak")
    first@ for (i in 1..5) {
        second@ for (j in 1..5) {
            if (j == 3) continue@first
            println("i: $i, j: $j")
        }
        println("after for j")
    }
    println("after for i")
}