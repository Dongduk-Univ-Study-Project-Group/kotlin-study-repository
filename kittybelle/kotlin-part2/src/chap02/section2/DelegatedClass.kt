package chap02.section2

interface Car {
    fun go(): String
}

class VanImpl(val power: String): Car {
    override fun go() = "는 짐을 적재하며 spower 마력을 가집니다."
}

class SportImpl(val power: String): Car {
    override fun go() = "는 경주용에 사용되며 $power 마력을 가집니다."
}

class CarModel(val model: String, impl: Car): Car by impl {
    fun carInfo() {
        println("smodel $(go()}") // ① 참조 없이 각 인터페이스 구현 클래스의 g0를 접근
    }
}

fun main() {
    val myDamas = CarModel("Damas 2010", VanImpl("1000|₴|"))
    val my350z = CarModel("350Z 2008", SportImpl("3500|₴"))
    myDamas.carInfo() // ② carInfo에 대한 다형성을 나타냄
    my350z.carInfo()
}
