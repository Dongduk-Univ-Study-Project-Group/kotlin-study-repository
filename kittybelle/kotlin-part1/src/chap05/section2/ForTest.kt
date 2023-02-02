fun main() {
    var total = 0

    //for(num in 1..100 step 2) // 홀수 합
    for(num in 0..99 step 2) { // 짝수 합
        total += num
    }

    println("total: $total")
}