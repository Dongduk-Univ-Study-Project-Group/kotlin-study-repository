package chap02.section2

fun main() {
    var str1: String = "Hello"
    var str2 = "World"
    var str3 = "Hello"

    println("str1 === str2 ${str1 === str2}") // false, 다른 참조 공간
    println("str1 === str3 ${str1 === str3}") // true, 같은 공간에 있음(주소가 같고 변수 이름만 다름)
}