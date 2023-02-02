package chap05.section02

fun main() {
    // 5 -> 12345, 23451, 34512 ...
    do {
        println("Enter the number: ")
        val input = readLine()!!.toInt()   // [의문] 자바에서는 do 블럭 안에 있는 변수 못 썼던거같은데 아닌가..?

        for(i in 0 until input) {
            // until을 사용하면 0부터 input - 1이 된다.
            for (j in 0 until input) {
                print((i + j) % input + 1)
            }
            println()
        }
    } while (input != 0)
}