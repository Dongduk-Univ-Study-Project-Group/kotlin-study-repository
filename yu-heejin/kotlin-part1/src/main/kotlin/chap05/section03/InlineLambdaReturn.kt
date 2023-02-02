package chap05.section03

fun main() {
    retFunc()
}

inline fun inlineLambda(a: Int, b: Int, out: (Int, Int) -> Unit) {
    out(a, b)
}

fun retFunc() {
    println("start of retFunc")
    inlineLambda(3, 3) lit@{a, b ->
        val result = a + b
        if (result > 10) return@lit
        println("result: $result")
    }

    println("end of retFunc")
}