package chap06.section7

fun main() {
    data class User(val name: String, var skills: String, var email: String? = null)

    val user = User("KittyBelle", "default")

    val result = with(user) { // 위에 선언한 user를 직접 이용
        skills = "Kotlin"
        email = "kb@example.com"
        // "Sucess" // 없으면 Unit 반환
    }
    println(user)
    println("result: $result")
}