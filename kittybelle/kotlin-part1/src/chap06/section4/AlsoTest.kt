package chap06.section4

fun main() {
    data class Person(var name: String, var skills: String) // Property
    val person = Person("KittyBelle", "Kotlin") // 생성자
    
//    val a = person.let {
//        it.skills = "Java" // 객체 값 변경
//        "Success" // a에 반환됨
//    }
//
//    println("a $a") // Success 반환
//    println("person $person")

    val b = person.also {
        it.skills = "Java" // 객체 값 변경
        "Success" // Success를 반환하지 않고 person 객체 자체를 반환 -> Person 출력
    }

    println("b $b")
    println("person $person")
}