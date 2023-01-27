package chap04.section4

fun main() {
    val num = 3 // int로 추론
    
    // 일반 표현
    val str = num.strPlus("Kotlin")
    
    // 중위 표현
    val str2 = num strPlus "Kotlin"
    println(str)
}

// Int를 확장해서 multiply() 함수가 하나 더 추가되었음
infix fun Int.strPlus(x: String): String {  // infix로 선언되므로 중위 함수
    return "$x version $this"
}