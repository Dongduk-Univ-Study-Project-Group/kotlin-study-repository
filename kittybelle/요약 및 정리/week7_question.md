### [질문 1] open 상속 = protected인가?

- 아니다. 별개다.
    - 상속 : extends
    - 접근 제어자 : protected


### [질문 2] 마지막 줄

```kotlin
package chap01.section5

private class PrivateClass {
    private var i = 1
    private fun privateFunc() {
        i += 1 // 접근 허용
        println(i)
    }
    fun access() { // public
        privateFunc() // 접근 허용
    }
}

class OtherClass {
   // val opc = PrivateClass() // 불가 - 프로퍼티 opc는 private이 되야 함
    fun test() {
        val pc = PrivateClass() // 생성 가능
    }
}

fun main() {
    val pc = PrivateClass() // 생성 가능
   // pc.i // 접근 불가
   // pc.privateFunc() // 접근 불가
}

fun TopFunction() {
    val tpc = PrivateClass() // 객체 생성 가능
    println(tpc.access()) // 객체 생성 가능한데 실행은 안됨
}
```

- 실행이 안되는 게 아니라 main에서 함수 호출이 애초에 안되어 있었음
- public → 같은 클래스 내 private이라 print 잘 되는 것 확인
