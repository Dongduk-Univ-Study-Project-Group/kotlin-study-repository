## run() 활용하기

### 동작

- 인자가 없는 익명 함수처럼 동작하는 형태와 객체에서 호출하는 형태 두 가지로 사용
    
    ```kotlin
    public inline fun <R> run(block: () -> R): R = return block()
    public inline fun <T, R> T.run(block: T.() -> R): R = return block()
    ```
    
    - 독립적으로 사용할 때는 block에 처리할 내용을 넣어주며 마지막 식이 반환된다.
        
        ```java
        val a = 10
        skills = run {
            val level = "Kotlin Level:" + a
            level // 마지막 표현식이 반환됨
        }
        ```
        
    - 할당 없이 사용할 때는 체이닝을 사용해 특정 결과에 대한 메서드를 실행할 수 있다.
        
        ```kotlin
        run {
              if (firstTimeView) introView else normalView
          }.show()
        ```
        
    - 확장 함수형태로 사용할 때 어떤 요소가 null인 경우 다음과 같이 세이프콜을 사용할 수 있다.
        
        ```kotlin
        obj?.run {
           ...
        }
        ```
        
- 사용 예시

```kotlin
var skills = "kotlin"
println(skills)   // kotlin

val a = 10
skills = run {
	val level = "kotlin Level:" + a
	level   // 마지막 표현식이 반환된다.
}

println(skills)  // kotlin level:10
```

### apply() run() 비교해보기

```kotlin
fun main() {
	// apply와 run 비교
	data class Person(var name: String, var skills: String)
	var person = Person("kildong", "Kotlin")

	val retrun = person.apply {
		this.name = "Sean"
		this.skills = "Java"
		"success"    // 사용되지 않음
	}

	println(person)
	println("returnObj: $returnObj")

	val returnObj2 = person.run {
		this.name = "Dooly"
		this.skills = "C#"
		"success"
	}
	println(person)
	println("returnObj2: $returnObj2")
}
```

- apply는 해당 객체의 멤버를 this로 받아서 재할당 가능
    - 마지막에 어떤 식을 반환한다 할 지라도 사용되지 않는다.
- 두 함수 모두 this는 생략 가능하다.

## with() 활용하기

### 동작

- 인자로 받는 객체를 이어지는 block의 receiver로 전달하며 결과값을 반한
    
    ```kotlin
    public inline fun <T, R> with(receiver: T, block: T.() -> R): R = receiver.block()
    ```
    
    - run() 함수와 기능이 거의 동일한데, run의 경우 receiver가 없지만 with()에서는 receiver로 전달할 객체를 처리한다.
- run 함수와 기능이 거의 동일한데, run의 경우 receiver가 없지만 with()에서는 receiver로 전달할 객체를 처리한다.
- 확장 함수 형태가 아니고 단독으로 사용되는 함수이다.
- with()는 세이프 콜(?.)은 지원하지 않기 때문에 다음과 같이 let과 같이 사용한다.
    
    ```kotlin
    supportActionBar?.let {
    	with(it) {
    		setDisplayHomeAsUpEnabled(true)
    		setHomeAsUpIndicator(R.drawable.ic_clear_white)
    	}
    }
    ```
    
    - this를 생략하여 사용 가능하다.

### let과 with 표현 병합

- run과 동일
    
    ```kotlin
    supportActionBar?.run {
    	setDisplayHomeAsUpEnabled(true)
    	setHomeAsUpIndicator(R.drawable.ic_clear_white)
    }
    ```
    

### with() 사용해보기

```kotlin
fun main() {
	data class User(val name: String, var skills: String, var email: String? = null)

	val user = User("Kildong", "default")

	val result = with (user) {
		skills = "Kotlin"   // receiver로 받았기 때문에 this 생략
		email = "kildong@example.com"
	}

	println(user)
	println("result: $result")
}

// 출력 결과
User(name=kildong, skills=kotlin, email=kildong@example.com)
result: kotlin.Unit
	
```

- 멤버만 설정하고 반환을 설정하지 않으면 Unit이 반환된다.
    
    ```kotlin
    val result = with (user) {
    	skills = "Kotlin"   // receiver로 받았기 때문에 this 생략
    	email = "kildong@example.com"
    	"SUCCESS"   // 마지막 표현식 반환
    }
    ```
    
    - 기본적으로는 Unit을 반환, 필요하면 다음과 같이 마지막 표현식을 반환할 수 있다.

## use()

- use()를 사용하면 객체를 사용한 후 **close() 등을 자동적으로 호출해 닫아준다.**
    
    ```kotlin
    public inline fun <T: Closeable?, R> T.use(block: (T) -> R): R
    public inline fun <T: AutoCloseable?, R> T.use(block: (T) -> R): R
    ```
    
    - T의 제한된 자료형을 보면 Closeable?로 block은 닫힐 수 있는 객체를 지정해야 한다.
    - Java 7 이후로는 AutoCloseable?로 사용된다.

### 파일 관련 처리의 예

- 파일로부터 읽기 위한 자바 코드의 예
    
    ```kotlin
    private String readFirstLine() throws FileNotFoundException {
    	BufferedReader reader = new BufferedReader(new FileReader("test.file"));
    	try {
    		return reader.readLine();
    	} catch (IOException e) {
    		e.printStackTrace();
    	} finally {
    		try {
    			reader.close();   // 반드시 닫아야한다.
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    
    	return null;
    }
    ```
    
    - 코틀린으로 변경한 코드
        
        ```kotlin
        private fun readFirstLine(): String {
        	BufferedReader(FileReader("test.file")).use { return it.readLine() }
        }
        ```
        
