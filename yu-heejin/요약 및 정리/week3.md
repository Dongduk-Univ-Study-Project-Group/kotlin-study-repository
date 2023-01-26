## 람다식과 고차함수 호출하기

### 값에 의한 호출

- 함수가 인자로 전달될 경우
    - **람다식 함수는 값으로 처리**되어 그 즉시 함수가 수행된 후 값을 전달
    - 람다식의 경우 특정 함수의 인자로 전달받으면 그 해당 람다식 함수가 먼저 처리되어 값으로 전달된다.
    - 특정 인자가 호출될 때 람다식 함수가 존재하면 **그 함수가 즉시 수행되고, 나온 값을 전달한다.**
- 값에 의한 호출로 람다식 사용하기
    
    ```kotlin
    fun main() {
    	val result = callByValue(lambda())  // 람다식 함수 호출
    	println(result)
    }
    
    fun callByValue(b: Boolean): Boolean {    // 일반 변수 자료형으로 선언된 매개변수
    	println("callByValue function")
    	return b
    }
    
    val lambda: () -> Boolean = {    // 람다 표현식이 두 줄이다.
    	println("lambda function")
    	true    // 마지막 표현식 문장의 결과가 반환
    }
    ```
    
    ![KakaoTalk_Photo_2023-01-27-00-43-01.jpeg](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ed72878a-59ad-44eb-af52-f90fb0653418/KakaoTalk_Photo_2023-01-27-00-43-01.jpeg)
    

### 람다식 이름을 사용한 호출

```kotlin
fun main() {
	val result = callByValue(otherLambda)  // 람다식 이름으로 호출
	println(result)
}

fun callByValue(b: () -> Boolean): Boolean {    // 람다식 함수 자료형으로 선언된 매개변수
	println("callByName function")
	return b()
}

val otherLambda: () -> Boolean = {
	println("otherLambda function")
	true
}
```

- 이 경우 결과가 아니라 **람다식 형태가 통째로 들어가게 된다.**
- 람다식 자체가 매개변수에 복사되고, 해당 함수가 호출되어 사용되기 전까지는 람다식 함수가 실행되지 않는다.
- 즉, 함수 자체를 읽는다.
- 이 방식을 사용하면 상황에 맞춰 *즉시 실행할 필요가 없는 코드를 작성하는 경우 이름에 의한 호출 방법을 통해 필요할 때만 람다식 함수가 작동하도록 만들 수 있다.*

![KakaoTalk_Photo_2023-01-27-00-48-14.jpeg](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/47796cf7-a490-487a-86ba-0bb0e089278f/KakaoTalk_Photo_2023-01-27-00-48-14.jpeg)

### 다른 함수의 참조에 의한 호출

```kotlin
fun sum(x: Int, y: Int) = x + y

funcParam(3, 2, sum)    // 오류: sum은 람다식이 아니다.
...
fun funcParam(a: Int, b: Int, c: (Int, Int) -> Int): Int {
	return c(a, b)
}
```

- sum은 람다식 형태가 아니기 때문에 이름만으로는 사용할 수 없다.
    - sum(a, b)처럼 매개변수를 같이 넣어야한다.

```kotlin
funcParam(3, 2, ::sum)
```

- ::을 사용하면 일반 함수인 sum이 람다식의 매개변수, 반환 값과 일치하면 사용할 수 있도록 한다.
- 이러한 참조 방식을 사용하면 내부적으로 내용물을 람다식과 매칭하여 가져오게 된다.
- ::를 함수 이름 앞에 사용해 소괄호와 인자를 생략하고 사용하는 경우 일반 함수를 참조에 의한 호출로 사용할 수 있다.

## 람다식 함수의 매개변수

### 매개변수 개수에 따라 람다식을 구성하는 방법

- 매개 변수가 없는 경우
    
    ```kotlin
    fun main() {
    	// 매개변수가 없는 람다식 함수
    	noParam({"Hello World!"})
    	noParam {"Hello World!"}  // 위와 동일한 결과, 소괄호 생략 가능
    }
    
    // 매개변수가 없는 람다식 함수가 noParam 함수의 매개변수 out으로 지정된다.
    fun noParam(out: () -> String) = println(out())
    ```
    
- 매개변수가 한 개인 경우
    
    ```kotlin
    fun main() {
    	// 매개변수가 없는 람다식 함수
    	
    	// 매개변수가 하나 있는 람다식 함수
    	oneParam({a -> "Hello World! $a"})
    	oneParam {a -> "Hello World! $a"}   // 위와 동일한 결과, 소괄호 생략 가능
    	oneParam {"Hello World! $it"}   // 위와 동일 결과, it으로 대체 가능 (가장 축약된 형태)
    }
    
    // 매개변수가 하나 있는 람다식 함수가 oneParam 함수의 매개변수 out으로 지정된다.
    fun oneParam(out: (String) -> String) {
    	println(out("OneParam"))
    }
    ```
    
