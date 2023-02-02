## if문과 if-else문

```kotlin
var max = a
if (a < b)
	max = b  // 수행할 문장이 한 줄이면 중괄호를 생략할 수 있다.
```

### if-else 문의 간략화

```kotlin
var max: Int
if (a > b)
	max = a
else
	max = b
```

```kotlin
val max = if (a > b) a else b
```

- 변수 선언 시 할당문 사용
- [의문] 자바도 가능한가?

### 블록과 함께 사용하는 경우

```kotlin
fun main() {
	val a = 12
	val b = 7

	// 블록과 함께 사용
	val max = if (a > b) {
		println("a 선택")
		a    // 마지막 식인 a가 반환되어 max에 할당
	} else {
		println("b 선택")
		b   // 마지막 식인 b가 반환되어 max에 할당
	}

	println(max)
}
```

- 반환된다고 해서 return을 사용하는 것은 아니다.

### else if문으로 조건문 중찹하기

```kotlin
val number = 0
val result = if (number > 0)
			"양수 값"
		else if (number < 0)
			"음수 값"
		else
			"0"
```

- 마지막은 else 로 구성된다.

## in 연산자와 범위 연산자로 조건식 간략하게 만들기

### 비교 연산자와 논리 연산자의 복합

- …} else if (score ≥ 80.0 && score ≤ 89.9) {…
- 비교 연산자(≥, ≤)와 논리곱 연산자(&&) 가 사용

### 범위(range) 연산자

- 변수명 **in** 시작값..마지막값
- score in 80..89이면 score 범위에 80부터 89까지 포함

## when문으로 다양한 조건 처리

### 인자를 사용하는 when

```kotlin
when (x) {
	// 인자에 일치하는 값 혹은 표현식 -> 수행할 문장
	// 인자에 일치하는 범위 -> 수행할 문장
	1 -> print("x == 1")
	2 -> print("x == 2")
	else -> {    // 블록 구문 사용 가능
		print("x는 1, 2가 아닙니다.")
	}
}
```

- when 구문은 **다른 언어에서 흔히 사용되던 switch-case를 대체하는 코틀린에서만 제공되는 문법**이다.

### 일치되는 여러 조건

```kotlin
when (x) {
	0, 1 -> print("x == 0 or x == 1")
	else -> print("기타")
}
```

### 함수의 반환값 사용하기

```kotlin
when (x) {
	**parseInt(s)** -> print("일치함!")
	else -> print("기타")
}
```

### in 연산자와 범위 지정자 사용

```kotlin
when (x) {
	in 1..10 -> print("x는 1이상 10이하입니다.")
	!in 10..20 -> print("x는 10이상 20 이하의 범위에 포함되지 않습니다.")
	else -> print("x는 어떤 범위에도 없습니다.")
}
```

### is 키워드 함께 사용하기

```kotlin
val str = "안녕하세요."
val result = when(str) {
	is String -> "문자열입니다."
	else -> false
}
```

- is 키워드로 특정 자료형을 조사할 수 있다.

### 인자가 없는 when

```kotlin
when {
	조건[혹은 표현식] -> 실행문
}
```

- 특정 인자에 제한하지 않고 다양한 조건을 구성할 수 있다.

## for문

```kotlin
for (x in 1..5) {   // 코틀린의 in과 범위 지정을 활용한 루프
	println(x)   // 본문
}

for (x in 1..5) println(x)   // 한 줄에 표현하는 경우
```

- 기본으로 1씩 증가하며 반복한다.
- 자바처럼 세미콜론 표현식을 사용하지 않는다.

### 1부터 10까지 더하는 예제

```kotlin
fun main() {
	var sum = 0
	
	for (x in 1..10) sum += x

	println("sum: $sum")
}
```

### 하행, 상행 반복 for문

- 하행 반복(downTo)
    
    ```kotlin
    for (i in 5 downTo 1) print(i)  // 5, 4, 3, 2, 1
    for (i in 5..1) print(i)   // 잘못된 사용! 아무것도 출력되지 않음
    ```
    
    - default로는 증가하기 때문에 5..1은 오류가 발생한다.
- 필요한 단계 증가(step)
    
    ```kotlin
    for (i in 1..5 step 2) print(i)   // 1, 3, 5
    ```
    
- 혼합 사용
    
    ```kotlin
    for (i in 5 downTo 1 step 2) print(i)   // 5, 3, 1
    ```
    

## while 문

```kotlin
var i = 1
while (i <= 5) {   // 조건식이 true인 동안 본문의 무한 반복
	println("$i")
	++i  // 계속 반복하다면 조건식이 5 이상으로 넘어갈 때 false가 되어 탈출
}
```

### 데몬 프로그램의 사용 예

```kotlin
while (true) {
	temp = 온도 검사
	if (temp > 한계 온도) { 경고 발생 }
}
```

- 데몬이란 죽지않고 백그라운드에서 지속적으로 수행되는 프로그램
- 해당 프로그램은 죽지 않고 무한 반복해야하기 때문에 true로 무한 반복

### while을 활용한 팩토리얼 계산하기

```kotlin
fun main() {
	print("Enter the number: ")
	var number = readLine()!!.toInt()
	var factorial: Long = 1

	while (number > 0) {  // n x ... x 4 x 3 x 2 x 1
		factorial *= number
		--number
	}

	println("Factorial: $factorial")
}
```

## do-while문

```kotlin
do {
	본문
} while (조건식)
```

## 흐름 제어

### 흐름 제어문

- return: 함수에서 결괏값을 반환하거나 지정된 라벨로 이동
- break: for나 while의 조건식에 상관없이 반복문을 끝낸다.
- continue: for나 while의 반복문의 본문을 모두 수행하지 않고 다시 조건으로 넘어간다.

### 예외 처리문

- try {…} catch {…}: try 블록의 본문을 수행하는 도중 예외가 발생하면 catch 블록의 본문을 실행
- try {…} catch {…} finally {…}: 예외가 발생해도 finally 블록 본문은 **항상 실행**

## return의 사용

### return으로 값 반환하기

```kotlin
fun add(a: Int, b: Int): Int {
	return a + b
	println("이 코드는 실행되지 않습니다.")  // return 아래 문장은 실행되지 않는다.
}
```

### return으로 Unit 반환하기

```kotlin
// 1. Unit을 명시적으로 반환
fun hello(name: String): Unit {
	println(name)
	return Unit   // 생략 가능
}

// 2. Unit 이름을 생략한 반환
fun hello(name: String): Unit {
	println(name)
	return
}

// 3. return 자체를 생략
fun hello(name: String) {
	println(name)
}
```

- Unit은 반환하는게 없긴 하지만 엄밀히 말해 Unit이라는 특수한 자료형을 반환
- 특수한 Unit 자료형은 어떠한 데이터 형으로도 반환하지 않음을 나타내는 특수한 기호
- return과 함수의 반환타입을 생략한다면 기본 return은 Unit 타입이 된다.

### 람다식에서 return 사용하기

```kotlin
fun main() {
	retFunc()
}

inline fun inlineLambda(a: Int, b: Int, out: (Int, Int) -> Unit) {
	out(a, b)
}

fun retFunc() {
	println("start of retFunc")
	inlineLambda(13, 3) {a, b ->
		val result = a + b
		if (result > 10) return   // 10보다 크면 이 함수를 빠져 나간다.
		println("result: $result")   // 10보다 크면 이 문장에 도달하지 못한다.
	}

	println("end of retFunc")
}
```

- 람다식 안에 있는 return은 람다식 밖으로 빠져나가는 것이 아니다.
    - 비지역 반환이 일어난다.
    - 즉, 바깥에 있는 함수(retFunc) 자체가 종료된다.
    - (비지역 반환에 대한 공부를 조금 더 해야할 것 같다.)

### 람다식에서 라벨 사용

```kotlin
fun main() {
	retFunc()
}

inline fun inlineLambda(a: Int, b: Int, out: (Int, Int) -> Unit) {
	out(a, b)
}

fun retFunc() {
	println("start of retFunc")
	inlineLambda(13, 3) lit@{a, b ->   // 람다식 블록의 시작 부분에 라벨을 지정한다.
		val result = a + b
		if (result > 10) return@lit   // 라벨을 사용한 블록의 끝부분으로 반환
		println("result: $result")
	}

	println("end of retFunc")   // 해당 구문이 실행된다.
}
```

- 만약 라벨과 함께 특정 값을 반환하려면 다음과 같이 표현할 수 있다.
    
    ```kotlin
    return@a 1
    ```
    

### 암묵적 라벨

```kotlin
fun retFunc() {
	println("start of retFunc")
	**inlineLambda**(13, 3) {a, b ->
		val result = a + b
		if (result > 10) return**@inlineLamdba** 
		println("result: $result")
	}

	println("end of retFunc")
}

```

- 함수의 이름이 암묵적 라벨이 된다.

### 익명 함수의 사용

```kotlin
fun retFunc() {
	println("start of retFunc")
	inlineLambda(13, 3, fun(a, b) {
		val result = a + b
		if (result > 10) return
		println("result: $result")
	})  // inlineLambda 함수의 끝

	println("end of retFunc")
}

```

- 람다가 아닌 일반 익명 함수를 사용한다.
- fun으로 시작하나 람다와 유사하다.
- 일반 함수는 비지역 반환이 일어나지 않기 때문에 라벨을 사용하지 않아도 return 시 함수가 정상 종료된다.
- return이 필요하면 람다보단 익명함수가 좋지만, 익명함수는 많이 쓰게 되면 어떤 원리로 이것을 사용하는지 혼란이 올 수 있다.

## 람다식과 익명 함수 사용

### 람다식 방법

```kotlin
val getMessage = lambda@ {num: Int ->
	if (num !in 1..100) {
		return @lambda "Error"  // 레이블을 통한 반환
	}

	"Success"   // 마지막 식이 반환
}
```

- 람다식의 마지막 식은 리턴 형태로 빠져나가기 때문
- 람다식 내부에는 리턴을 사용하지 않는다.

### 익명 함수 방법

```kotlin
val getMessage = fun(num: Int): String {
	if (num !in 1..100) {
		return "Error"
	}

	return "Success"
}

val result = getMessage(99)
```

## break, continue

- for나 while, do..while문의 루프를 빠져 나온다.

### 조건에 따른 break문 사용하기

```kotlin
package chap04.section03

fun main() {
	for (i in 1..5) {
		if (i == 3) **break**
		print(i)
	}

	println()
	println("outside")
}
```

- break를 사용할 경우 실행 결과
    
    ```
    12
    outside
    ```
    
- continue를 사용할 경우 실행 결과
    
    ```
    1245
    outside
    ```
    

### break와 라벨 함께 사용하기

- 라벨이 없는 경우
    
    ```kotlin
    fun labelBreak() {
    	println("labelBreak")
    	for (i in 1..5)
    		second@ for (j in 1..5) {
    			if (j == 3) break
    			println("i: $i, j: $j")
    		}
    		println("after for j")
    	}
    	println("after for i")
    }
    ```
    
    - 안 쪽에 있는 반복문을 빠져나간다.
    - 즉, 자신과 가장 가까운 반복문을 빠져나간다.
- 라벨이 있는 경우
    
    ```kotlin
    fun labelBreak() {
    	println("labelBreak")
    	**first@** for (i in 1..5)
    		second@ for (j in 1..5) {
    			if (j == 3) break**@first**
    			println("i: $i, j: $j")
    		}
    		println("after for j")
    	}
    	println("after for i")
    }
    ```
    
    - 라벨이 있는 제일 바깥의 반복문을 빠져나간다.
- continue를 사용할 때도 생각해보자.

## 예외 처리

### 예외(exception)

- 실행 도중의 잠재적인 오류까지 검사할 수 없기 때문에 정상적으로 실행 되다가 **비정상적으로 프로그램이 종료되는 경우**
    - 운영체제의 문제 (잘못된 시스템 호출의 문제)
    - 입력 값의 문제 (존재하지 않는 파일 혹은 숫자 입력란에 문자 입력 등)
    - 받아들일 수 없는 연산 (0으로 나누기 등)
    - 메모리의 할당 실패 및 부족
    - 컴퓨터 기계 자체의 문제 (전원 문제, 망가진 기억 장치 등)

### 예외 처리 구문

```kotlin
try {
	예외 발생 가능성이 있는 문장
} catch (e: 예외처리 클래스명) {
	예외를 처리하기 위한 문장
} finally {
	반드시 실행되어야 하는 문장
}
```

- 반드시 실행해야 할 작업이 없다면 finally 부분은 생략해도 된다.
- 예를 들어, 파일을 열고 작업하다가 예외 발생 시, finally 문에서 파일을 닫는 연산을 수행할 수 있다.

### 특정 예외 처리

- 산술 연산에 대한 예외를 따로 특정해서 잡을 때
    
    ```kotlin
    ...
    } catch (e: ArithmeticException) {
    	println("Exception is handled. ${e.message}")
    }
    ```
    
- 스택의 추적
    
    ```kotlin
    ...
    } catch (e: Exception) {
    	e.printStackTrace()
    }
    ```
    
    - 어떤 코드에서 예외가 발생했는지 더 자세히 알려준다.

### 특정 조건에 따른 예외 발생

```kotlin
throw Exception(message: String)
```

```kotlin
fun main() {
	var amount = 600
	
	try {
		amount -= 100
		checkAmount(amount)
	} catch (e: Exception) {
		println(e.message)
	}

	println("amount: $amount")
}

fun checkAmount(amount: Int) {
	if (amount < 1000) {
		throw Exception("잔고가 $amount 으로 1000 이하입니다.")
	}
}
```

## 퀴즈3

- 5번 문제
    - 코드를 중단하고 first@로 돌아가려면 second를 break해줘야하지 first를 break하면 안된다!