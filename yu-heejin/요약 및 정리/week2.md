## 기본 연산자

- 산술, 대입, 증가, 감소, 비교, 논리 연산자 등

## 증가 연산자와 감소 연산자

```kotlin
fun main() {
	var num1 = 10
	var num2 = 10
	val result1 = ++num1   // num 값 증가 후 대입
	val result2 = num2++   // 먼저 num 값 대입 후 증가

	println("result1: $result1")
	println("result2: $result2")
	// 후위 증가이든 전위 증가이든 어쩄든 위에서 증가를 했기 때문에 아래 값은 같다.
	println("num1: $num1")
	println("num2: $num2")
}
```

## 비교 연산자

![KakaoTalk_Photo_2023-01-20-00-31-33.jpeg](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b12caade-67e1-41f1-9178-7f41f0478d07/KakaoTalk_Photo_2023-01-20-00-31-33.jpeg)

- == : 값이 같을 때 true, else false
- === : 항의 참조가 같을 때 true, else false

## 논리 연산자

```kotlin
var check = (5>3) && (5>2)  // 두 개의 항이 모두 참이면 true
check = (5>3) || (2>5)   // 2개 중 한 개의 항이 참이면 true
check = !(5>3)  // true -> false, false -> true
```

## 비트 연산자

![KakaoTalk_Photo_2023-01-20-00-37-06.jpeg](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/847ca4a7-2565-4036-b1b8-bcec01e31fd8/KakaoTalk_Photo_2023-01-20-00-37-06.jpeg)

![KakaoTalk_Photo_2023-01-20-00-39-24.jpeg](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a0c34744-e569-40bc-bf11-8f0994ebb698/KakaoTalk_Photo_2023-01-20-00-39-24.jpeg)

- 마치 숫자에 .을 사용하여 해당 멤버에 접근하는 함수 형태로 사용된다.
- 연산자처럼 사용하려면 중위 표현법을 사용할 수 있다.
    - 4.shl(3) = 4 shl 3
    - 다른 연산자는 해당 표현법으로 표현할 수 있지만, inv()는 불가능하다.
- shl은 왼쪽으로, shr은 오른쪽으로 밀어낸다.
- 논리합 : 둘중에 하나라도 1이면 1
- 논리곱 : 둘 다 1이여야 1
- xor (배타적 연산) : 두 비트가 서로 다를 경우에만 1

---

## 함수의 선언

```kotlin
fun sum(a: Int, b: Int): Int {
	var sum = a + b
	return sum
}

// []는 생략 가능하다는 의미
// 코틀린에서 void는 Unit (반환되지 않는 경우)
fun 함수 이름([변수 이름: 지료형, 변수 이름: 자료형...]): [반환 값의 자료형] {
	표현식
	[return 반환값]
}
```

- fun main() 도 함수이다. (프로그램의 시작점)

## 간략화된 함수

```kotlin
fun sum(a: Int, b: Int): Int = a + b
// 인자가 Int 형이기 떄문에 반환 형태를 추론할 수 있다.

// 반환 자료형 생략
fun sum(a: Int, b: Int) = a + b
```

## 함수와 스택 프레임 이해하기

![KakaoTalk_Photo_2023-01-20-01-41-07.jpeg](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e1872639-82b0-4ae5-89b7-74f5f78dfdb1/KakaoTalk_Photo_2023-01-20-01-41-07.jpeg)

- 프로그램을 구동하면 임시적으로 사용하는 Stack 메모리, 동적 메모리 공간인 Heap 존재
    - 힙은 낮은 주소에서 높은 주소로 점점 증가하고, 스택은 높은 주소에서 낮은 주소로 감소한다.
- 진입점에 들어가게 되면 main() 의 인자를 우선 살펴본다.
    - args가 없는 경우 0이 저장된다.
- 스택에는 메인 함수 프레임이 제일 먼저 만들어지고, 그 프레임 안에는 지역변수, 항, 스택 등이 정의된다.
    - 지역 변수는 동적 공간인 스택에 만들어진다. (임시 사용)
- max()가 호출되는 경우 max() 의 프레임이 스택에 쌓이고, 마찬가지로 프레임 안에 매개변수 등이 들어간다.
    - 인자로 num1, num2를 받고, 처리한 후 저장되어있던 변수들이 pop되면서 사라진다.
    - 그 후 max() 함수 역시 pop되면서 사라진다.
- 함수를 사용할수록 프레임이 스택에 계속 쌓이고, 사용 완료되면 pop되면서 사라진다.

## 생각해보기

- 코틀린은 따로 클래스를 만들지 않아도 함수를 생성할 수 있다.
    - 클래스의 멤버가 아닌 파일에서 직접 작성되는 함수는 최상위 함수로 이름을 어디서든 참조할 수 있기 때문이다.
    - 이러한 함수는 메모리에서 고정적으로 존재한다.
