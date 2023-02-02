package chap05.section01

fun main() {
    print("Enter the score: ")
    // readLine() 함수는 문자열로 받기 때문에 double로 변환해야 한다.
    // 코틀린 io의 표준 함수인 readline()은 콘솔로부터 한 줄 입력을 받아들인다.
    // 단순히 val score = readLine().toDouble() 형태로 쓰면 오류가 발생하는데,
    // NotNull 단정문이나 safeCall을 사용한다.
    // 되도록이면 사용하지 않는 것이 좋지만, 입력을 반드시 받을 것이기 때문에 !! 사용
    val score = readLine()!!.toDouble()
    var grade: Char = 'F'

//    if (score >= 90.0) {
//        grade = 'A'
//    } else if (score >= 80 && score <= 89.9) {
//        grade = 'B'
//    } else if (score >= 70 && score <= 79.9) {
//        grade = 'C'
//    }

    if (score >= 90.0) {
        grade = 'A'
    } else if (score in 80.0..89.9) {   // 특정 범위 연산자 사용
        grade = 'B'
    } else if (score in 70.0..79.9) {
        grade = 'C'
    }

    println("score: $score, grade: $grade")
}