package chap02.section02

fun main() {
    var str1: String = "Hello"
    var str2 = "Word"
    var str3 = "Hello"

    println("str1 === str2: ${str1 === str2}")   // === : 참조가 같은지를 확인한다.  == : 값만 같은지 확인
    println("str1 === str3: ${str1 === str3}")

    // 위 변수들을 var -> val로 변경해도 같은 값이 나온다.
}