- 반면, 지역 함수는 특정 블록 내에서만 생명주기를 갖고 있기 때문에 블록을 벗어나면 해당 함수는 존재할 수 없다.
    - 이때는 블록 내에서 반드시 먼저 함수 선언을 가지고 있어야만 해당 이름의 함수를 이후에 사용할 수 있게 된다.
    - 그렇다면 함수뿐만 아니라 함수 내부에서 선언된 변수들도 임시 메모리인 스택에 쌓이고, 일정 생명주기를 가지게 된다.
- 지역 변수의 사용은 속도도 연관이 있다.
    - 전역 변수는 메모리의 데이터 영역에 위치하고, 지역 변수는 메모리 스택 영역에서 처리 가능하다.
    - 프로그램의 모든 메모리가 캐쉬 영역에서 구동하기는 힘들기 때문에 전역 변수가 자주 호출되는 것보다 지역변수가 자주 호출되는 것이 성능적으로도 효율이 좋다.

## 함수형 프로그래밍

### 코틀린은 다중 패러다임 언어

- 함수형 프로그래밍 (FP: Functional Programming)
- 객체 지향 프로그래밍 (OOP: Object-Oriented Programming)

### 함수형 프로그래밍

- 코드가 간략하고 테스트나 재사용성 증가 (함수의 이점)
- **람다식, 고차 함수를 사용해 구성**
    - 함수형 프로그래밍의 대표적인 특징
- 순수 함수

## 순수 함수 (pure function)

### 순수 함수의 이해

- 부작용이 없는 함수
    - **동일한 입력 인자에 대해서는 항상 같은 결과를 출력 혹은 반환**한다.
    - 즉, 입력이 똑같으면 출력도 항상 똑같다.
    - 값이 예측 가능해 결정적이다. (deterministic)
- 순수 함수의 예
    
    ```kotlin
    fun sum(a: Int, b: Int): Int {
    	return a + b.  // 동일한 인자인 a, b를 입력 받아 항상 a + b를 출력 (부작용이 없다)
    }
    ```
    

### 순수 함수의 조건

- **같은 인자에 대해 항상 같은 값**을 반환
- **함수 외부의 어떤 상태도 바꾸지 않는다.**

### 순수 함수가 아닌 것은?

```kotlin
fun check() {
	val test = User.grade()   // check() 함수에 없는 외부 User 객체 사용
	if (test != null) process(test)    // User.grade()의 실행 결과에 따라 달라진다.
}
```

- 인자가 없음에도 불구하고 외부 객체를 사용하는 경우
- 반환 값에 따라 처리 로직이 달라지기 때문에 의존 → 매번 실행 결과가 달라지는 경우

```kotlin
const val global = 10

fun main() {
	val num1 = 10
	val num2 = 3
	val result = noPureFunction(num1, num2)
	println(result)
}

fun noPureFunction(a: Int, b: Int): Int {
	return a + b + global  // 입력 값과 무관하게 외부의 변수 사용
}
```

- 만약 global의 값을 바꾼다면 로직이 똑같아도 값이 달라질 가능성이 존재한다.

### 순수 함수의 장점

- **입력과 내용을 분리하고 모듈화**하기 때문에 재사용성이 높아진다.
    - 여러가지 함수들과 조합해도 부작용이 없다.
- 특정 상태에 영향을 주지 않으므로 병행 작업 시 안전하다.
- 함수의 값을 추적하고 예측할 수 있기 때문에 테스트, 디버깅 등이 유리하다.

### 함수형 프로그래밍에 적용

- 함수를 매개변수, 인자 혹은 반환 값에 적용 (고차 함수)
    - 함수 자체를 매개변수, 인자, 반환값으로 사용할 수 있다.
- 함수를 변수나 데이터 구조에 저장
    - val abc = function()
    - 이 경우 함수의 이름을 abc로 지정할 수 있다.
- 유연성 증가

## 람다식 (Lambda Expression)

- 익명 함수의 하나의 형태로 이름 없이 사용 및 실행 가능
- 람다 대수로부터 유래
- 람다식의 예
    
    ```kotlin
    {x, y -> x + y}
    // 이름이 없는 람다식을 익명 함수로써 사용한다.
    // 하나의 변수처럼 사용할 수 있다.
    // -> 오른쪽에는 람다식의 결과
    ```
    
- 람다식은 고차 함수에서 인자로 넘기거나 결과값으로 반환 등을 할 수 있다.

## 일급 객체 (First Class Citizen) → 조금 더 공부해보기

- 일급 객체는 **함수의 인자로 전달**할 수 있다.
- 일급 객체는 **함수의 반환 값**에 사용할 수 있다.
- 일급 객체는 **변수에 담을 수 있다.**
- 코틀린에서 함수는 1급 객체로 다룬다.
    - 다른 말로 **1급 함수**라고도 한다.

