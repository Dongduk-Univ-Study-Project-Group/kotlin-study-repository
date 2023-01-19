package chap04.section1

fun main() {

    var result: Int

    // 일반 변수에 람다식 할당
    // 형태 1) { 람다 함수에 쓸 매개변수 -> 반환할 식 }
    val multi = {x: Int, y: Int -> x * y}

    // 형태 2) a와 b의 자료형을 생략하고 싶을 때! 람다식 정의 먼저.
    val multi2: (a: Int, b: Int) -> Int = {a, b ->
        println("a: $a, b: $b")
        a * b // 마지막 식이 반환됨!
    }

    // 반환값이 없을 경우, 반환타입 Unit 지정 필수!
    val multi3: (a: Int, b: Int) -> Unit = {a, b ->
        println("a: $a, b: $b")
    }

    // 람다 안에 람다
    val nestedLambda: () -> () -> Unit = {{ println("nestedLambda") }}

    // 람다식이 할당된 변수는 함수처럼 사용 가능
    result = multi(10, 20)
    println(result)
}