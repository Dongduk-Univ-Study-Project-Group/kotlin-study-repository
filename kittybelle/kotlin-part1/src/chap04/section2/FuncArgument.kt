package chap04.section2

fun sum(a: Int, b: Int) = a + b

fun mul(a: Int, b: Int): Int {
    return a * b
}

fun funcFunc(a: Int, b: Int): Int {
    return sum(a, b) // 함수의 반환 형태에도 함수 사용 가능
}

// fun funcFunc(a: Int, b: Int): Int = sum(a, b)

fun main() {
    val result = sum(10, 10)
    val result2 = mul(sum(10, 5), 10) // 함수 자체가 인자로 들어감
    val result3 = funcFunc(2, 3)

    println("result: $result, result2: $result2")
}