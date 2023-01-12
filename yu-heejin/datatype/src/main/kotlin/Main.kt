fun main(args: Array<String>) {
    // val username: String = "Kildong"
    // username = "Dooly"   // 불변형이기 떄문에 변경할 수 없다.

//    var username: String = "Kildong"
//    username = "Dooly"
//    var count: Int = 3
    // 위의 변수들의 경우 어떤 값인지 금방 알 수 있는 경우, 즉 컴파일러가 알 수 있는 타입은 뒤에 타입명을 제거해도 상관없다. (알아서 추론한다.)

    var username = "Kildong"
    username = "Dooly"
    val count = 3
    // 위처럼 선언해도 괜찮다.
    // ctrl + shift + p를 누르면 추론된 자료형을 확인할 수 있다. (윈도우)

//    var username2    // 사용 불가능 (자료형 명시 필요)
//    username2 = "Test"   // 아래에서 정의하더라도 위에서 추론할 수 없기 때문에 오류가 발생한다.

    var username2: String
    username2 = "Test"

    println("username: $username, count: $count")   // 변수명이 하나라면 {} 없이 사용할 수 있다.
}