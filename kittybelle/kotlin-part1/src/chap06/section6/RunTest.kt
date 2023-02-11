package chap06.section6

fun main() {
    // apply와 run 비교
    data class Person(var name: String, var skills: String)
    var person = Person("KittyBelle", "Kotlin")

    val returnObj = person.apply { // apply에서는 person 객체 자기 자신 반환
        this.name = "SomSom"
        this.skills = "Java"
        "Success" // 반환되지 않는다.
    }
    println(person)
    println("returnObj: $returnObj")

    val returnObj2 = person.apply {
        this.name = "Elsa"
        this.skills = "Python"
        "Success" // 반환 가능
    }
    println(person)
    println("returnObj2: $returnObj2")
}