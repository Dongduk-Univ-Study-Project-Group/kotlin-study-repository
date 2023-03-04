package chap01.section02

//class Bird(_name: String, _wing: Int, _beak: String) {  // 주 생성자로 constructor 키워드 생략 가능
//    // property
//    // 생성자가 없는 상태에서 미리 초기화를 하지 않으면 오류가 발생한다.
//    var name: String = _name
//    val wing: Int = _wing
//    var beak: String = _beak
//
//    // 부 생성자 기법
////    constructor(_name: String, _wing: Int, _beak: String) {
////        // _를 사용할 경우 다른 이름이 되므로 this 를 사용할 필요가 없다.
////        // this 라는 특수한 참조 포인터(?)를 사용하여 클래스 필드를 가리킨다.
////        this.name = _name
////        this.wing = _wing
////        this.beak = _beak
////    }
//
//    // method
//    fun fly() {
//        println("fly")
//    }
//}

// 생성자의 매개변수와 프로퍼티 이름을 한꺼번에 합칠 수도(?) 있다.
// 아래처럼 정의하면 프로퍼티와 함께 정의된다. (생성자 및 프로퍼티가 한꺼번에 정의된 방식)
//class Bird(var name: String, val wing: Int, var beak: String) {
//    // 생성자 내에 간단한 코드를 넣고 싶은 경우 사용한다.
//    // 객체 생성 시 자동 실행되기 때문에 시간이 많이 걸리는 작업에 사용하면 안된다.
//    init {
//        println("==========init start==========")
//        // capitalize는 문자열 첫 문자를 대문자로 바꾼다.
//        name = name.capitalize()
//        println("name: $name, wing: $wing, beak: $beak")
//        println("==========init end==========")
//    }
//
//    // method
//    fun fly() {
//        println("fly")
//    }
//}

class Bird {
    var name: String
    var wing: Int
    var beak: String

    constructor(_name: String, _wing: Int, _beak: String) {
        // _를 사용할 경우 다른 이름이 되므로 this 를 사용할 필요가 없다.
        // this 라는 특수한 참조 포인터(?)를 사용하여 클래스 필드를 가리킨다.
        name = _name
        wing = _wing
        beak = _beak
    }

    // 매개변수가 같은 생성자가 존재할 경우 충돌이 발생한다.
    constructor(_name: String, _beak: String) {
        name = _name
        wing = 2
        beak = _beak
    }

    // method
    fun fly() {
        println("fly")
    }
}


fun main() {
    val coco = Bird("coco", 2, "long")
    val coco2 = Bird("coco", "long")

    // coco.name = "coco"   생성자를 정의했으므로 필요 없다.
    coco.fly()
    // println(coco)   // 객체를 프린트하면 단순히 해당 객체에 대한 식별자가 출력된다.
    println(coco.name)
    println(coco.wing)
    println(coco.beak)

    println("coco2: name: ${coco2.name}, wing: ${coco2.wing}, beak: ${coco2.beak}")
}