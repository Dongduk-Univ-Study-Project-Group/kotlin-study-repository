package chap06.section04

fun main() {
    data class Person(var name: String, var skills: String)
    val person = Person("kildong", "kotlin")

//    val a = person.let {
//        it.skills = "java"
//        "Success"   // 마지막 식은 반환되어 a에 저장된다.
//    }

    val a = person.also {
        it.skills = "java"
        "Success"   // 무의미한 코드, 반환되는 것은 person 객체 그 자체
    }

    println("a: $a")
    println("person: $person")
}