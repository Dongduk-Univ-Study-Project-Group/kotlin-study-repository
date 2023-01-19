package chap03.section1

fun sum(a: Int, b: Int): Int { // 최상위 함수, 여기서의 a와 b는 매개변수
    return a + b
}

//fun sum(a: Int, b: Int = 5): Int { // 인자 없을 경우 default 5지정
//    return a + b
//}

// fun sum(a: Int, b: Int) = a + b

fun max(a: Int, b: Int): Int {
    return if(a > b) a else b // a > b 판단 후 맞으면 a 반환, 틀리면 b 반환
}

fun outfunc(name: String): Unit {
    println("Name: $name")
    // return Unit 이 생략돼있는 것
}

fun main() { // 최상위(Top-level) 함수
    val result1 = sum(2, 3) // 여기서의 a와 b는 인자(arguments)
    println(result1)

    fun sum1(a: Int, b: Int): Int { // 지역 함수
        return a + b
    }

    val a = 3
    val b = 5

    val result2 = max(a, b) // 값이 복사되어 매개변수에 들어간다고 이해하기
    println(result2)

    outfunc("KittyBelle")
}