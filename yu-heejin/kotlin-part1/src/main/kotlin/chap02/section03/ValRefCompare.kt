package chap02.section03

fun main() {
    val a: Int = 128
    val b = a    // Int 형으로 추론된다.

    println(a == b)   // 2개의 값이 같기 때문에 true가 나온다.
    println(a === b)  // true

    val c: Int? = a
    val d: Int? = a
    val e: Int? = c

    // c와 d는 기본적으로 객체가 된다.
    // 하지만 기본적으로 객체가 되기 때문에 동적 공간에 존재하고, 주소를 가리키기 때문에 값만 똑같고 위치는 다르다.
    // 의문인 점 : String은 String pool이 있어서 객체여도 같은 결과가 나오고, Int는 아니라서 ===를 쓰면 false가 나오는가?
    println(c == d)
    println(c === d)

    // e가 c가 가리키는 공간을 그대로 참조하고 있기 때문에 true
    println(c === e)
}