package chap01.section03

open class Bird(var name: String, var wing: Int, var beak: String) {  // 주 생성자 및 프로퍼티
    fun fly() {
        println("fly")
    }
}

// 주 생성자를 사용하는 경우 super 대신 상속 클래스 이름을 바로 사용한다.
// 주 생성자에서는 추가 프로퍼티를 넣을 수 있다. (val, var)
class Lark(name: String, wing: Int, beak: String) : Bird(name, wing, beak) {
    // fly 외의 추가적인 메서드를 가진다.
    fun singHighTone() {
        println("sing HighTone")
    }
}

// 생성자에 매개변수가 있으므로 반드시 초기화를 실행해야 한다.
// 반드시 부모 클래스가 가지는 생성자의 내용이 주 혹은 부 생성자에 정의되어야 한다.
class Parrot : Bird {
    var language: String

    // 주 생성자에 초기화하지 않을 경우에는 부 생성자에 초기화해야 한다.
    // 추가 프로퍼티인 language 추가는 부 생성자에서는 허용되지 않는다.
    // constructor(name: String, wing: Int, beak: String, var language: String)

    // super를 통해 상위 프로퍼티가 초기화된다.
    constructor(name: String, wing: Int, beak: String, language: String) : super(name, wing, beak) {
        this.language = language
    }

    fun speak() {
        println("Speak: $language")
    }
}

fun main() {
    val lark = Lark("myLark", 2, "short")
    val parrot = Parrot("myParrot", 2, "long", "English")

    println("lark - name: ${lark.name}")
    println("parrot - name: ${parrot.name}, lang: ${parrot.language}")

    lark.singHighTone()
    lark.fly()

    parrot.speak()
    parrot.fly()
}