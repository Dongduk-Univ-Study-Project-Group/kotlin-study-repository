package chap02.section04

fun main() {
    var a: Int = 10
    var b: Int = 10

    var result1 = ++a   // 증가를 먼저 한 후 대입하기 때문에 11
    var result2 = b++   // 대입 후 나중에 증가하기 때문에 10

    println("result1: $result1")
    println("result2: $result2")

    // 후위 증가이든 전위 증가이든 어쩄든 위에서 증가를 했기 때문에 아래 값은 같다.
    println("num1: $a")
    println("num2: $b")
}