package chap05.section01

fun main() {
    print("Enter the score: ")
    val score = readLine()!!.toDouble()
    var grade: Char = 'F'

//    when (score) {
//        in 90.0..100.0 -> grade = 'A'
//        in 80.0..89.9 -> grade = 'B'
//        in 70.0..79.9 -> grade = 'C'
//        else -> grade = 'F'
//    }

    // 인수 없는 when
    when {
        score >= 90.0 -> grade = 'A'    // 인자 있는 when과 달리 조건식을 구성할 수 있다.
        score in 80.0..89.9 -> grade = 'B'
        score in 70.0..79.9 -> grade = 'C'
        score < 70.0 -> grade = 'F'
    }

    println("score: $score, grade: $grade")
}