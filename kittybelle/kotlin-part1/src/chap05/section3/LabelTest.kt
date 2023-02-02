fun main() {
    labelBreak()
}

fun labelBreak() {
    println("labelBreak")
    for(i in 1..5) {
        second@ for (j in 1..5) {
            if (j == 3) break
            println("i:$i, j:$j")
        }
        println("after for j")
    }
    println("after for i")

    // j가 3이 되면 중첩 반복문 탈출, i 증가되어 i는 1~5, j는 1~2
    labelBreak2()
}

fun labelBreak2() {
    println("labelBreak2")
    first@ for(i in 1..5) {
        second@ for (j in 1..5) {
            if (j == 3) break@first
            println("i:$i, j:$j")
        }
        println("after for j")
    }
    println("after for i")

    // j가 최초로 3이 되는 순간 바깥 반복문까지 모두 탈출, after for i 출력 후 종료
    labelBreak3()
}

fun labelBreak3() {
    println("labelBreak3")
    for(i in 1..5) {
        second@ for (j in 1..5) {
            if (j == 3) continue
            println("i:$i, j:$j")
        }
        println("after for j")
    }
    println("after for i")

    // j == 3인 순간 제외 i는 1~5, j는 1, 2, 4, 5

    labelBreak4()
}

fun labelBreak4() {
    println("labelBreak4")
    first@ for(i in 1..5) {
        second@ for (j in 1..5) {
            if (j == 3) continue@first
            println("i:$i, j:$j")
        }
        println("after for j")
    }
    println("after for i")

    // j가 최초로 3이 되는 순간, 바깥 반복문 조건 다시 체크! 그래서 i 1~5, j 1~2
}