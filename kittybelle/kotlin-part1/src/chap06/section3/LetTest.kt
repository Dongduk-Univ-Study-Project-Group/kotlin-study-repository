package chap06.section3

fun main() {
    val score: Int? = 32

    // null 가능성 -> if문으로 체크하는 것이 일반적
    fun checkScore() {
        if (score != null)
            println("Score: $score")
    }

    // let을 사용 -> ?. safe call 이용하여 null 검사를 제거
    fun checkScoreLet() {
        score?.let { println("Score: $it") } // ① score을 it으로 받아옴
        val str = score.let { it.toString() } // ②
        println(str)
    }

    checkScore()
    checkScoreLet()
}