- 매개변수가 두 개 이상인 경우
    
    ```kotlin
    fun main() {
    	// 매개변수가 두 개 있는 람다식 함수
    	moreParam {a, b -> "Hello World! $a $b}    // 매개변수명 생략 불가능
    }
    
    // 매개변수가 두 개 있는 람다식 함수가 moreParam 함수의 매개변수로 지정된다.
    fun moreParam(out: (String, String) -> String) {
    	println(out("OneParam", "TwoParam"))
    }
    ```
    
    - 매개변수가 2개 이상인 경우 it으로 생략할 수 없다.
- 매개변수를 생략하는 경우
    
    ```kotlin
    moreParam {_, b -> "Hello World! $b"}   // 첫 번째 문자열은 사용하지 않고 생략
    ```
    
    - _ : 첫번째 인자는 생략하고 두번째 인자만 사용하겠다는 의미

### 일반 매개변수와 람다식 매개변수를 같이 사용

```kotlin
fun main() {
	// 인자와 함께 사용하는 경우
	withArgs("Arg1", "Arg2", {a, b -> "Hello World! $a $b})
	// withArgs()의 마지막 인자가 람다식인 경우 소괄호 바깥으로 분리 가능
	withArgs("Arg1", "Arg2") {a, b -> "Hello World! $a $b}
}

// withArgs 함수는 일반 매개변수 2개 포함. 람다식 함수를 마지막 매개변수로 가진다.
fun withArgs(a: String, b: String, out: (String, String) -> String) {
	println(out(a, b))
}
```

- 다만, **람다식이 매개변수 앞에 있는 경우는 소괄호 바깥으로 분리할 수 없다.**

## 두 개의 람다식을 가진 함수의 사용

```kotlin
fun main() {
	twoLambda({a, b -> "First $a $b"}, {"Second $it})
	twoLambda({a, b -> "First $a $b"}) {"Second $it}   // 마지막 식만 바깥으로 분리할 수 있다.
}

fun twoLambda(first: (String, String) -> String, second: (String) -> String) {
	println(first("OneParam", "TwoParam"))
	println(second("OneParam"))
}
```

## 익명 함수(anonymous functions)

- 함수가 이름이 없는 것
    
    ```kotlin
    fun (x: Int, y: Int): Int = x + y   // 함수 이름이 생략된 익명 함수
    
    val add: (Int, Int) -> Int = fun(x, y) = x + y    // 익명 함수를 사용한 add 선언
    val result = add(10, 2)    // add의 사용
    
    val add = fun(x: Int, y: Int) = x + y
    val add = {x: Int, y: Int -> x + y}    // 람다식과 매우 흡사
    ```
    
- 익명 함수는 일시적으로 어떤 루틴이 필요할 경우 사용한다.
- 일반 익명 함수에서는 return, break, continue 사용이 가능하지만, 람다식에서는 사용이 어렵다.
    - 라벨 표기법과 같이 사용해야한다.
    - [의문] 라벨 표기법이란?

## 인라인 함수 (inline function)

![KakaoTalk_Photo_2023-01-27-01-38-43.jpeg](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7a00993a-5334-4b55-98fd-350c72295a7d/KakaoTalk_Photo_2023-01-27-01-38-43.jpeg)

- 함수가 호출되는 곳에 내용을 모두 복사
    - 함수가 호출되는 곳에서 해당 함수로 들어가 일을 처리하는 것이 아니라, 함수 안에 해당 코드를 직접 복붙하는 것
- 함수의 분기 없이 처리 → 성능 증가
    - 함수 내부로 들어가지 않기 때문에 분기하는 오버헤드 감소
- 다만 인라인 함수의 내용이 너무 길어지면 코드 양이 커질 수 있다.
    - 인라인 함수는 코드가 복사되어 들어가기 때문에 대개 내용은 짧게 작성한다.
- 인라인 함수는 람다식 매개변수를 가지고 있는 함수 형태를 권장한다.

[의문] inline을 붙였는데 분기하는 이유는?

![스크린샷 2023-01-27 오전 1.46.26.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4fa2f75f-f0d8-40ff-a335-562e8ca7fe09/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2023-01-27_%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB_1.46.26.png)

### 인라인 함수의 제한과 인라인 금지

