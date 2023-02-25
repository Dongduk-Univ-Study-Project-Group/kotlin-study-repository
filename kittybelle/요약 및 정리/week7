## 1-1 클래스와 객체의 정의

### 객체 지향 프로그래밍(OOP)

- 프로그램의 구조 → **객체 간 상호작용**으로 표현
- 절차적 프로그래밍 한계 극복을 위해 탄생
- 객체, 관계 표현 → 확장, 재사용 용이
    - 객체 설계 틀 : 클래스
- 자바, 코틀린
    - 절차적 : C 구조체 → 자바 클래스로 발전
    - 자바 함수형 프로그래밍 부족 → 코틀린으로 발전
- 객체 지향 개념 용어
    - 추상화
        - 개념화
        - 차의 개념 → 어떠한 장치를 가진 것
    - 인스턴스
        - 실체(차)
    - 상속
        - 상하 관계(부모 - 자식)
        - SUV
        - 스포츠카
    - 다형성
        - print → 출력이라는 액션이 종이나 화면 둘 다에 가능
    - 캡슐화
        - 차의 메소드 구체적인 내용은 숨김
        - 필요한 부분만 접근
    - 메시지 전송
        - 객체 간 데이터 주고 받기
    - 연관
        - 객체들 간의 관계
            - 자동차와 엔진 : 엔진이 차 안에 들어있음
            

### 클래스

- 분류, 계층, 등급
- 클래스 다이어그램
    - 클래스명
    - 속성(필드, 프로퍼티)
    - 함수(메소드, 오퍼레이션)
    

### 추상화

- 목표로 하는 것에 필요한 만큼 속성, 동작 정의

<aside>
💡 자바의 필드 = 코틀린의 프로퍼티

</aside>

### 생성자

- 클래스를 통해 객체 생성 시 기본적으로 호출되는 함수
- 객체 생성 시 필요한 값 인자로 초기화
- **constructor()**
    - **주 생성자**
        - **클래스 명**과 함께 기술
        - constructor 키워드 생략 가능
    - **부 생성자**
        - **클래스 본문**에 기술
        - **1개 이상** 정의 가능

```kotlin
class Bird {
    // ① 프로퍼티들 - 선언만 함
    var name: String
    var wing: Int
    var beak: String
    var color: String

    // ② 부 생성자 - 매개변수를 통해 초기화할 프로퍼티에 지정
    constructor(name: String, wing: Int, beak: String, color: String) {
        this.name = name // ③ this.wing는 선언된 현재 클래스의 프로퍼티를 나타냄 
        this.wing = wing
        this.beak = beak
        this.color = color    
    }

    // 메서드들
    fun fly() = println("Fly wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}
```

### 상속

- 자식 클래스가 부모 클래스의 속성과 기능을 물려받음
- 부모의 프로퍼티와 메소드가 자식에 적용
- 상속 가능 : **open**
- 최상위 클래스 : **Any**

```kotlin
open class 기반 클래스명 { // 묵시적으로 Any로부터 상속됨, open으로 파생 가능
 ...
}
class 파생 클래스명 : 기반 클래스명() {  // 기반 클래스로부터 상속됨, 최종 클래스로 파생 불가
 ...
}
```

### 다형성

- **같은 이름** 사용 but **다른 기능** 수행
    - static
        - **컴파일** 타임에 결정됨
        - 메소드 **오버로딩**
    - dynamic
        - **런타임** 다형성
        - 동적으로 구성되는 **오버라이딩**된 메소드 사용 시

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ce564409-eb99-4d03-ab62-3e66cb88a620/Untitled.png)

```kotlin
val lark: Lark = Lark()
val lark: Bird = Lark() // lark는 새의 한 종

lark.fly()
```

### 오버라이딩

- 기능을 완전히 바꾸어 **재설계**
- 누르다 → 행위 → push()
- push() : 확인 or 취소로 **서로 다른 기능** 수행
- **금지** 키워드 : **final**

### 오버로딩

- **기능은 같지만, 인자를 다르게** 하여 여러 경우 처리
- 출력한다 → 행위 → print()
- print(1), print(”H”) : 인자는 다르지만 출력한다는 기능은 동일

```kotlin
fun add(x: Int, y: Int): Int { // 정수 2개 더함
		return x + y
}

fun add(x: Double, y: Double): Double { // 실수 2개 더함
		return x + y
}

fun add(x: Int, y: Int, z: Int): Int { // 정수 3개 더함
		return x + y + z
}
```

### super

- **상위** 클래스 참조

### this

- **현재** 클래스 참조

### 바깥 클래스 호출 : 옛(@) 기호

- 이너 클래스에서 바깥 클래스의 상위 클래스 호출 시
    - super 키워드와 함께
    - 옛(@) 기호 옆에 바깥 클래스명 작성

### 앵글브라켓 : 상위 클래스 메소드명 중복 해결

- AngleBracketTest.kt

### 캡슐화(정보 은닉)

- 클래스 작성 시 **외부에서 숨겨야 하는 속성, 기능**
- 가시성 지시자 → 외부 접근 범위 결정
    - private : 외부 불가
    - public : 어디서든 가능(기본값, 생략 가능)
    - protected : 외부 불가, 하위 상속 가능
    - internal(자바의 패키지) : 같은 정의의 모듈 내부에서 가능
- 선언 위치
    
    ```kotlin
    [가시성 지시자] <val | var> 전역 변수명
    
    [가시성 지시자] fun 함수명() { }
    
    [가시성 지시자] [특정 키워드] class 클래스명 [가시성 지시자] constructor(매개변수들) {
    		[가시성 지시자] constructor() { }
    		[가시성 지시자] 프로퍼티들
    		[가시성 지시자] 메소드들
    }
    
    // 주 생성자에 가시성 지시자 사용 -> constructor 생략 불가
    ```
    
    ```kotlin
    open class Base {
        // 이 클래스에서는 a, b, c, d, e 접근 가능
        private val a = 1
        protected open val b = 2
        internal val c = 3
        val d = 4  // 가시성 지시자 기본값은 public
    
        protected class Nested {
            // 이 클래스에서는 a, b, c, d, e, f 접근 가능
            public val e: Int = 5 // public 생략 가능
            private val f: Int = 6
        }
    }
    
    class Derived : Base() {
        // 이 클래스에서는 b, c, d, e 접근 가능
        // a 는 접근 불가
        override val b = 5   // Base의 'b' 는 오버라이딩됨 - 상위와 같은 protected 지시자
    }
    
    class Other(base: Base) {
        // base.a, base.b는 접근 불가
        // base.c와 base.d는 접근 가능(같은 모듈 안에 있으므로)
        // Base.Nested는 접근 불가, Nested::e 역시 접근 불가
    }
    ```
    

### 클래스와 관계

- 서로 관계를 맺고 메시지를 주고 받음

### 관계 종류

- 연관
- 의존 : 점선
- 집합 : 다수의 오리를 갖는 연못 1개,
- 구성 : 엔진은 차의 구성품
- 0.* : 0명이거나 여러 명일 수 있음

### 관계 판별 방법

- 클래스 참조 유지
    - N : 의존
    - S : 연관
        - 클래스 생명주기 유지
            - Y : 집합
            - N : 구성
