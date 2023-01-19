# 코틀린 2주

## 3-1 함수를 선언하고 호출해보기

### 함수란?

- 키워드 : **fun**
- fun main() : 프로그램 시작 위치
- 콜론 (:) 옆에 반환값의 타입 적기
- **반환 값이 없음 : unit** ↔ 자바의 **void**
- **최상위 함수** : main의 위 or 아래에 두더라도 해당 이름 사용 가능
- **지역 함수** : main 내부에 있을 경우, 선언 후 사용해야 함

```kotlin
fun 함수 이름([변수 이름: 자료형, 변수 이름: 자료형..]  ): [반환값의 자료형(반환타입)] { 
    표현식...
    [return 반환값] 
}

// 일반적인 함수
fun sum(a: Int, b: Int): Int {
    return a + b
}

// 간략화된 함수 (return문 생략, = 사용)
fun sum(a: Int, b: Int): Int **= a + b**

// 반환 자료형 생략(추론 가능한 경우)
****fun sum(a: Int, b: Int) **= a + b**

// 반환 값이 없음
**fun outfunc(name: String): Unit {**
    println("Name: $name")
    // return Unit 이 생략돼있는 것
}

// default 값 지정한 경우
fun sum(a: Int, **b: Int = 5**): Int { // 인자 없을 경우 default 5지정
    return a + b
}

// default 지정한 함수 호출 (2와 5 비교)
sum(2)

**// 가변 인자 → 매개변수, 인자가 아주 많을 경우**
fun normalVarargs**(vararg a: Int)** {
    for(num in a) {
        print("$num ")
    }
}

```

### 함수와 스택 프레임

- 스택 : 임시 메모리, 높은 주소 → 낮은 주소로 감소
- 힙 : 동적 메모리, 낮은 주소 → 높은 주소로 증가
1. 진입점(main)에 들어가면 함수의 인자 체크
2. main()함수의 프레임 최초 생성
3. **프레임 : 함수가 사용하고자하는 변수를 관리하는 단위**
4. 지역변수들, 항 등 생성
5. 인자 없어서 args ← 0
6. **지역 변수 stack에 들어감 (임시로 사용됨)**
7. 선언만 완료한 상태 : result ← ? 
8. max함수 호출하는 순간 프레임 생성
9. **a = 10, b = 3 들어가고 결과 나올 때 pop돼서 사라짐**
10. **max 함수 프레임 자체가 없어지면서 결과물 돌려줌 (result ← 10)**

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/1611fa8d-8d08-42fa-bf7e-f4913dfce713/Untitled.png)

## 3-2 함수를 활용한 예제 만들기

```kotlin
package chap03.section1

fun avgFunc(initial: Float = 0f, vararg numbers: Float): Double {
    var result = 0f
    for (num in numbers) {
        result += num
    }
    println("result: $result, numbers.size: ${numbers.size}")
    // val avg = (result / numbers.size).toDouble() 이렇게 하면 밑줄 생김
    val avg = result / numbers.size
            return avg.toDouble()
}

fun main() {
    val result = avgFunc(5f, 100f, 90f, 80f)  // 첫번째 인자: 초기값, 이후 인자는 가변인자
    println("avg result: $result")
}
```

## 3-3 함수형 프로그래밍 패러다임!

- 코틀린은 **다중 패러다임 언어**
    - **함수형 프로그래밍(FP)**
    - **객체 지향 프로그래밍(OOP)**
- 함수형 프로그래밍
    - Input, 처리 내용, Output
    - 코드 간결 → 테스트, 재사용성 증가
    - **람다식, 고차 함수를 사용하여 구성 ← 기본 data 뿐만 아니라 함수 자체도 넣을 수 있다!**
    - 순수 함수

### 순수 함수란?

- **부작용(side-effect)이 없는 함수**
    - 입력이 같다면 출력도 같아야 한다.
    - **부작용이 있다 : 같은 입력에 대해 다른 출력이 나올 수 있다.**
    - 값이 예측 가능 → 결정적
- 순수 함수 조건
    - 같은 인자에 대해 항상 같은 값 반환
    - 함수 외부의 어떤 상태도 바꾸지 X
    
    ```kotlin
    // 순수 함수가 아닌 것
    fun check() {
    		val test = User.grade() // check 함수에 없는 외부 User 객체 사용
    		if (test != null) process(test) // 윗줄 실행 결과에 따라 출력이 달라진다.
    }
    
    const val global = 10
    
    fun noPureFunction(a: Int, b: Int): Int {
    		return a + b + global // 입력값과 무관하게 외부 변수 사용
    }
    
    // a = 1, b = 2로 입력이 같아도 global 값에 따라 출력이 달라져서.
    ```
    
- 순수 함수 왜?
    - 입력과 내용 분리 & 모듈화 → 재사용성 증가, 여러 함수와 조합해도 부작용 X
    - 특정 상태에 영향 X → 병행 작업 안전
    - 함수 값 추적과 예측 가능 → 테스트, 디버깅 유용
- 함수형 프로그래밍에 적용
    - 함수를 매개변수, 인자, 반환값에 적용(고차 함수)
    - 함수를 변수나 데이터 구조에 저장
    - 유연성 증가
    - 코드가 복잡해질 수는 있지만, 간결해짐
    

### 람다식

- **익명 함수**의 하나의 형태
- 이름 없이 사용과 실행 가능

```kotlin
(x, y -> x + y)
```

- 람다식을 고차 함수에서 인자로 넘기거나 결과값으로 반환

### 일급 객체

- 권한이 많음
- **함수의 인자**로 전달 가능 ← 일급 객체가 함수일 수도 있다.
- **함수의 반환값**에 사용 가능
- **변수**에 담기 가능

<aside>
💡 코틀린에서 함수는 1급 객체(1급 함수)로 다룸

</aside>

### 고차 함수

- 함수에 함수 넣기

```kotlin
fun highFunc(sum: (Int, Int) -> Int, a: Int, b: Int): Int {
		return sum(a, b)
}

// 매개변수로 sum, a, b
// sum에는 람다식이 들어감
```

### 함수형 프로그래밍 사용 이유

- 프로그램 모듈화 → 디버깅, 테스트 쉬움
- 간략한 표현식 → 생산성 증가
- 람다식, 고차함수 → 다양한 함수 조합 사용

<aside>
💡 순수 함수를 조합 → 데이터 변경, 부작용이 없는 루틴 만든다.
람다식을 이용해 함수를 변수처럼 매개변수, 인자, 반환값 등에 활용하는 고차 함수를 구성 → 생산성 높임

</aside>
