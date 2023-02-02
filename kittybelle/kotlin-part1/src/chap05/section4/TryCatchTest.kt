package chap05.section4

fun main() {
    val a = 6
    val b = 0
    val c : Int

    try {
        c = a / b // 0으로 나눔
        println("After")
    } catch (e : Exception) {
        println("Exception is handled.") // 예외 발생 시 출력
    } finally {
        println("finally 블록은 반드시 항상 실행됨") // 예외 발생 여부와 관계없이 항상 출력
    }
}