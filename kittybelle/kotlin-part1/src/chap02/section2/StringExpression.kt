package chap02.section2

fun main() {
    var a = 1

    // 문자열에 표현식 사용
    var str1 = "a = $a" // a = 1
    var str2 = "a = ${a + 2}" // a = 3

    println("str1 : \"$str1\", str2: \"$str2\"")
}