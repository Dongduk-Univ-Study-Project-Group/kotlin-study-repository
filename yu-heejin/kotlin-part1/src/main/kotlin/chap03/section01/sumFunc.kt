package chap03.section01

fun sum(a: Int = 2, b: Int = 5): Int {   // 정의할 때 사용한 변수들은 함수의 매개변수(parameters)
    // 최상위 함수
    // 위치가 어디있든 상관없이 호출 가능하다.
    return a + b    // 반환타입을 선언하지 않으면 오류가 발생한다.
}
// b: Int = 5와 같이 선언한 경우, 매개변수에 값이 없을 때 기본값으로 지정된다.

// fun sum(a: Int, b: Int): Int = a + b

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

// fun max(a: Int, b: Int) = if (a > b) a else b

fun outfunc(name: String): Unit {
    println("name: $name")
    // return Unit   숨겨져있지만 이러한 형태로 반환되고 있다.
}

// fun outfunc(name: String) = println("Name: $name")

fun main() {
    // 메인 진입점 역할을 하는 일종의 함수
    // 최상위 함수 (Top-level)

//    fun sum(a: Int, b: Int): Int {   // 사용 전 메인 함수에다 선언하면 사용이 가능하다.
//        return a + b
//    }

    val result1 = sum(2, 3)    // 함수를 사용할 땐 인자 혹은 인수(arguments)
    val result3 = sum(2)    // default 값이 있는 경우 생략 가능하다.
    val result4 = sum(b = 2)   // 특정 매개변수에만 값을 넣고 싶을 때 사용한다.

    val a = 3
    val b = 5
    val result2 = max(a, b)

    outfunc("졸리다")

    println(result1)
    println(result2)
    println(result3)

//    fun sum(a: Int, b: Int): Int {
//        return a + b
//    }
    // 이 경우 중괄호 안에 있기 때문에 top level 함수가 아니다.
    // 지역 함수가 된다.
    // 반드시 사용 전에 선언을 해줘야 사용할 수 있다.
}

// 최상위 함수는 이름이 어디 있든지 간에 읽을 수 있다.