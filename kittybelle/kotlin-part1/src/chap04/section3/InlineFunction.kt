package chap04.section3

// 단순 출력 시 노란 경고 -> 함수형 파라미터 타입에 쓰는 것을 추천하기 때문(람다식 형태 사용 추천)
//inline fun shortFunc() {
//    println("Hi")
//}

inline fun shortFunc(a: Int, out: (Int) -> Unit) {
    println("Hi")
    out(a)
}

fun main() {
    // shortFunc() // F7로 함수 프레임 확인 가능
    // inline으로 호출 시 별도의 프레임 생성되지 않음!

    shortFunc(3) {a ->  println("a: $a") }
    // 인자가 1개면 it으로 쓸 수 있음. {println("a: $it")}
    shortFunc(3) {
        println("a: $it")
    }
}