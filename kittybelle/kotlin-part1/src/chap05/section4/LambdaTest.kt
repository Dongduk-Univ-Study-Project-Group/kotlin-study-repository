package chap05.section4

fun high(name: String, body: (Int)->Int): Int {
    println("name: $name")
    val x = 0
    return body(x)
}
fun main() {
    // 함수를 이용한 람다식, inc(x + 3)의 결과는 Int여야 함
    val result = high("Sean", {  x -> inc(x + 3) })

    // 소괄호 바깥으로 빼내고 x -> 생략, it 사용
    val result2 = high("Sean") { inc(it + 3) }

    // 매개변수 없이 함수의 이름만 사용할 때, 참조방식 ::
    val result3 = high("Kim", ::inc)

    // 람다식 자체를 넘겨 준 형태
    val result4 = high("Sean") { x -> x + 3 }

    // 매개변수가 한 개인 경우 생략
    val result5 = high("Sean") { it + 3 }

    // 일반 매개변수가 없고(문자열에 인자가 없다면) 람다식만이 유일한 인자라면
    val result6 = highNoArg { it + 3 }
}