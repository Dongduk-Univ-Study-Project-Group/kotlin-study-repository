package chap04.section02

fun sum(a: Int, b: Int) = a + b


fun mul(a: Int, b: Int): Int {
    return a * b
}

fun funFunc(a: Int, b: Int): Int {
    return sum(a, b)    // 2. 함수를 반환 형태로 사용한 경우
}

fun main() {
    val result = sum(10, 10)
    val result2 = mul(sum(10, 5), 10)    // 1. 함수를 인자로 사용한 경우
    val result3 = funFunc(2, 3)

    println("result: $result, result2: $result2, result3: $result3")
}