## 람다식(Lambda Expression)

### 구성

- { 매개변수[,…] → 람다식 본문 }
    - 매개변수가 없을 경우 생략 가능
    - 람다식 본문이 길어질 경우 여러 줄로 작성하며, **가장 마지막 라인에 있는 값이 반환된다.**

### 사용 예

```kotlin
val sum: (Int, Int) -> Int = {x, y -> x + y}
val mul = {x: Int, y: Int -> x * y}
val add: (Int) -> Int = {it + 1}
```

- 람다식을 변수에 할당할 경우, 할당문을 통해 저장할 수 있다.
    - 만약 람다식 매개변수에 데이터형을 생략하고자 한다면, 변수의 선언부에 정확히 기록해야 한다.
    - 람다 내부에서 선언할 경우 선언부 생략 가능 (형식 추론 가능)
- 매개변수가 1개인 경우, 매개변수를 생략하고 it으로 표기할 수 있다.

### 여러 개의 식이 있는 경우

```kotlin
val isPositive: (Int) -> Boolean = {
	val isPositive = it > 0
	isPositive   // 마지막 표현식이 반환된다.
// 마지막 라인이 true 혹은 false로 정해져서 해당 값이 반환된다.
}

val isPositiveLabel: (Int) -> Boolean = number@ {
	val isPositive = it > 0
	return@number isPositive    // 라벨을 사용하여 반환된다.
}
```

- [의문] 내부에 같은 변수 이름을 사용할 수 있나..?

## 고차 함수(Higher-Order Function)

- 함수의 매개변수로 함수를 받거나 함수 자체를 반환할 수 있는 함수
    
    ```kotlin
    fun high(name: String, **body: (Int)->Int**): Int {
    	println("name: $name")
    	val x = 0
    	return body(x)
    }
    ```
    
    - body의 경우 일종의 익명 함수인 람다를 받고 있다.
    - 자바와의 차이점이라면 **자바는 함수 자체를 매개변수로 받는 것이 아니라 함수 처리 결과 값을 매개변수로 가진다!**

### 다양한 표현법

```kotlin
// 함수를 이용한 람다식
// 람다식 내부에는 구현부가 함수를 호출하고 있다.
val result = high("Sean", { x -> inc(x + 3) })

// 소괄호 바깥으로 빼내고 생략
val result2 = high("Sean") { inc(it + 3) }

// 매개변수 없이 함수의 이름만 사용할 때
// 일반 함수가 람다식과 동일한 구조를 가졌다면 ::를 통한 참조 방식 사용 가능
// 내부적으로 람다로 변환
val result3 = high("Kim", ::inc)

// 람다식 자체를 넘겨 준 형태
val result4 = high("Sean") {x -> x + 3}

// 매개변수가 한 개인 경우 생략
val result5 = high("Sean") {it + 3}

// 만일 일반 매개변수가 없고 람다식이 유일한 인자라면 다음과 같이 표현 가능
val result6 = highNoArg {it + 3}
```

- 참조형 방식으로 람다식이 아닌 일반 함수를 사용하려면 먼저 인자가 같을 때 사용할 수 있다.

## 클로저

```kotlin
fun main() {
	val calc = Calc()
	var **result** = 0   // 외부의 변수
	calc.addNum(2, 3) {x, y -> **result** = x + y}  // 클로저
	println(result)   // 값을 유지하며 5 출력
}

class Calc {
	// 람다식 add에는 반환값이 없다.
	fun addNum(a: Int, b: Int, add: (Int, Int) -> **Unit**) {
		add(a, b)
	}
}
```

- 람다식으로 표현된 내부 함수에서 **외부 범위에 선언된 변수에 접근**할 수 있는 개념
- 람다식 안에 있는 외부 변수는 **값을 유지하기 위해 람다가 포획(capture)한 변수**
- 위 코드의 경우 람다로 인해 외부 변수의 값이 변경되었다.
- 이러한 구조가 가능한 이유는 result라는 이름의 참조를 전부 감싸서 특수한 데이터 구조로 만들어 놓기 때문이다. (?)
- 기본적으로 함수 안에 정의된 변수는 로컬 변수로 스택에 저장되어 있다가 함수가 끝나면 같이 사라진다.
    - 하지만, **클로저 개념에서는 포획한 변수는 참조가 유지되어 종료되어도 사라지지 않고 접근하거나 수정할 수 있다.**
- result의 경우 람다식 내부에서 재할당되어 사용된다.
    - 이 때 할당된 값은 유지되어 출력문에서 사용할 수 있다.
    - 클로저에 의해 독립된 복사본을 가지고 사용되는 것
    - 값을 변경할 수 있는데 왜 독립된 복사본?

### 함수의 매개변수에 접근

```kotlin
fun filteredNames(length: Int) {
	val names = arrayListOf("kim", "Hong", "Go", "Hwang", "Jeon")
	val filterResult = names.filter **{**
		// filterName의 길이와 컬랙션의 길이를 비교
		it.length == length   // 바깥의 length에 접근
	**}**
	println(filterResult)
}
...
```

- 함수 자체를 같이 포획해 해당 매개변수에 접근한다.
- filter는 names에 있는 확장 함수이며, 람다식의 형태로 되어있다.
- 전반적으로 뭔 말인지 잘 모르겠다!

## 코틀린의 표준 라이브러리

![KakaoTalk_Photo_2023-02-11-18-50-46.jpeg](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/bc2a2a57-601f-42c5-ac5e-f91798f37da5/KakaoTalk_Photo_2023-02-11-18-50-46.jpeg)

- 람다식을 사용하는 코틀린의 표준 라이브러리에서 let(), apply(), with(), also(), run() 등 다양한 표준 함수를 제공하고 있다.
- 표준 함수들은 대략 확장 함수 형태의 람다식으로 구성되어 있다.
- T는 형식 매개변수 (자바의 제네릭이랑 비슷)
    - 어떤 타입이 오더라도 확장함수 형태로 사용
- this (곧바로 받기 - 자기 자신을 가리키기 때문에 참조형) or it (복사해서 받기)
- also, apply의 경우 호출자가 지정한 처리 루틴 결과를 반환한다.