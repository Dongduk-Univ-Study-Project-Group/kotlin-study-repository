## 2-1 프로퍼티의 접근(1)

### 프로퍼티

- 데이터나 상태를 가질 수 있는 변수
    - 자바
        - 단순 **변수 선언만** 가짐
        - 접근 메소드는 따로 만들어야 함
    - 코틀린
        - **변수 선언 + 접근 메소드** 모두 가짐
        - 내부적으로 생성됨
    - 즉, 자바의 필드 → 코틀린의 프로퍼티
        - 자바는 필드에 대해 접근 메소드(게터&세터) 생성 필요
        - 코틀린은 접근 메소드가 내부적으로 자동 생성 → 자바처럼 만들 필요 없!
        
        ```kotlin
        fun main() {
            val user = User(1, "Sean", 30)
        		// 객체 생성
        
            // 게터에 의한 값 획득
        		// 내부적으로 게터 생성해서 근
            val name = user.name
        
            // 세터에 의한 값 지정
            user.age = 41
        
            println("name: $name, ${user.age}")
        }
        ```
        

## 2-1 프로퍼티의 접근(2)

### 게터와 세터 직접 지정

- 불변형 **val** : **게터만** 가능
- 지정 예시
    
    ```
    var 프로퍼티이름[: 프로퍼티자료형] [= 프로퍼티 초기화]
        [get() { 게터 본문 } ]
        [set(value) {세터 본문}]
    
    val 프로퍼티이름[: 프로퍼티자료형] [= 프로퍼티 초기화]
        [get() { 게터 본문 } ]
    ```
    
    - 세터는 **value** 설정
        - 매개변수로 외부로부터 값을 가져옴
    - **field** : **프로퍼티 참조** 변수
        - 프로퍼티를 대신할 임시 필드
        - 프로퍼티 직접 사용 시 게터나 세터 무한 호출됨