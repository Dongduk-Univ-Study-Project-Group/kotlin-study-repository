//fun main() {
//    println("Hello Kotlin")   // 콘솔에 해당 내용이 출력된다. (콘솔과 관련된 API가 지정된 println)
//    println("Hello ~!")
//}

fun main(args: Array<String>) {
    // args라는 인자를 활용
    println("args[0] = ${args[0]}")   // 문자열 내에 변수를 표현하기 위해 ${식}과 같이 표현된다.
    println(args[1])
    println(args[2])
    println(args[3])
    // 해당 상태에서 실행하면 오류가 난다. 전달받은 인자가 없기 떄문에 ArrayIndexOutOfBoundsException 발생
    // Edit Configuration 에서 인자를 추가할 수 있다.
}

// main function : 프로그램의 진입점
// main : no args
// maina : contain args
// Tools -> Kotlin -> Configure Kotlin Plugin Update 를 누르면 플러그인을 최신으로 업데이트 할 수 있다.
// 메인은 프로그램의 진입점이다.
// 기본적으로 JVM 으로 동작하기 때문에, 우리가 작성한 코틀린 코드가 Java 코드로 바뀌고 동작한다.
// 자바는 클래스 내에 메인 진입점으로 실행하는데, 코틀린은 클래스 없이 메인 함수만으로도 실행 가능하다.
// Tools -> Kotlin -> Show Kotlin Bytecode 를 클릭하면 코틀린 코드가 JVM 에서 동작하기 위해 자바와 비슷한 형태의 코드로 변환되는 것을 볼 수 있다. (Decompile)
// 하위에 있는 라이브러리는 자바, 위에는 플랫폼과는 무관한 코틀린 언어 사용