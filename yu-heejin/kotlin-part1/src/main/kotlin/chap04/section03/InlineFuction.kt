package chap04.section03

//inline fun shortFunc(a: Int, noinline out: (Int) -> Unit) {
//    println("Hello")
//    out(a)    // inline되지 않음
//}

// inline을 사용하면 다음과 같은 경고문을 볼 수 있다.
// Expected performance impact from inlining is insignificant.
// Inlining works best for functions with parameters of functional types
// 람다식 함수 형태를 취하는 것이 더 좋다.
// 코드가 길어질 경우, 매번 메인에 복사되는 것이기 때문에 호출 빈도가 높아지면 코드 사이즈가 커진다.

inline fun shortFunc(a: Int, crossinline out: (Int) -> Unit) {
    println("Hello")
    out(a)    // inline되지 않음
    println("Goodbye")
}

fun main() {
    // shortFunc(3, {a -> println("a: $a")})
    // shortFunc(3, {println("a: $it")})
    shortFunc(3) {
        println("a: $it")
        // return   // 리턴하게 되면 out뿐만 아니라 shortFunc 자체를 빠져나오게 된다,
        // 리턴을 하게 되면 println("Goodbye") 는 실행되지 않는다. (비지역반환)
        // crossinline은 비지역 반환을 못하게 막는 기능을하기 때문에 return을 하면 오류가 발생한다.
    }
}