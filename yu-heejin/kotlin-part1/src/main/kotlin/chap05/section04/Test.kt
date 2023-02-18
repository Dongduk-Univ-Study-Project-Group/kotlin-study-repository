fun main() {
    val calc = Calc()
    var result = 0   // 외부의 변수
    calc.addNum(2, 3) {x, y -> result = x + y}  // 클로저
    println(result)   // 값을 유지하며 5 출력
}

class Calc {
    // 람다식 add에는 반환값이 없다.
    fun addNum(a: Int, b: Int, add: (Int, Int) -> Unit) {
        add(a, b)
    }
}