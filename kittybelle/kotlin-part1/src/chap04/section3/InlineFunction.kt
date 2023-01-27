package chap04.section3

// 단순 출력 시 노란 경고 -> 함수형 파라미터 타입에 쓰는 것을 추천하기 때문(람다식 형태 사용 추천)
//inline fun shortFunc() {
//    println("Hi")
//}

inline fun shortFunc(a: Int, out: (Int) -> Unit) {
    println("Hi")
    out(a)
    println("Bye")
}

// noinline으로 자바 디컴파일 하면 out.invoke가 그대로 남아있다. 펼쳐지지 않고!
//inline fun shortFunc(a: Int, noinline out: (Int) -> Unit) {
//    println("Hi")
//    out(a)
//}

fun main() {
    // shortFunc() // F7로 함수 프레임 확인 가능
    // inline으로 호출 시 별도의 프레임 생성되지 않음!

    shortFunc(3) {a ->  println("a: $a") }

    // 인자가 1개면 it으로 쓸 수 있음. {println("a: $it")}
    // return -> out과 함께 shortFunc라는 함수 자체도 빠져나가, 즉 비지역반환되어 Bye가 출력되지 않는다.
    shortFunc(3) {
        println("a: $it")
        return
    }

    // 비지역반환을 금지 -> out 앞 crossinline
}