### [질문 1] 라벨 break, continue

```kotlin
다음과 같은 코드 밑줄에서 코드를 중단하고 first@의 for문으로 가려면 어떤 코드를 사용하는지 답하세요.

fun labelBreak() {
    println("labelBreak")
    first@ for(i in 1..5) {
        second@ for (j in 1..5) {
            if (j == 3) ______________
            println("i:$i, j:$j")
        }
        println("after for j")
    }
    println("after for i")
}
```

- break@second
- break@first
- continue@first
- return@first

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f80f6d30-f4af-4b6d-813e-eb5572f9e977/Untitled.png)

나 : break@second 고름. 그래야 다시 first@확인하면서 i 증가할 것.

답 : **break@first**

- break@first를 하면 after for i 출력 후 종료될텐데 어째서 답이 break@first인지 의문
    - 문제 표현의 **first@의 for문으로 가려면** → 반복 조건을 계속 확인하고자 하는 것이 아닌, first를 **종료하고자 하는 의도**인 것 같음.
    - 옵션을 달지 않아도 second는 종료가 됨

### [질문 2] LambdaTest.kt

```kotlin
package chap05.section4

fun high(name: String, body: (Int)->Int): Int {
    println("name: $name")
    val x = 0
    return body(x)
}
fun main() {
// 함수를 이용한 람다식, inc(x + 3)의 결과는 Int여야 함
val result = high("Sean", {  x -> inc(x + 3) })

// 소괄호 바깥으로 빼내고 x -> 생략, it 사용
val result2 = high("Sean") { inc(it + 3) }

// 매개변수 없이 함수의 이름만 사용할 때, 참조방식 ::
val result3 = high("Kim", ::inc)

// 람다식 자체를 넘겨 준 형태
val result4 = high("Sean") { x -> x + 3 }

// 매개변수가 한 개인 경우 생략
val result5 = high("Sean") { it + 3 }

// 일반 매개변수가 없고(문자열에 인자가 없다면) 람다식만이 유일한 인자라면
val result6 = highNoArg { it + 3 }
}
```

- result, result2에서 Int가 아닌 Unit 타입이라며 에러가 뜨는 상황
- 자료에 코드 더 없었고, 강의에서도 IntelliJ로 실행하진 않았었음 (본인이 자료 코드 복붙한 것)
    - val result에서 { } 사이 공백을 지우거나, 소괄호를 밖으로 빼도 Unit 타입이라고 떴음
    - `fun inc(x: Int): Int {return x}` 
    코드 추가하면 에러가 없어짐
    - inc 함수 검색 → **inc()**로 **매개변수 없이 사용**, **++연산, 사용 예 : x.inc()**
        - **연산자 오버로딩**을 한 것 같음.
        - 연산자 오버로딩 : 객체 지향 프로그래밍에서 다형성의 특별한 경우로 다른 연산자들이 함수 연사자를 통해서 구현을 할 때
        - 참고 링크
        - https://sabarada.tistory.com/174
