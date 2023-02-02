## 5-2 반복문으로 여러번!

### for문

- 형태 : `for (요소 변수 in 컬렉션 혹은 범위) { 반복할 본문 }`
- **in**으로 범위 지정, 이때 **양끝값 포함** (x in 1..10 → 1과 10 포함)
    - 보통의 경우 : 1씩 증가하는 상행 형태
    - **하행** 반복 : **downTo**
        - `for (i in 5 downTo 1) print(i)` → 5, 4, 3, 2, 1
            - for **(i in 5..1) ← 잘못된 표현!**
    - **증가/감소량** 설정 : **step**
        - `for (i in 1..5 step 2) print(i)` → 1, 3, 5
    - ex : 2씩 감소하는 반복문
        - `for (i in 5 downTo 1 step 2) print(i)` → 5, 3, 1
- **세미콜론 표현식 사용X**
    - (ex: i = 1; i < 5;) 사용X

### while문

- 형태
    
    ```kotlin
    while (조건식) { // 조건식이 true인 동안 본문의 무한 반복
        본문
        ....
    }
    ```
    
- 조건식에 **true**를 넣으면 무한 반복, **데몬 프로그램**(죽지 않는)에 주로 사용
    - ex : 보일러 온도 체크 → 임계 온도 벗어나면 경고 발생
    

### do-while문

- **일단 본문 한 번은 실행** 후, while문 조건 체크
- 형태
    
    ```kotlin
    do {
      본문
    } while (조건식)
    ```
    
- **모듈러 연산**
    
    ```kotlin
    for(i in 0 until input) { // until : input - 1과 같은 효과
                for(j in 0..(input - 1)) {
                    **print((i + j) % input + 1)** // 모듈로 연산 사용시 값 범위 벗어나지 않음
                }
                println()
            }
    ```
    
    - 5 입력시 **12345, 23451** 이렇게 순환할 때 유용

## 5-3 흐름의 중단과 반환(1)

### 흐름 제어문

- **return** : 함수 **결과값 반환** or 지정된 라벨로 이동
- **break** : 조건식과 관계 없이 **반복문 중단**
- **continue** : 반복문의 본문을 모두 수행하지 않고 **다시 조건으로 넘어감**

### 예외 처리문

- try {..} catch {..} : try 예외 발생 시 catch 실행
- try {..} catch {..} finally {..} : 예외 발생해도 finally는 항상 실

### 람다식에서 잘못된 return → 비지역 반환 문제

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/0bd9b0ae-ad1d-4706-8a37-0028fcfa0071/Untitled.png)

- a + b의 값인 result > 10이면 return하는 코드
    - inlineLambda만 빠져나가지 않음!! retFunc()까지 빠져나가는 비지역 반환 발생
    - 밑줄의 println 2개 모두 실행하지 않는다.
    - 이런 문제를 해결하려면? → 람다식에선 라벨 사용

## 5-3 흐름의 중단과 반환(2)

### 람다식에서 라벨과 함께 return 사용

- 형태
    
    ```kotlin
    람다식 함수명 라벨이름@ {
      ...
    	return@라벨이름
    } 
    ```
    
    ```
    fun inlineLambda(a: Int, b: Int, out: (Int, Int) -> Unit) { // inline이 제거됨
        out(a, b)
    }
    
    fun retFunc() {
        println("start of retFunc")
        inlineLambda(13, 3) **lit@**{ a, b ->  // ① 람다식 블록의 시작 부분에 라벨을 지정함
            val result = a + b
            if(result > 10) **return@lit** // ② 라벨을 사용한 블록의 끝부분으로 반환
            println("result: $result")
        } **// ③ 이 부분으로 빠져나간다**
        **println("end of retFunc") //  ④ 이 부분이 실행됨**
    }
    ```
    
- **암묵적 라벨**
    - 람다식에 직접 라벨을 쓰지 않음
    - **함수 이름을 라벨처럼** 사용
        
        ```kotlin
        fun retFunc() {
            println("start of retFunc")
            inlineLambda(13, 3) { a, b -> 
                val result = a + b
                if(result > 10) **return@inlineLambda** 
                println("result: $result")
            } 
            println("end of retFunc") 
        }
        ```
        
    

