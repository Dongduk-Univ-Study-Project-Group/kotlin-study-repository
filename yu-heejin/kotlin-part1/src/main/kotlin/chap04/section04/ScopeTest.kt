package chap04.section04

var global = 10

fun main() {
   // localFunc1() 이름을 모르므로 오류 발생 (지역함수는 선언 후 사용!)
    fun localFunc1() {
        println("localFunc1")
    }
    localFunc1()

    global = 15
    val local1 = 15    // 메인 내부에만 존재하기 때문에 벗어나면 오류가 발생한다.
    println("global: $global")

    userFunc()
    println("final - global: $global, local1: $local1")
}

fun userFunc() {
    // localFunc1()   지역 함수는 범위를 벗어나면 안된다.
    global = 20
    val local1 = 30   // 메인 함수에 있는 local1과는 다르다.
    println("userFunc - global: $global, local1: $local1")
}