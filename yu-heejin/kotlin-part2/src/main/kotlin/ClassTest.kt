class Car {
    val wheel: Int = 4

    fun start() {
        println("Engine Start!")
    }
}

// 중괄호로 비워놓거나 단순 이름으로 존재하는 것이 가능하다.
class Bird {}
// class Bird

fun main() {
    // 생성자를 사용하여 객체를 생성한다.
    // 내부적으로 비어있는 생성자를 가지게 된다.
    // 명시적으로 선언시 타입을 제거해도 추론할 수 있다.
    val sonata: Car = Car()

    println(sonata.wheel)
    sonata.start()
}