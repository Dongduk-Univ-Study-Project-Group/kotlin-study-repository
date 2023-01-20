package chap03.section01

fun normalVarargs(vararg a: Int) {
    // vararg로 매개변수를 지정하면 같은 타입인 여러개의 값이 들어올 수 있다 (가변 인자)
    for (num in a) {
        print("$num ")
    }
}

fun main() {
    normalVarargs(1)
    println()
    normalVarargs(1, 2, 3, 4, 5, 6, 7)
}