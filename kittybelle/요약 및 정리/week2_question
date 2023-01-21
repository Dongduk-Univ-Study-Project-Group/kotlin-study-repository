## [질문 1] toDouble()의 위치에 따른 밑줄

```kotlin
val avg = (result / numbers.size).toDouble() 이렇게 하면 밑줄 생기고
        return avg

val avg = result / numbers.size
        return avg.toDouble() // 리턴할 때 쓰면 밑줄 없어짐
```

<aside>
💡 더욱 좋은 코드를 위한 밑줄로, **변수 avg를 return할 때만 사용하니까** 리턴할 때 toDouble로 형변환을 해주는 것이 좋다.

</aside>

- **인라인 함수**와 연관
- 자바로 컴파일 할 때 함수가 자동으로 객체 생성하니까 무의미한 객체 생성을 줄이기 위해서 밑줄 알림
- 이 변수는 리턴할 때만 쓴다 → 올바른 코드를 자바로 디컴파일해보니 avg가 생성 안됐다. 즉, avg 객체 생성 유무에 따라 무의미한 객체 생성과 메모리 차지를 줄이기 위한 것으로 보임
- 리턴할 때만 쓰지 않고, 출력 등 다른 작업을 할 때 사용해주면 똑같이 변수 선언 시 형변환을 해도 밑줄이 뜨지 않는다
    
    ```kotlin
    val avg = (result / numbers.size).toDouble()
    println(avg)
            return avg
    ```
    

---

## [질문 2] 일급 객체가 함수일 수도 있다?

```kotlin
// 함수의 인자로 전달 가능 ← 일급 객체가 함수일 수도 있다.
// 객체가 함수가 될 수 있는지에 대한 이해가 잘 되지 않음
```

<aside>
💡 말그대로 1급 객체를 1급 함수로 취급할 수 있다는 의미.

</aside>

- 객체 지향 프로그래밍(OOP)가 아닌, 함수형 프로그래밍의 특징
- 코틀린에서 함수는 1급 객체(1급 함수)로 다룬다.
- 자바에서는 함수를 변수에 담는 등 조건을 충족하지 못하기 때문에 불가능
- 일급 객체의 정의는 확실히 암기할 것!

---

## [질문 3] 다른 함수의 참조 파트에서 참조 관계

```kotlin
fun sum(x: Int, y: Int) = x + y

funcParam(3, 2, sum) // 오류!! sum은 람다식이 아님
...
fun funcParam(a: Int, b: Int, c: (Int, Int) -> Int): Int {
		return c(a, b)
}

funcParam(3, 2, ::sum) // 올바른 표현

// sum을 람다식 형태로 참조한다는 말이 잘 이해되지 않음
```

<aside>
💡 **람다식 자체는 아니지만 람다처럼 쓰고 싶으면** 참조할 수 있게 해주는 것

</aside>

- sum은 람다가 아니라서 이름으로 호출 불가능!
- c: (Int, Int) -> Int 람다식 형태로 선언돼있지만 함수 이름을 쓰고 싶다면? 
→ :: 컬럼 2개를 사용해야 함

---

## [질문 4] 2. 인자가 없는 함수에서 :: 쓰는 이유

```kotlin
fun main() {
    // 1. 인자와 반환값이 있는 함수
    val res1 = funcParam(3, 2, ::sum)
    println(res1)

    // 2. 인자가 없는 함수
    hello(::text) 
		// 반환값이 없음, 람다식이 아닌데 ::이 붙는 이유는?

    // 3. 일반 변수에 값처럼 할당
    val likeLambda = ::sum
    println(likeLambda(6,6))
}

fun sum(a: Int, b: Int) = a + b

fun text(a: String, b: String) = "Hi! $a $b"

fun funcParam(a: Int, b: Int, c: (Int, Int) -> Int): Int {
    return c(a, b)
}

fun hello(body: (String, String) -> String): Unit {
    println(body("Hello", "World"))
}
```

<aside>
💡 함수 호출 관계랑 흐름 잘 보기!
hello의 매개변수에 (body: (String, String) -> String)가 있고,
text의 매개변수에 (a: String, b: String)가 있고,
hello에서 println(body("Hello", "World"))으로 문자열을 넣어줬음.

</aside>
