package chap04.section03

inline fun shortFunc(a: Int, out: (Int) -> Unit) {
    println("Hello")
    out(a)
}

// inline을 사용하면 다음과 같은 경고문을 볼 수 있다.
// Expected performance impact from inlining is insignificant.
// Inlining works best for functions with parameters of functional types
// 람다식 함수 형태를 취하는 것이 더 좋다.
// 코드가 길어질 경우, 매번 메인에 복사되는 것이기 때문에 호출 빈도가 높아지면 코드 사이즈가 커진다.

fun main() {
    // shortFunc(3, {a -> println("a: $a")})
    // shortFunc(3, {println("a: $it")})
    shortFunc(3) {
        println("a: $it")
    }
}