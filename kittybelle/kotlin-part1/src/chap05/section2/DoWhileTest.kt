fun main() {
    // 5 -> 12345, 23451, 34512...

    do {
        print("Enter the number: ")
        val input = readln().toInt()

        for(i in 0 until input) { // until : input - 1과 같은 효과
            for(j in 0..(input - 1)) {
                print((i + j) % input + 1) // 모듈로 연산 사용시 값 범위 벗어나지 않음
            }
            println()
        }
    } while(input != 0) // input == 0이면 탈출
}