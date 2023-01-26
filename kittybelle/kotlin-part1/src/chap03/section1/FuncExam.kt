package chap03.section1

fun avgFunc(initial: Float = 0f, vararg numbers: Float): Double {
    var result = 0f
    for (num in numbers) {
        result += num
    }
    println("result: $result, numbers.size: ${numbers.size}")
    // val avg = (result / numbers.size).toDouble() 이렇게 하면 밑줄 생김
    val avg = result / numbers.size
            return avg.toDouble()
}

fun main() {
    val result = avgFunc(5f, 100f, 90f, 80f)  // 첫번째 인자: 초기값, 이후 인자는 가변인자
    println("avg result: $result")
}