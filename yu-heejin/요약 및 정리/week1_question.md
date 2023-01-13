## [의문인 점] 참조

```kotlin
package chap02.section03

fun main() {
    val a: Int = 128
    // val a: Int? = 129    // 해당 값으로 비교하면 아래 비교문이 모두 true
    val b = a    // Int 형으로 추론된다.
    println(a == b)   // 2개의 값이 같기 때문에 true가 나온다.
    println(a === b)  // true

    val c: Int? = a
    val d: Int? = a
    val e: Int? = c
    // c와 d는 기본적으로 객체가 된다.
    // 하지만 기본적으로 객체가 되기 때문에 동적 공간에 존재하고, 주소를 가리키기 때문에 값만 똑같고 위치는 다르다.
    // 의문인 점 : String은 String pool이 있어서 객체여도 같은 결과가 나오고, Int는 아니라서 ===를 쓰면 false가 나오는가?
    println("a를 참조하는 두 값끼리 참조")
    println(c == d)
    println(c === d)   // 값은 같지만 참조 주소는 다르다.
    println("a를 직접 넣어 비교한다면")
    println(a === c)
    println(a === d)

    // e가 c가 가리키는 공간을 그대로 참조하고 있기 때문에 true
    println(c === e)

    // null을 허용해도 true
    var str1: String? = "Hello"
    var str3: String? = "Hello"
    println("str1 === str3: ${str1 === str3}")   // 값도 같고 참조 주소도 같다.

    val aa: Int? = 127
    val bb: Int? = 127
    println(aa === bb)   // 이건 또 true라네..?
    // 자주 사용하는 1byte 정수에 대해서는 내부적으로 싱글톤 처리를 하기 때문에 같은 객체를 참조한다!
    // refer: https://lannstark.tistory.com/144
    // Java에서도 돌려봐야겠다.
    /*
        그 이유는, Integer 형은 [-128. 127] 범위에서 캐싱하기 때문에 범위 내에 값이 있으면 새로운 인스턴스를 생성하지 않습니다.
        그러므로 Integer로 박싱될 때 a는 100이기 때문에 새로운 객체를 생성하지 않아, boxedA와 anotherBoxedA는 같은 객체를 가지게 되는 것입니다.
        반대로 캐싱되지 않은 boxedB와 anotherBoxedB는 다른 객체를 가져 false를 리턴하게 되는 것입니다.
        https://gwi02379.tistory.com/14
     */
    println(aa == bb)

}
```

- 일반적인 Int의 경우 내부적으로 기본형 int로 작동하기 때문에 val c: Int? = a와 val d: Int? = a를 ===로 비교하면 false
    - 자주 사용하는 1바이트 숫자의 경우 내부적으로 싱글톤으로 동작하여 새로 객체를 생성하지 않기 때문에 true를 반환한다.
    - 추가적으로 a와 직접 비교하면 true가 나온다.
- **그런데, val a: Int? = 128인 경우는 위의 비교 결과가 어떤 값이든 삼중 비교로 true가 나온다.**
    - 기본형이면 stack, 참조형 Heap
    - ?를 붙이면 객체형 Integer로 동작하고, 안 붙이면 기본형 int로 동작한다.
    - Int? = 128 로 선언하면 이 변수가 객체가 되기 때문에 그 객체를 참조해 어떤 값이든 삼중 비교로 true가 나온 것
    - 하지만 Int = 128로 선언하면 각 객체에 해당 값이 들어가고, 거기에 따라 새로운 객체가 생성되기 때문에 값은 같을지라도 참조 주소가 다르므로 false
- String은 String pool 때문에 같은 값을 가지면 nullable이라도 true가 나온다.
- Java Boxing에 대해 더 공부하기
- [과제] Java에서도 돌려보고 결과를 봅시다.