## 고차 함수(high-order function) → 조금 더 공부해보기

```kotlin
fun main() {
	println(highFunc({x, y -> x + y}, 10, 20))   // 람다식 함수를 인자로 넘긴다.
}

fun highFunc(sum: (Int, Int) -> Int, a: Int, b: Int): Int = sum(a, b)  // sum 매개변수는 함수
```

![KakaoTalk_Photo_2023-01-20-02-57-18.jpeg](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/bfdf3a59-f8b0-40bc-80da-b5a8c7624155/KakaoTalk_Photo_2023-01-20-02-57-18.jpeg)

## 함수형 프로그래밍의 장점

- 프로그램을 **모듈화**해 디버깅하거나 테스트가 쉽다.
- 간략한 표현식을 사용해 생산성이 높다.
- 람다식과 고차함수를 사용하면서 다양한 함수 조합을 사용할 수 있다.

## 함수형 프로그래밍 정리

- 함수형 프로그래밍은 **순수 함수를 조합**해 상태 데이터 변경이나 부작용이 없는 루틴을 만들어내며 이름이 없는 함수 형태의 하나인 람다식을 이용해 함수를 변수처럼 매개변수, 인자, 반환값 등에 활용하는 고차함수를 구성해 생산성을 높인 프로그래밍 방법

---

## 람다식의 구성

```kotlin
fun main() {
  val result: Int

	val multi = {a: Int, b: Int -> a * b}   // 일반 변수에 람다식 할당
  result = multi(10, 20)   // 람다식이 할당된 변수는 함수처럼 사용 가능하다.
  println(result)
}
```

- 위 람다식 선언에서 매개변수의 자료형을 생략한다면 변수 뒤에다가 반환값의 자료형을 써주는 것이 좋다.

### 변수에 지정된 람다식

![KakaoTalk_Photo_2023-01-20-10-28-09.jpeg](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6d5fc264-6db5-490d-b07e-ec3b4eb5d368/KakaoTalk_Photo_2023-01-20-10-28-09.jpeg)

### 표현식이 두 줄 이상일 때

```kotlin
val multi2: (Int, Int) -> Int = {x: Int, y: Int ->
	println("x * y")
	x * y  // 마지막 표현식이 반환된다.
}
```

### 자료형의 생략

```kotlin
val multi: (Int, Int) -> Int = {x: Int, y: Int -> x * y}  // 생략되지 않은 전체 표현
val multi = {x: Int, y: Int -> x * y}   // 선언 자료형 생략
val multi: (Int, Int) -> Int = {x, y -> x * y}   // 람다식 매개변수 자료형의 생략

// 자료형이 아무것도 보이지 않는 경우
val multi = {x, y -> x * y}   // 오류! 자료형을 추론할 수 없다.
```

### 반환 자료형이 없거나 매개변수가 하나 있을 때

```kotlin
// 매개변수가 없는 경우 람다식도 화살표가 생략되어있는 것을 볼 수 있다.
val greet: () -> Unit = {println("Hello World!")}   // Unit 사용 (반환값 없음)
val square: (Int) -> Int = {x -> x * x}
```

### 람다식 안에 람다식이 있는 경우?

```kotlin
val nestedLambda: () -> () -> Unit = { { println("nested") } }
// 람다 안에 ()->Unit이라는 또 다른 람다를 넣음
```

### 선언부의 자료형 생략

```kotlin
val greet = { println("Hello World") }  // 추론 가능
// 매개변수도 없고 반환형태도 없기 때문에 () -> Unit 으로 추론 가능하다.
val square = { x: Int -> x * x }   // 선언 부분을 생략하려면 x의 자료형을 명시
val nestedLambda = { { println("nested") } }    // 추론 가능
```

### [추가] Unit 람다식 사용

```kotlin
val nestedLambda: () -> () -> Unit = { { println("nested") } }
// nestedLambda를 사용하려면 다음과 같이 선언
nestedLambda()()

val lambda: () -> Unit = { println("not nested") }
// 중첩되지 않은 람다를 사용하려면 다음과 같이 선언
lambda()
```

---

## 고차 함수와 람다식의 이해 (1)

### 매개변수에 람다식 함수를 이용한 고차 함수

```kotlin
fun main() {
	var result: Int

	// 람다식을 매개변수와 인자로 사용한 함수
	result = highOrder({x, y -> x + y}, 10, 20)
	println(result)
}

fun highOrder(sum: (Int, Int) -> Int, a: Int, b: Int): Int {
	return sum(a, b)
}
```

- 호출 동작
    
    ```kotlin
    result = highOrder({x, y -> x + y}, 10, 20)
    ```