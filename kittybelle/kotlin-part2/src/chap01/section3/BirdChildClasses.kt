package chap01.section3

open class Bird(var name: String, var wing: Int, var beak: String) {
    open fun fly() { // 오버라이딩 가능하게 하려면 open 필요
        println("Fly")
    }
}

class Lark(name: String, wing: Int, beak: String): Bird(name, wing, beak) {
    override fun fly() {
        println("Quick Fly")
    }

    fun singHitone() {
        println("sing Hitone")
    }
}

class Parrot: Bird {
    var language: String

    // 부 생성자 - var 선언 불가! 주 생성자에서만 가능
    constructor(name: String, wing: Int, beak: String, language: String): super(name, wing, beak) {
        this.language = language
    }

    // 생성자의 인자 3개가 super로 전달, 상위 클래스인 Bird로 전달

    fun speak() {
        println("Speak: $language")
    }

    override fun fly() {
        println("Slow Fly")
    }
}

fun main() {
    val lark = Lark("mylark", 2, "short")
    val parrot = Parrot("myparrot", 2, "long", "English")

    // Bird 타입으로 객체 생성 시 singHitone 사용 불가
    
    println("lark - name: ${lark.name}")
    println("parrot - name: ${parrot.name}, lang: ${parrot.language}")

    lark.singHitone()
    lark.fly()

    parrot.speak()
    parrot.fly()
}