- 인라인 함수의 단점
    - 코드가 복사되기 때문에 내용이 많은 함수에 사용하면 코드가 늘어난다.
- noinline 키워드
    - **일부 람다식 함수를 인라인 되지 않게 하기 위함**
        
        ```kotlin
        inline fun sub(out1: () -> Unit, noinline out2: () -> Unit)
        ```
        
        - out1, out2 모두 람다식이기 때문에 함수가 전달되면 inline이기 때문에 모두 복사된다.
        - noinline을 사용하면 out2는 함수를 펼치지(?) 않고 그대로 둔다.
        - noInline 키워드를 람다식 함수 매개변수 정의에서 사용하면 기본적으로 람다식 함수를 매개변수로 가진 해당 함수가 inline으로 정의되어 있다고 하더라도 사용할 때 람다식 함수를 inline 시키지 않는다.
        - noInline 함수는 인라인으로 처리되지 않고 분기하여 호출된다.

## 확장 함수 (Extension Function)

- **클래스의 멤버 함수를 외부에서 더 추가할 수 있다.**
    
    ```kotlin
    fun 확장대상.함수명(매개변수, ...): 반환값 {
    	...
    	return 값
    }
    ```
    
    - 클래스의 특정 멤버 함수를 추가하려면 클래스를 수정해야하는데, 이 외에도 **원본 라이브러리를 수정하지 않고 멤버 함수를 확장 함수를 통해 수정할 수 있다.**

### String에 확장 함수 추가하기

```kotlin
fun main() {
	val source = "Hello World!"
	val target = "kotlin"
	println(**source**.getLongString(**target**))
}

// String을 확장해 getLongString 함수 추가
fun String.getLongString(target: String): String = 
	if (this.length > target.length) this else target
```

- **this는 확장 대상에 있던 자리의 문자열인 source 객체**를 나타낸다.
- 기존의 표준 라이브러리를 수정하지 않고도 확장

## 중위 함수

### 중위 표현법(infix notation)

- 클래스의 멤버 호출 시 사용하는 점(.)을 생략하고 함수 이름 뒤에 소괄호를 생략해 직관적인 이름을 사용할 수 있는 표현법
    - 보통 Int.toString()의 형태를 사용해 함수를 사용한다.
    - 이때 .과 ()를 생략해서 사용할 수 있는데, 이것이 중위 표현법
    - 모든 함수가 사용 가능한 것은 아니다.
- 중위함수의 조건
    - 멤버 메서드 또는 확장 함수여야 한다.
    - 하나의 매개변수를 가져야 한다.
    - infix 키워드를 사용하여 정의한다.

### 중위 함수 사용 예시

```kotlin
fun main() {
	// 일반 표현법
	val multi = 3.multiply(10)

	// 중위 표현법
	val multi = 3 multiply 10
	println("multi: $multi")
}

// Int를 확장해서 multiply() 함수가 하나 더 추가되었다.
infix fun Int.multiply(x: Int): Int {  // infix로 선언되므로 중위 함수
	return this * x
}
```

## 꼬리 재귀 함수

### 재귀(recursion)란

- 자기 자신을 다시 참조
- 재귀 함수는 자기 자신을 계속 호출하는 특징
- 만약 재귀에 빠져나오지 못하고 계속 호출만 하게 되면 무한 재귀에 빠진다.
    - 스택 프레임이 증가 → 메모리 증가 → 스택 오버플로우 발생

### 재귀 함수의 필수 조건

- 무한 호출에 빠지지 않도록 탈출 조건을 만들어 둔다.
- 스택 영역을 이용하기 때문에 호출 횟수를 무리하게 많이 지정해 연산하지 않는다.
- 코드를 복잡하지 않게 한다.
    - 코드가 너무 복잡하면 어디서 디버깅해야하는지 알 수 없다.

### 꼬리 재귀 함수(tail recursive function)

- 스택에 계속 쌓이는 방식이 함수가 계속 씌워지는 꼬리를 무는 형태
- 자기 자신을 참조하는 것이 아니라 서로 참조
    - f() ↔ f()
- 코틀린 고유의 tailrec 키워드를 사용해 선언
- 스택이라는 것의 분기가 없다. 복사된 내용을 계속 사용하기 때문에 꼬리 재귀 함수
    - 따라서 꼬리 재귀 함수를 통해 스택 오버플로우 현상을 해결할 수 있다.

### 일반적인 factorial 재귀 함수 만들기

```kotlin
fun main() {
	val number = 4
	val result: Long

	result = factorial(number)
	println("Factorial: $number -> $result")
}

fun factorial(n: Int): Long {
	// 재귀 부분
	return if (n == 1) n.toLong() else n * factorial(n-1)
}
```

