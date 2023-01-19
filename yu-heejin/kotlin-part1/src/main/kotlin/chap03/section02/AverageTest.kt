package chap03.section02

fun avgFunc(initial: Float = 0f, vararg numbers: Float): Double {
    // 초기값은 왜 넣은걸까./.?
    var result = 0f

    for (num in numbers) {
        result += num
    }

    println("result: $result, numbers.size: ${numbers.size}")

    val avg = (result + initial) / numbers.size

    return avg.toDouble()
}

fun main() {
    val result = avgFunc(5f, 100f, 90f, 80f)
    println("avg result: $result")
}