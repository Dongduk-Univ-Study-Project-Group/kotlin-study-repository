package chap05.section02

fun main() {
    var total = 0

//    for (num in 1..100 step 2) {    // 홀수의 합
//        total += num
//    }

    for (num in 0..100 step 2) {    // 짝수의 합
        total += num
    }

    println("total: $total")
}