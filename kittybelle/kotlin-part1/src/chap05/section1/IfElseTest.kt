package chap05.section1

fun main() {
    println("Enter the score: ")

    val score = readLine()!!.toDouble() // 문자열 한줄 입력받음

    var grade: Char = 'F'

    if(score >= 90.0) {
        grade = 'A'
    }
//    else if(score >= 80 && score <= 89.9) { // 점수가 80점 이상이면서 89.9 이하
//        grade = 'B'
//    }
    else if(score in 80.0..89.9) { // 2개 이상 범위 비교 -> 범위 연산자 쓰면 노란줄 안생김
        grade = 'B'
    } else if(score >= 70 && score <= 79.9) { // 노란줄 생김
        grade = 'C'
    }

    println("score: $score, grade: $grade")
}