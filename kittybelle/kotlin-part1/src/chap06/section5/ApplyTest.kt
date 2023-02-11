package chap06.section5

fun main() {
    data class Person(var name: String, var skills : String)
    var person = Person("Kildong", "Kotlin")

    // 여기서 this는 person 객체를 가리킴
    person.apply { this.skills = "Swift" }
    println(person)

    val retrunObj = person.apply {
        name = "Sean" 
        /*
        * apply -> this는 한번 사용 후 재사용시 생략 가능
        * also -> it으로  받은 것 생략 불가능
        */
        skills = "Java" // this 없이 객체의 멤버에 여러 번 접근
        
    }
    println(person)
    println(retrunObj)
}