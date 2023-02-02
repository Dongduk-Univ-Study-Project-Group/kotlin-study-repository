package chap05.section4

fun main() {
    var amount = 600

    try {
        amount -= 100
        checkAmount(amount)
    } catch (e: java.lang.Exception) {
        println(e.message)
    }
    println("amount: $amount")
}

fun checkAmount(amount: Int) {
    if(amount < 1000) { // 잔고가 1000 이하일 때 예외 발생
        throw Exception("잔고가 $amount 으로 1000 이하입니다.")
    }
}