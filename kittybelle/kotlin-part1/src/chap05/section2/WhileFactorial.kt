fun main() {
    print("Enter the number: ")

    var number = readln().toInt()
    var factorial: Long = 1

    while(number > 0) {
        factorial *= number
        --number // number-- 해도 결과는 같음
    }
    println("Factorial: $factorial")
}