- 파일 닫기에 대한 처리
    
    ```kotlin
    import java.io.File
    import java.io.FileOutputStream
    import java.io.PrintWriter
    
    fun main() {
    	PrintWriter(FileOutputStream("d:\\test\\output.txt")).use {
    		it.println("hello")
    	}
    }
    ```
    

### use 구현부

![스크린샷 2023-02-25 오후 6.59.05.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/df6b97c2-7b3b-4bab-b609-043f9ede2262/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2023-02-25_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_6.59.05.png)

- 자바 코드와 유사하게 try-catch-finally 존재

## 기타 함수의 활용

### takeIf()와 takeUnless()

```kotlin
public inline fun <T> T.takeIf(predicate: (T) -> Boolean): T?
= if (predicate(this)) this else null
```

- takeIf() 함수는 **람다식이 true이면 객체 T를 반환하고 그렇지 않은 경우 null 반환**
- takeUnless() 함수는 **람다식이 false이면 T를 반환하고 그렇지 않은 경우 null 반환**
- 사용 예시
    
    ```kotlin
    // 기존 코드
    if (someObject != null && someObject.status) {
    	doThis()
    }
    
    // 개선한 코드
    if (someObject?.status == true) {
    	doThis()
    }
    
    // takeIf를 사용해 개선한 코드
    someObject?.takeIf {it.status}?.apply {doThis()}	
    ```
    
- 엘비스 연산자를 함께 사용(?:)
    
    ```kotlin
    val input = "kotlin"
    val keyword = "in"
    
    // 입력 문자열에 키워드가 있으면 인덱스를 반환하는 함수를 takeIf를 사용해 구현
    input.indexOf(keyword).takeIf { it >= 0 } ?: error("keyword not found")
    
    // takeUnless를 사용하여 구현
    input.indexOf(keyword).takeUnless {it < 0} ?: error("keyword not found")
    ```
    

### 시간의 측정

- Kotlin.system 패키지에 있는 두 개의 측정 함수
    - measureTimeMillis()와 measureNanoTime()
- 선언부
    
    ```kotlin
    public inline fun measureTimeMillis(block: () -> Unit): Long {
    	val start = System.currentTimeMillis()
    	block()
    	return System.currentTimeMillis() - start
    }
    
    public inline fun measureNanoTime(block: () -> Unit): Long {
    	val start = System.nanoTime()
    	block()
    	return System.nanoTime() - start
    }
    ```
    
    - 측정하고자 하는 코드를 block으로 받는다.
- 시간 측정 사용 방법
    
    ```kotlin
    val executionTime = measureTimeMillis {
    	// 측정할 작업 코드
    }
    
    println("Execution Time = $executionTime ms")
    ```
    

### 난수 생성하기

- 코틀린의 난수 생성
    - 자바의 java.util.Random을 이용할 수도 있었지만 JVM에만 특화된 난수를 생성하기 때문에 **코틀린에서는 멀티플랫폼에서도 사용 가능한 kotlin.random.Random을 제공**
    - 코틀린 특화 표준 함수 사용
- 0 ~ 21 사이의 난수 제공 예
    
    ```kotlin
    import kotlin.random.Random
    ...
    val number = Random.nextInt(21)  // 숫자는 난수 발생 범위
    println(number)
    ```

    ## 객체 지향 프로그래밍

### OOP; Object-Oriented Programming

- 프로그램의 구조를 객체 간 상호작용으로서 표현하는 프로그래밍 방식
    - 객체와 객체 사이에 관계를 가지고 메세지를 주고받으며 서로 통신
    - 객체를 만들기 위해서는 틀이 필요한데, 이것이 바로 class
- 절차적 프로그래밍의 한계를 극복하고자 나온 언어의 한 가지 방법론
- 객체와 관계를 표현하고 이를 통해 확장과 재사용이 용이
- 자바와 코틀린에서는 OOP를 지원한다.
    - C와 같은 언어는 절차지향형 → 구조체 → 클래스(자바)
    - 자바는 OOP만 지원하기 때문에 함수형은 아니다.
    - 코틀린에서는 OOP, FP 모두 지원

### 객체지향 개념상의 용어들

- 추상화(abstraction)
    - 개념화 작업
- 인스턴스(instance)
    - 만들어진 개념을 바탕으로 실체화한 것 (실제품 존재)
    - 개념 = class, 객체 = object
- 상속(inheritance)
- 다형성(polymorphism)
- 캡슐화(encapsulation)
    - 내부 기능이 무엇인지 숨긴다.
    - 내부 원리는 신경쓰지 않아도 되도록 필요한 부분만 엑세스 가능하도록 한다.
- 메세지 전송(message sending)
    - 객체들 간 메세지 전송 (데이터 주고 받기)
- 연관(association)
    - 객체간의 연관관계
    - 약한 결합, 강한 결합

### 클래스와 추상화

- 클래스(class)
    - 분류, 계층, 등급 등의 우리말 뜻
    - 특정 대상을 분류하고 특징(속성)과 동작 활동(함수) 내용을 기록
    - 실제화되지 않은 일종의 개념 (메모리에 올라가서 동작하지는 않음)
- 추상화(Abstraction)
    - 목표로 하는 것에 대해 필요한 만큼 속성과 동작을 정의하는 과정
    - 클래스를 만들어내는 과정(?)