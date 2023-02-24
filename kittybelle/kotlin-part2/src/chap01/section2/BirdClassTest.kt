package chap01.section2

// 주 생성자 - constructor 생략 가능
// class Bird (_name: String, _wing: Int, _beak: String)

// 매개변수에서 미리 정의하면 필드의 var도 생략 가능
// class Bird constructor(var name: String, val wing: Int, var beak: String)

class Bird constructor(_name: String, _wing: Int, _beak: String) {
    // 프로퍼티
    // 주 생성자
    var name: String = _name
    var wing: Int = _wing
    var beak: String = _beak

    // 생성자 내 간단 코드 넣고 싶을 때
    // 복잡한 코드는 넣으면 안된다.
    init {
        println("------ init start ------")
        name = name.capitalize()
        println("name: $name, wing: $wing, beak: $beak")
        println("------ init end ------")
    }

    // 부 생성자
//    var name: String = "noname"
//    var wing: Int
//    var beak: String

//    // 부 생성자 - 매개변수 다르게 하여 1개 이상 생성 가능
//    constructor(_name: String, _beak: String) {
//        name = _name
//        beak = _beak
//    }

    //    constructor(_name: String, _wing: Int, _beak: String) {
//       // 방법 1
//        this.name = name
//        this.wing = wing
//        this.beak = beak
//
//        // 방법 2
////        name = _name
////        wing = _wing
////        beak = _beak
//    }

    // 메소드
    fun fly() {
        println("Fly wing: $wing")
    }
}

fun main() {
    val coco = Bird("coco", 2, "long") // 부 생성자 사용
    // val coco2 = Bird("coco", "long")
    coco.name = "coco"
    coco.fly()
}