package chap02.section02

fun main() {
    var a = 1
    val str1 = "a = $a"
    val str2 = "a = ${a + 2}"   // 먼저 계산된 다음 그 값이 문자열로 저장된다.

    println("str1: \"$str1\", str2: \"$str2\"")
}