package chap02.section1

//class Person(_id: Int, _name: String, _age: Int) {
//    // 프로퍼티
//    var id: Int = _id
//
//    // val은 세터 안생김
//    val name: String = _name
//    val age: Int = _age
//}

// 간단한 표현
class Person(var id: Int, val name: String, val age: Int)

fun main() {
    val person = Person(1, "Kildong", 30)

    person.id = 2 // 세터
    println(person.id) // 게터
}