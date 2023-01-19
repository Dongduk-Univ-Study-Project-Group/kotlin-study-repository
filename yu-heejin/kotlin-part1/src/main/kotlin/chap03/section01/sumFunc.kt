package chap03.section01

//fun sum(a: Int, b: Int): Int {
//    // 최상위 함수
//    // 위치가 어디있든 상관없이 호출 가능하다.
//    return a + b    // 반환타입을 선언하지 않으면 오류가 발생한다.
//}

fun main() {
    // 메인 진입점 역할을 하는 일종의 함수
    // 최상위 함수 (Top-level)

    fun sum(a: Int, b: Int): Int {   // 사용 전 메인 함수에다 선언하면 사용이 가능하다.
        return a + b
    }

    val result1 = sum(2, 3)
    println(result1)

//    fun sum(a: Int, b: Int): Int {
//        return a + b
//    }
    // 이 경우 중괄호 안에 있기 때문에 top level 함수가 아니다.
    // 지역 함수가 된다.
    // 반드시 사용 전에 선언을 해줘야 사용할 수 있다.
}

// 최상위 함수는 이름이 어디 있든지 간에 읽을 수 있다.