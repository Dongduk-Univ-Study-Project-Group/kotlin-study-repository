# 코틀린 3주

## 4-3 다양한 함수의 출격1! (익명함수, 인라인 함수)

### 익명 함수

- 이름 없는 함수
    
    ```kotlin
    fun (x: Int, y: Int): Int = x + y
    ```
    
- 람다식 선언된 변수에 익명함수 할당하는 걸로 활용 가능
- **임시**로 사용할 때 유용함
    
    ```kotlin
    val add: (Int, Int) -> Int = fun(x, y) = x + y // 익명 함수를 사용한 add 선언
    val result = add(10, 2) // add 사용
    
    val add = fun(x: Int, y: Int) = x + y // 람다식과 유사
    
    ```
    
- **람다식에서는 return, break, continue 사용 어렵다.** (라벨 표기법:@사용과 같이 사용)

### 인라인 함수

- 함수가 호출되는 곳에 **내용을 모두 복사**
- 함수의 **분기 없이** 처리 → 성능 증가(분기 오버헤드 감소)
    
    ```kotlin
    sub() // 함수 내 본문 abc로 복사됨! 분기 처리되어 sub 호출하는게 아니라!
    
    inline fun sub(...) {
    	abc
    }
    ```
    
- 대신 코드량 증가할 수 있음

## 4-3 다양한 함수의 출격2! (익명함수, 확장 함수)

### 인라인 함수 단점

- 코드 복사 → 내용 많으면 코드량 많아짐
- **noinline** : 일부 람다식 함수 인라인 안되게 함

```kotlin
inline fun shortFunc(a: Int, out: (Int) -> Unit) {
    println("Hi")
    out(a)
    println("Bye")
}

// noinline으로 자바 디컴파일 하면 out.invoke가 그대로 남아있다. 펼쳐지지 않고!
//inline fun shortFunc(a: Int, noinline out: (Int) -> Unit) {
//    println("Hi")
//    out(a)
//}

fun main() {
    // shortFunc() // F7로 함수 프레임 확인 가능
    // inline으로 호출 시 별도의 프레임 생성되지 않음!

    shortFunc(3) {a ->  println("a: $a") }

    // 인자가 1개면 it으로 쓸 수 있음. {println("a: $it")}
    // return -> out과 함께 shortFunc라는 함수 자체도 빠져나가, 즉 비지역반환되어 Bye가 출력되지 않는다.
    shortFunc(3) {
        println("a: $it")
        return
    }

    // 비지역반환을 금지 -> out 앞 crossinline
}
```

### 확장함수

- 클래스의 특정 멤버 함수를 **원본 수정 없이** 외부에서 추가할 수 있음
- 형식 : fun **확장대상.함수명**
- **기존 표준 라이브러리를 수정없이 확장 가능**

```kotlin
fun main() {
    val source = "Hello World!"
    val target = "Kotlin"
    println(source.getLongString(target))
}

// String을 확장해 getLongString 추가
fun String.getLongString(target: String): String =
        if (this.length > target.length) this  else target

// this는 getLongString을 호출한 source를 나타낸다!
```

## 4-3 다양한 함수의 출격3! (중위함수, 꼬리재귀 함수)

### 중위 표현법

- 클래스 멤버 호출 시 사용하는 점(.) 생략 (ex: Int.toString())
- 함수 이름 뒤 소괄호 생략
- 직관적인 이름 사용 가능한 표현법
- **중위함수 조건**
    - **멤버 메소드** or **확장함수**여야 함
    - **하나의 매개변수**를 가져야 함
    - **infix** 키워드 사용하여 정의

```kotlin
fun main() {
    // 일반 표현법
    // val multi = 3.multiply(10)

    // 중위 표현법
    // 연산자처럼 사용하기 유용함
    val multi = 3 multiply 10
    println("multi: $multi")
}

// Int를 확장해서 multiply() 함수가 하나 더 추가되었음
**infix** fun Int.multiply(x: Int): Int {  // infix로 선언되므로 중위 함수
    return this * x
}
```

### 재귀 함수

- 재귀 : 자기 자신을 다시 참조
- 재귀 함수 조건
    - 무한 루프에 빠지지 않게 탈출 조건 만들기
    - **스택** 영역 이용 → 호출 횟수 많이 X
    - 코드 복잡하게 X
    

### 꼬리재귀 함수

- 스택에 계속 쌓이던 방식을 → **함수가 계속 덮어씌워지는**, 꼬리를 무는 형태로
- 분기가 없음, **스택을 사용하지 않음**
- 무한으로 호출해도 오버플로우 걱정은X
- 코틀린 고유의 **tailrec** 키워드로 선언

