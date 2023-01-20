package chap03.section03

fun highFunc(a: Int, b: Int, sum: (Int, Int) -> Int): Int {
    // () ->
    // 왼쪽에는 람다식에 넣을 매개변수, 오른쪽에는 람다식의 결과물
    return sum(a, b)
}
// 람다식이 매개변수로 주어질 경우, 순서상 마지막에 넣어주는 것이 가장 좋다.
// 람다식을 마지막에 넣는 경우, 소괄호 바깥으로 뺄 수 있다!

fun main() {
    val result = highFunc(1, 3) {x, y -> x + y}
    println(result)
}