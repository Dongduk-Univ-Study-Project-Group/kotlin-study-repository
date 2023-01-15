## 1-1 코틀린 너는 누구니?

### 코틀린 특징
1. 자료형 오류를 초기에 발견 가능한 **정적 언어
-** 프로그램이 컴파일될 때 자료형 검사 후 확정
2. NPE에서 자유롭다! 
3. 간결하고 효율적
4. 함수형 프로그래밍, 객체 지향 프로그래밍 모두 가능
5. 세미콜론 생략 가능

## 1-2 개발 환경을 꾸며 보아요.

### JDK 설치

- 코틀린 JVM에서 실행
- 기존 자바와 상호작용, 자바 라이브러리 이용

### Oracle JDK ↔ Open JDK

- Oracle JDK : 지속적인 보안 업데이트 ← ‘구독’ 방식 라이선스 필요
- Open JDK : 제한 없이 사용 가능, but 보안 서비스 의무 없어 유지보수 어렵

## 1-3 안녕 세상아!

### 코틀린의 main()

- 최상위 함수
- 실행 진입점
- 코틀린은 선언된 클래스가 없는데도 불구하고 main()메소드 하나로 println()함수를 통해 콘솔에 문자열 "Hello Kotlin"을 출력

---

## 2-1 기본 자료형과 변수 선언

### 기본 자료형과 변수 선언 방법 (1)

- 자료형
    - Int
    - String
    - …
- 변수
    - val : 불변형
    - var : 가변형
- 변수 선언
    - [선원 키워드] [변수 이름]: [자료형] = [값]
    - val username: String = “kittybelle”
    - val : 초기값 설정 후 변경 불가.
        
        ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6643a554-6a97-4cf8-a104-c087df8c724c/Untitled.png)
        
- 자료형 명시적 지정X → 컴파일러가 추론(Ctrl + Shift + P)
- 기본형
    - 순수한 자료형, 프로그래밍 언어에 내장
    - int, long …
- 참조형
    - 동적 공간에 데이터를 두고 참조
    - Int, Long …
- 동작 원리 이해 (자바)
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d8541400-0a4d-4280-955d-a04c6554b418/Untitled.png)
    
    - 77 : stack에서 접근 (참조된 동적공간 존재X)
    - Person 객체가 동적 공간에 생성되고 주소 A12로 참조
    

### 기본 자료형과 변수 선언 방법 (2)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/978ed883-f5b6-4c4d-b521-54c3c0c37892/Untitled.png)

- 정수 기본 : Int, 실수 기본 : Double
- 접미사 & 접두사 사용 시
    - L : Long
    - 0x : 16진 Int
    - 0b : 2진 Int
    - F : Float
- 큰 수 읽기 쉽게 : *사용 ex)1_000_000*

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7b2b795a-c869-490c-b5fb-8c8def9b14aa/Untitled.png)

<aside>
💡 Q : 0.1을 1000번 더하면 100이 나와야 하는데?
A : 지수부와 가수부의 제한 때문

</aside>

### 기본 자료형과 변수 선언 방법 (3)

- Ctrl + D : 줄간 복사
- Alt + Shift + 바꾸고자 하는 변수 블록 : 동시 수정
- 2의 보수 : 10진수 2진수로 변환 → 0과 1 서로 뒤집기 → 1 더하기
- 논리 자료형 : Bollean
- 문자 자료형 : Char
    - 선언만 한 경우 자료형 반드시 명시 ex) val ch2: Char
- 문자열 : String
    - 동적 공간(Heap) 중 String Pool에 구성됨
    - **var로 선언하더라도 A1의 내용은 변경 불가, str1이 가리키는 주소(A1)만 변경 가능!**
    - 출력결과 확인**
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/639e90d4-614f-46a4-a38e-76783541699e/Untitled.png)
    
    ```kotlin
    // 문자열 출력하기
    val a = 30
    val s1 = "a is $a" // 표현식, $ 사용
    ```
    

---

## 2-2 나를 괴롭히는 널(Null)

<aside>
💡 코틀린은 null 허용X → 안전하게 프로그래밍 가능
세이프 콜 : ?.

</aside>

- NULL : 변수 선언 후 아무런 값을 할당X
- NPE : null 변수에 접근하면 발생하는 에러

```kotlin
// null 불가능, 가능
val a: Int = 30
val a: Int? = null 
```

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/5e76e729-e124-4af0-8232-6e6b9d1d9938/Untitled.png)

[[코틀린 docs] 코틀린의 타입](https://lannstark.tistory.com/144)

## 2-3 검사와 자료형을 반환해보기

- 자료형 변환
    - 기본형 사용X, 참조형만 사용
    - 변환 메소드 이용
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b2652e4a-b06f-474d-b079-75f9d4875174/Untitled.png)
    
- 기본형과 참조형 비교
    - == : 값만 비교
    - === : 값, 참조 주소 모두 비교
    
    ```kotlin
    // 참조 주소
    val a: Int = 128
    val b: Int? = 128
    
    println(a == b) // true
     println(a === b) // false
    ```
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/58443a68-d13d-49e2-9fe9-c7355da25afc/Untitled.png)
    
- 구체적 명시X 자료형 자동 변환 → 값에 따라 결정
- Number형 : 숫자 저장, 스마트 캐스
- is 키워드 : 자료형 검사
- Any : 자료형 정해지지 않음

## 2-4 연산자를 조합해 다양한 식 만들기

- 산술 연산자
    - +, -, *, /, %
- 대입 연산자
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6ae2b316-68d5-49ec-9495-2ccc5bf51a41/Untitled.png)
    
- 비교 연산자
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8c073159-fd94-4ae8-aaea-1d995fb3b07b/Untitled.png)
    
- 논리 연산자
    - &&, ||, !
- 비트 연산자
