package chap02.section2;

class LazyTest {
    init {
        println("init block") // ②
    }

    private val subject by lazy {
        println("lazy initialized") // ⑥
        "Kotlin Programming" // ⑦ lazy 반환값
    }
    fun flow() {
        println("not initialized") //  ④
        println("subject one: $subject") // ⑤ 최초 초기화 시점!
        println("subject two: $subject") // ⑧ 이미 초기화된 값 사용
    }
}

fun main() {
    val test = LazyTest() // 1번
    test.flow() // 3번
}