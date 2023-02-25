package chap01.section4

class Personn(firstName: String, out: Unit = println("[Primary Constructor")){
    val fName = println("[Property] Person fName: $firstName")

    init {
        println("[init] Person init block")
    }

    constructor(firstName: String, age: Int,
                out: Unit = println("[Secondary Constructor] Parameter")): this(firstName) {
                    println("[Secondary Constructor] Body: $firstName, $age")
                }
}

fun main() {
    val p1 = Personn("kitty", 30)
    println()
    val p2 = Personn("belle")
}

/*
    인자 2개짜리 부 생성자 진입
     [Secondary Constructor] Parameter 출력
     this의 인자가 1개이므로 클래스 상단에 진입
     [Primary Constructor 출력
 */