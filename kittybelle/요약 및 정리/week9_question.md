### [질문 1] lateinit → 프로퍼티 null 불가임. 그럼 언제 초기화해야할까?

- 프로그램 실행 전으로 보인다고 생각했으나
    - → null이 불가능한 게 아니라, NPE를 막기 위한 장치 중 하나.
    - → null 자체는 가능하다.

### [질문2] val 변수 값 변경 불가?

kim hong 이름 바꾸기가 가능?

```kotlin
class Person1(val name: String, val age: Int)

fun main() {
    var isPersonInstantiated: Boolean = false  // ① 초기화 확인 용도

    val person : Person1 by lazy { // ② lazy를 사용한 person 객체의 지연 초기화
        isPersonInstantiated = true
        Person1("Kim", 23) // ③ 이 부분이 Lazy 객체로 반환 됨
    }
    val personDelegate = lazy { Person1("Hong", 40) }  // ④ 위임 변수를 사용한 초기화

    println("person Init: $isPersonInstantiated")
    println("personDelegate Init: ${personDelegate.isInitialized()}")

    println("person.name = ${person.name}")  // ⑤ 이 시점에서 초기화
    println("personDelegate.value.name = ${personDelegate.value.name}")  // ⑥ 이 시점에서 초기화

    println("person Init: $isPersonInstantiated")
    println("personDelegate Init: ${personDelegate.isInitialized()}")
}
```

- 이름을 바꾸는 코드가 없다. 애초부터 둘이 다른 변수였음.
    - val person
    - val personDelegate