### 익명 함수를 사용한 반환

- 익명 함수 사용 시, 라벨을 사용하지 않아도 비지역 반환 발생X → println 잘 출력됨
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ccde154a-ed20-48a1-bdf2-84367a13943e/Untitled.png)
    
- 람다식에서 리턴이 필요한 경우 유용
- 너무 많이 사용하면 코드 해석 난해해질 수 있음

### 람다식과 익명 함수

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/077f7076-d15e-48ae-a617-5d001e6f7e1f/Untitled.png)

- 람다식 : Error / Sucess 반환
    - 람다식의 마지막 식은 return 형태로 빠져나간다!
    - 람다식 안에서는 return을 쓰지 않음(비지역 반환)
- 익명 함수 : 조건에 따라 일반 함수처럼 return 작

### break와 continue

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/894195a2-eaea-4940-95a3-8214cf375774/Untitled.png)

- break : 반복문 탈출
- continue : 다시 조건문 체크
    
    ```kotlin
    fun main() {
        for(i in 1..5) {
            if(i == 3)
                break
            print(i)
        }
        println()
        println("outside")
    
        main2()
    }
    
    fun main2() {
        for(i in 1..5) {
            if(i == 3)
                continue
            print(i)
        }
        println()
        println("outside")
    }
    
    // break 실행결과
    12
    outside
    
    // continue 실행결과
    1245
    outside
    ```
    

### 라벨 유무에 따른 break

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d36b6437-5d73-4167-af0c-a73384b998d4/Untitled.png)

- LabelTest.kt 파일 참고
- break와 continue 비교
- first@ 유무 비교

## 5-4 예외가 발생했어요!

### 예외(exception)란?

- 실행 도중 잠재적인 오류까지 검사할 수 없어서 발생
- 정상적으로 실행되다가 비정상적으로 프로그램 종료되는 경우
    - OS 문제 (잘못된 시스템 호출)
    - 입력값 문제 (존재하지 않는 파일)
    - 잘못된 연산 (0으로 나누기)
    - 메모리 할당 실패, 부족
    - 컴퓨터 기계 문제 (전원, 기억장치 고장)
- 형태
    
    ```
    try {
        예외 발생 가능성 있는 문장
    } catch (e: 예외처리 클래스명) {
        예외를 처리하기 위한 문장
    } finally {
       반드시 실행되어야 하는 문장
    }
    ```
    
    - finally는 반드시 실행되며, 생략 가능

### 특정 예외 처리 및 발생

- 처리
    - **ArithmeticException** : **산술 연산** 예외
    - `e.printStackTrace()` : 임시 메모리 영역인 스택 추적 가능, 에러 메세지 출력
- 발생
    - `throw` Exception(message: String)
    - 특정한 조건에서 예외를 발생시킬 수 있다.
    

## 6-1 준비운동! 람다식과 고차함수 요약

### 람다식

- 형태
    - `{ 매개변수[,...] -> 람다식 본문 }`
- 본문 길어질 경우 엔터
- **마지막 문장 반환**
    
    ```kotlin
    val sum: (Int, Int) -> Int = { x, y -> x + y }
    val mul = { x: Int, y: Int -> x * y } // 간소화된 표현
    
    // 매개변수가 하나라면 화살표 생략하고 it으로 대체할 수 있음
    val add: (Int) -> Int = { it + 1 }
    ```
    
- 여러 개의 식과 라벨 유무
    
    ```kotlin
    val isPositive: (Int) -> Bollean = {
    	val isPositive = it > 0 // 매개변수가 0보다 큰지 작은지 조건에 따라 T, F 결정
    	**isPositive** // 마지막 표현식 반환됨, T 아니면 F
    }
    
    val isPositive: (Int) -> Bollean = **number@** {
    	val isPositive = it > 0 
    	**return@number** isPositive // 라벨 사용하여 반환
    }
    ```
    

### 고차함수

- 함수의 매개변수에 함수를 넣거나 함수를 반환 가능한 함
    
    ```kotlin
    fun high(name: String, body: (Int)->Int): Int {
        println("name: $name")
        val x = 0
        return body(x)
    }
    ```
    
    - high 함수의 매개변수는 name, body로 2개
    - body는 람다식
