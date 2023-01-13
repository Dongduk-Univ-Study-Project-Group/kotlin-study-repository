package chap02.section03

fun main() {
    val a: Int = 1280
    // val a: Int? = 129    // 해당 값으로 비교하면 아래 비교문이 모두 true
    val b = a    // Int 형으로 추론된다.
    println(a == b)   // 2개의 값이 같기 때문에 true가 나온다.
    println(a === b)  // true

    // Integer c = 1280
    // Integer d = 1280
    val c: Int? = a
    val d: Int? = a
    val e: Int? = c
    // c와 d는 기본적으로 객체가 된다.
    // 하지만 기본적으로 객체가 되기 때문에 동적 공간에 존재하고, 주소를 가리키기 때문에 값만 똑같고 위치는 다르다.
    // 의문인 점 : String은 String pool이 있어서 객체여도 같은 결과가 나오고, Int는 아니라서 ===를 쓰면 false가 나오는가?
    println("a를 참조하는 두 값끼리 참조")
    println(c == d)
    println(c === d)   // 값은 같지만 참조 주소는 다르다.
    println("a를 직접 넣어 비교한다면")
    println(a === c)
    println(a === d)

    // e가 c가 가리키는 공간을 그대로 참조하고 있기 때문에 true
    println(c === e)

    // null을 허용해도 true
    var str1: String? = "Hello"
    var str3: String? = "Hello"
    println("str1 === str3: ${str1 === str3}")   // 값도 같고 참조 주소도 같다.

    val aa: Int? = 128
    val bb: Int? = 128
    println("aa, bb의 삼중 비교 결과")
    println(aa === bb)   // 이건 또 true라네..?
    // 자주 사용하는 1byte 정수에 대해서는 내부적으로 싱글톤 처리를 하기 때문에 같은 객체를 참조한다!
    // refer: https://lannstark.tistory.com/144
    // Java에서도 돌려봐야겠다.
    /*
        그 이유는, Integer 형은 [-128. 127] 범위에서 캐싱하기 때문에 범위 내에 값이 있으면 새로운 인스턴스를 생성하지 않습니다.
        그러므로 Integer로 박싱될 때 a는 100이기 때문에 새로운 객체를 생성하지 않아, boxedA와 anotherBoxedA는 같은 객체를 가지게 되는 것입니다.
        반대로 캐싱되지 않은 boxedB와 anotherBoxedB는 다른 객체를 가져 false를 리턴하게 되는 것입니다.
        https://gwi02379.tistory.com/14
     */
    println(aa == bb)

}