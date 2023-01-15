package chap02.section3

fun main() {
    val a: Int? = 127 // a128갖는걸 참조를 하고 있으니
    val b = a // 자바도 그러는지 Integer

    println(a == b)
    println(a === b)

    val c: Int? = a
    val d: Int? = a
    val e: Int? = c

    println(c == d) // true
    println(c === d) // false - null 허용 안해서?
    println(c === e) // true

    println(c === a)
    
    // 128 미만
    // null 허용하면서 128 이상인거랑
    // null 허용하면서 128 이상이면 false가 나온다.
    // a랑 직접 비교
}