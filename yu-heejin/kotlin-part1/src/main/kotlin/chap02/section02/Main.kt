package chap02.section02

fun main(args: Array<String>) {
    var num: Double = 0.1

    for (x in 0..999) {
        num += 0.1
    }

    println("num: $num")

    // 출력 시 이상한 숫자가 나오는데, 이것은 double 형의 제한 값 때문이다.
}