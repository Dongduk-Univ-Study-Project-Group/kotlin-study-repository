package chap05.section04

fun main() {
    val a = 6
    val b = 0
    val c: Int

    // 여기 있으면 예외를 잡지 못한다.
//    c = a / b
//    println("After")

    try {
        c = a / b
        println("After")   // 위 구문에서 예외가 발생했기 때문에 해당 구문은 실행되지 않음
    } catch (e: Exception) {
        println("Exception")
    } finally {
        println("Finally")
    }
}