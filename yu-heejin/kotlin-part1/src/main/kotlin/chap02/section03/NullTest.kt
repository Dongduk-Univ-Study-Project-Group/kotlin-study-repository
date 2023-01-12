package chap02.section03

fun main() {
    var str1: String?   // null을 허용하려면 ?을 추가한다.
    // str1 = "hello"
    // str1 = null 역시 오류가 발생한다.
    // null 을 허용하면 출력은 가능하다. 다만 연산을 사용하고자하면 오류가 발생한다.
    str1 = null
    //println("str1: $str1, length: ${str1.length}")   // 아무 값도 없는데 사용하려고하면 컴파일 단계에서 오류가 발생한다. (Variable 'str1' must be initialized)

    // 1. safe call 호출
    // 출력 결과 str1: null, length: null
    println("str1: $str1, length: ${str1?.length}")   // 세이프콜 기호 ?. : str이 만약 null이면 ?. 뒤의 부분을 실행하지 않는다. (NPE 예방)

    // 2. Notnull 단정 기호 !!  (사용하지 않는 편이 좋다)
    // null이 아닐거라고 단정하고 컴파일러가 오류를 무시하게 한다.
    // str1에 값이 있는 경우 상관없지만, 없는 경우 문제가 발생한다.
    // str1이 null인데 null이 아니라고 가정해버렸기 때문에 NullPointerException 발생
    // println("str1: $str1, length: ${str1!!.length}")

    // 3. 판단문 (조건문)
    // val len = if (str1 != null) str1.length else -1
    val len = str1?.length ?: -1    // 엘비스 연산자 ?: : null이면 ?: 뒤의 연산 실행, 아니라면 세이프콜 뒤의 연산 실행
    println("str1: $str1, length: $len")
}

// String과 String?은 다른 타입임을 기억하라.

// ${str1.length} 에서는 다음과 같은 오류가 발생한다.
// Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?
// ?의 경우 null 가능성이 존재하기 때문에 바로 .length처럼 멤버 접근이 불가능하다.
// null 가능성이 있기 떄문에 검사 코드나 safe call을 호출해야한다.