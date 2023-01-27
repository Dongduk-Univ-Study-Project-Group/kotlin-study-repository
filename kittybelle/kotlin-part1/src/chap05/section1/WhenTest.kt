package chap05.section1

fun main() {
    print("Enter the score: ")

    val score = readLine()!!.toDouble() // 문자열 한줄 입력받음

    var grade: Char = 'F'

    // 노란줄 없는 코드
    grade = when(score) {
        in 90.0..100.0 -> 'A'
        in 80.0..89.9 -> 'B'
        in 70.0..79.9 -> 'C'
        else -> 'F'
    }

    // 노란줄 있는 코드
//    when(score) {
//        in 90.0..100.0 -> grade = 'A'
//        in 80.0..89.9 -> grade = 'B'
//        in 70.0..79.9 -> grade = 'C'
//        else -> grade = 'F'
//    }

    println("score: $score, grade: $grade")
}