### 꼬리 재귀로 스택 오버플로우 방지하기

- **스택을 사용하지 않는다.**
- 계속 덮어 씌우는 방식이기 때문!

```kotlin
fun main() {
	val number = 5
	println("Factorial: $number -> ${factorial(number)}")
}

**tailrec** fun factorial(n: Int, run: Int = 1): Long {
	return if (n == 1) run.toLong() else factorial(n-1, run*n)  // 실행 수치도 같이 넘겨준다.
}
```

## 함수의 실행 블록

### 함수의 블록({})

- 블록 내에서 사용하는 변수 - 지역 변수(Local variable)

### 함수의 범위(Scope)

- 최상위 함수와 지역 함수
    
    ```kotlin
    fun main() {   // 최상위 레벨의 함수
    	fun secondFunc(a: Int) {    // 지역 함수 선언
    		...
    	}
    	userFunc(4)    // 사용자 함수 사용 - **선언부의 위치에 상관 없이 사용**
    	secondFunc(2)   // 지역 함수 사용 - **선언부가 먼저 나와야 사용 가능**
    }
    
    fun userFunc(counts: Int) {    // 사용자가 만든 최상위 레벨의 함수 선언
    	...
    }
    ```
    
    - 최상위 함수는 어디서든 호출하여 사용할 수 있다.
    - 지역 함수는 최상위 함수는 아니다. **지역 함수는 앞쪽에 먼저 선언이 되어 있어야만 사용 가능하다.**

### 최상위 및 지역 함수의 사용 범위

- 최상위 함수는 main() 함수 전, 어디든 선언하고 코드 내에서 호출 가능하다.
- 지역 함수는 먼저 선언되어야 그 함수를 호출할 수 있다.

```kotlin
fun a() = b()  // 최상위 함수이므로 b() 함수 선언 위치에 상관 없이 사용 가능
fun b() = println("b")     // b() 함수의 선언 (최상위 함수)

fun c() {
	fun d() = e()    // 오류: d()는 지역함수이며 e()의 이름을 알 수 없음
	**fun e() = println("e")**
}

fun main() {
	a()     // 최상위 함수는 어디서든 호출될 수 있다.
	e()    // 오류: c() 함수에 정의된 e()는 c의 블록({})을 벗어난 곳에서 사용할 수 없다.
}
```

[의문] 지역 함수와 인라인 함수의 차이점?

## 변수의 범위

### 전역 변수

- 최상위에 있는 변수로 프로그램이 실행되는 동안 **삭제되지 않고 메모리에 유지**
    - 패키지 내에서 접근이 가능하다.
    - 만약 다른 패키지에서 접근하고자 한다면 패키지 이름과 해당 요소를 적어주어야한다.
    - [의문] 어떤 메모리를 사용하는가?
- 여러 요소가 동시에 접근하는 경우에 잘못된 동작을 유발할 수 있다.
    - 코드가 길어지면 여러 요소가 동시에 접근하는 경우에 잘못된 동작을 유발할 수 있다.
- 자주 사용되지 않는 전역 변수는 메모리 자원 낭비

### 지역 변수

- 특정 코드 블록 내에서만 사용
- 블록 시작 시 임시로 사용되며 주로 **스택 메모리**를 사용한다.

## [퀴즈] 3장 마법의 요술상자, 함수의 기본

- 함수가 호출될 때마다 함수의 정보는 스택 메모리에 쌓이며, 프레임 정보로 부를 수 있다.

## [퀴즈] 4장 요술상자, 함수 가지고 놀기

- 람다식 매개변수에 타입을 붙여야한다.
    - {x, y → x * y}   // 해당 형태는 자료형을 추론할 수 없다
    - {x: Int, y: Int → x * y}
- 람다식 매개변수 사용
    
    ```kotlin
    fun more(out: (String) -> String) {
    	println(out("Hello"))
    }
    
    more(a -> "$a Kotlin")
    more {"$it Kotlin"}
    ```
    

## if문과 if-else문

```kotlin
var max = a
if (a < b)
	max = b  // 수행할 문장이 한 줄이면 중괄호를 생략할 수 있다.
```

### if 문을 활용한 값 할당

```kotlin
val max = if (a > b) a else b
```

### 블록과 함께 사용하는 경우

```kotlin
fun main() {
	val a = 12
	val b = 7

	val max = if (a > b) {
		println("a 선택")
		a
	}
	else {
		println("b 선택")
		b
	}

	println(max)
}
```

- 반환된다고 해서 return을 사용하는 것은 아니다.