package chap04.section2

fun main() {
    var result: Int

    // 람다식을 매개변수와 인자로 사용한 함수
    result = highOrder({x, y -> x + y}, 10, 20)
    println(result)
}

// 크게 3개의 매개변수(sum, a, b)
// sum의 람다식은 x, y -> x + y
// sum(a, b)에 의해 a=10, b=20 값이 전해져서 30 출력
fun highOrder(sum: (Int, Int) -> Int, a: Int, b: Int): Int {
    return sum(a, b)
}