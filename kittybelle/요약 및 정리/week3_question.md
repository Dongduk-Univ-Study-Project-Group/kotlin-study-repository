### [질문 1] out 함수의 의미

```kotlin
inline fun shortFunc(a: Int, out: (Int) -> Unit) {
    println("Hi")
    out(a)
}

fun main() {
    // shortFunc() // F7로 함수 프레임 확인 가능
    // inline으로 호출 시 별도의 프레임 생성되지 않음!

    shortFunc(3) {a ->  println("a: $a") }
}
```

- out 함수의 의미를 본인이 올바르게 이해한 것인지 궁금함
- a라는 int 값이 매개변수로 들어오고 println이라는 Unit으로 반환되는 것인지
    - a는 **단순 매개변수 이름**으로, b로 바꿔도 상관없음!
    

### [질문 2] IfElseTest

```kotlin
package chap05.section1

fun main() {
    println("Enter the score: ")

    val score = readLine()!!.toDouble() // 문자열 한줄 입력받음

    var grade: Char = 'F'

    if(score >= 90.0) {
        grade = 'A'
    }  else if(score >= 80 && score <= 89.9) {
        grade = 'B'
    } else if(score >= 70 && score <= 79.9) {
        grade = 'C'
    }

    println("score: $score, grade: $grade")
}
```

- 강사님 코드에선 readLine써도 노란줄 안 생기는 것처럼 보이는데, 본인은 생긴다.
    - readLine() : 잘 안쓰는 듯한 표현으로 보임. (slack 자료 참고)
    - readln() : null허용X → readLine()에 강제로 !! 붙여서 널 허용X → 그게 결국 readln()
    - 굳이 잘 안쓰는 readLine()에 !! 붙이지 말고, 간단하게 **readln()** 쓰는 것을 추천

### [질문3] 반환 타입

```kotlin
var str = "안녕"

var result = when(str) {
	**is String -> "문자열입니다" // String이면 해당 문장 반환**
	else -> false // result에 false 반환?
}
```

- String을 반환하거나 boolean을 반환하는 것에 대해 완벽하게 이해가 되지 않았음
    - **조건문에서 반환할 때 return하지 않는다**고 했던 필기 참고할 것
