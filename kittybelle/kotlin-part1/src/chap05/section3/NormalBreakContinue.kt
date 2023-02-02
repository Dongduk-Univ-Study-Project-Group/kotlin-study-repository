fun main() {
    for(i in 1..5) {
        if(i == 3)
            break
        print(i)
    }
    println()
    println("outside")

    main2()
}

fun main2() {
    for(i in 1..5) {
        if(i == 3)
            continue
        print(i)
    }
    println()
    println("outside")
}