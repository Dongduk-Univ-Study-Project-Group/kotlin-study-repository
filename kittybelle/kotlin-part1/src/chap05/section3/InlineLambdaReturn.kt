fun main() {
    retFunc()
}

inline fun inlineLambda(a: Int, b: Int, out: (Int, Int) -> Unit) {
    out(a, b)
}

fun retFunc() {
    println("Start of retFunc")

    inlineLambda(13, 3) lit@{ a, b ->  // 라벨 지정
        val result = a + b
        if(result > 10) return@lit // 라벨을 사용한 블록의 끝부분으로 반환
        println("result: $result")
    } // 이 부분으로 빠져나가므로
    println("end of retFunc") // 이 문장 실행됨
}