package chap03.section3

// 람다식을 맨 뒤에 넣는게 좋다.
fun highFunc(a: Int, b: Int, sum: (Int, Int) -> Int): Int {
    // return sum(a, b)
    return sum(a+10, b)
}

fun main() {
    // val result = highFunc({x, y -> x + y}, 1, 3)

    // 식이 길어질 경우 엔터로 식만 별도로 쓸 수 있음.
    val result = highFunc(1, 3) { x, y ->
        x + y
    }
    println(result)
}