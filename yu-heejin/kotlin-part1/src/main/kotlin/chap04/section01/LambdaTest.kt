package chap04.section01

fun main() {
    val result: Int
//    val multi = {a: Int, b: Int -> a * b}   // { 람다 함수에 사용할 매개변수 -> 반환할 식 }
    // 매개변수의 자료형은 위에서 따로 선언하든지 혹은 안에 자료형을 같이 선언해준다.
    val multi: (a: Int, b: Int) -> Int = {a, b ->
        println("$a, $b")
        a * b   // 실제 값이 반환되는 부분
    }  // 해당 변수에 익명함수가 들어있기 때문에 해당 변수를 사용할 때 함수처럼 사용할 수 있다.

    val nestedLambda: () -> () -> Unit = { { println("nested") } }
    // nestedLambda를 사용하려면 다음과 같이 선언
    nestedLambda()()

    val lambda: () -> Unit = { println("not nested") }
    // 중첩되지 않은 람다를 사용하려면 다음과 같이 선언
    lambda()

    result = multi(10, 20)
    println(result)
}