```kotlin
fun main() {
	val num = 5
	println("Factorial: $number -> ${factorial(num)}")
}

**tailrec** fun factorial(n: Int, run: Int = 1): Long {
	return if (n == 1) run.toLong() else factorial(n-1, run*n)
}
// **함수 프레임을 만들지 않고도** 자기 자신 덮어씌운다.
// 팩토리얼의 값을 그때 그때 계산하므로 **스택 공간을 낭비하지 않음**
// 일반 재귀함수보다 훨씬 안전한 코드
```

## 4-4 함수와 변수의 범위(Scope)

### 함수 실행 블록

- 지역 변수 : 블록 { } 내에서 사용
- 전역 변수 : 블록 외, 다른 함수에서도 사용 가능
- 최상위 함수 : main() 함수 전후 어디서든 사용 가능
- 지역 함수 : 선언 후 사용 가능

```kotlin
fun main() { // 최상위 레벨의 함수
    ...
    fun secondFunc(a: Int) { // 지역 함수 선언
        ... 
    }
    userFunc(4) // 사용자 함수 사용 - 선언부의 위치에 상관 없이 사용
    secondFunc(2) // 지역 함수 사용 - 선언부가 먼저 나와야 사용 가능
}

fun userFunc(counts: Int) { // 사용자가 만든 최상위 레벨의 함수 선언
    ...
}
```

### 전역변수

- 최상위에 있는 변수
- **프로그램 실행되는 동안 삭제X**, 메모리에 유지
- 여러 요소가 동시에 접근하는 경우 잘못된 동작 초래
- 자주 사용 안하는 전역변수 → 메모리 낭비

### 지역변수

- 특정 코드 블록 내에서만 사용
- **임시**로 사용, 스택 메모리 사용

## 5-1 조건문을 통한 분기(1)

- **if문, if-else문**
    
    ```kotlin
    if (조건식) { 
        수행할 문장 // 조건식이 참인 경우에만 수행
    } else { 
        수행할 문장 // 조건식이 거짓인 경우에 수행
    }
    
    // 한줄로 수행 문장이 간단하면 중괄호도 생략하고 간략하게 표현 가능
    val max = if (a > b) a else b
    ```
    
- if가 실행되면 else는 실행되지 않는데, 이때 return을 사용하지는 않음

### 비교 연산자 + 논리 연산자

```kotlin
else if(score >= 80 && score <= 89.9) { // 점수가 80점 이상이면서 89.9 이하
        grade = 'B'
    }
```

### 범위(range) 연산자

- 형식 : **변수명 in 시작값..마지막값**
- 예시 : score **in** 80**..**89 → 범위에 80부터 89까지 포함
- **시작값, 마지막값도 범위에 포함**된다!

## 5-1 조건문을 통한 분기(2)

### when구문 ← switch~case문 간략화, 코틀린만의 키워드!

- **인자가 없는 경우**
    - else if처럼 각각의 조건 실행 가능
    - 특정 인자에 제한하지 않고 **다양한 조건** 구성
    
    ```kotlin
    when {
      조건[혹은 표현식] -> 실행문
      ...
    }
    
    // 인자(score)가 있는 경우
    when(**score**) {
            **in 90.0..100.0 -> 'A'
            in 80.0..89.9 -> 'B'
            in 70.0..79.9 -> 'C'
            else -> 'F'**
    }
    
    // 인자(score)가 없는 경우
    when {
            **score >= 90.0 -> grade = 'A' // 조건식 위와 다르게 구성
            score in 80.0..89.9 -> grade = 'B'
            score in 70.0..79.9 -> grade = 'C'
            score < 70.0 -> grade = 'F'**
    }
    ```
    
- **인자가 있는 경우**
    
    ```kotlin
    when (인자) {
      인자에 일치하는 값 혹은 표현식 -> 수행할 문장
    	// break 필요 없음
    
      인자에 일치하는 범위 -> 수행할 문장
      ...
      else -> 문장
    }
    
    when (x) {
        1 -> print("x == 1") // break없이 1이면 1출력 후 빠져나감!
        2 -> print("x == 2")
        else -> { // 블록 구문 사용 가능
            print("x는 1, 2가 아닙니다.")
        }
    }
    ```
    
- 일치되는 조건이 여러 개 → ,로 연결
    
    ```kotlin
    when(x) {
    	**0, 1** -> print("x == 0 or x == 1") // 0이거나 1일 때
    }
    ```
    
- 함수의 반환값 사용
    
    ```kotlin
    when(x) {
    	parseInt(s) -> print("일치함")
    	else -> print("기타")
    }
    ```
    
- 범위 지정 → in, !in
    
    ```kotlin
    when(x) {
    	**in 1..10** -> print("x는 1이상 10이하")
    	**!in 10..20** -> print("x는 10이상 20이하 범위에 속하지 않음")
    	else -> print("x는 어떤 범위에도 없음")
    }
    ```
    
- is 키워드와 사용
