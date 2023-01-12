## 사용 가능한 플랫폼

- kotlin/JVM : 자바 가상 머신 상에서 동작하는 **앱**을 만들 수 있다.
    - 코틀린 자체가 **java 와 같이 상호 연동**해서 사용할 수 있기 때문에 동작 가능
- kotlin/JS : 자바스크립트에 의해 **브라우저에서 동작하는 앱**을 만들 수 있다.
- kotlin/**Native** : LLVM 기반의 네이티브 컴파일을 지원해 여러 타깃의 앱을 만들 수 있다.
    - Native : 특정 기기에 맞춰진 코드를 만들어낼 수 있다.
    - 어느 기기에서든 내 코드를 동작시킬 수 있다.
    - 멀티 플랫폼용 코드를 작성할 수 있다.
- 다만 **JVM 외에는 아직 자료가 많지 않고 완성도가 낮다.**

### kotlin/Native 에서의 타깃

- ios (arm32, arm64, emulator x86_64)
- MacOS (x86_64)
- Android (arm32, arm64)
- Windows (mingw x86_64)
- Linux (x86_64, arm32, MIPS, MIPS little endian)
- WebAssembly (wasm32)
    - 특정 웹 엔진 상에서도 돌릴 수 있다.

## 코틀린의 장점

### 자료형에 대한 오류를 미리 잡을 수 있는 정적 언어(statically typed)

- 정적 형식 : 컴파일러가 타입을 검증해준다.
- 컴파일 단계에서 미리 검사해주고, 오류가 있는지를 확인

### NullPointer로 인한 프로그램의 중단을 예방할 수 있다.

- 보통 개발자들은 코틀린의 이런 특징을 ‘NPE에서 자유롭다’ 라고 한다.
- NPE는 Null Pointer Exception을 줄여 말한 것
- 기존 코드는 Nullable 기능이 없기 때문에 모든 코드에서 null 발생 가능성이 존재
- nullable과 null이 아닌 것을 구분할 수 있다.

### 데이터형 선언 시 널 가능한 형식과 불가능한 형식 지원

- ? 사용

### 자바와 완벽하게 상호 운영이 가능하다.

- 기존 코드가 전부 자바로 작성되어 있을지라도 일부분을 코틀린으로 수정하면서 운영 가능
- JVM 상에서 돌 수 있기 때문이다.

### 아주 간결하고 효율적

### 함수형 프로그래밍과 객체지향 프로그래밍이 모두 가능하다.

### 세미콜론을 생략할 수 있다.

## LTS

- 보안 업데이트와 관련된 내용을 오랫동안 지원받을 수 있는 버전

## Hello Kotlin 분석

- class가 없어도 main 메서드 하나로 println을 콘솔에 실행하고 있다.
- 실제로는 main 메서드는 **파일명을 기준으로 자동으로 클래스가 생성**된다.
    - Tools > Kotlin > Show Kotlin Bytecode에서 Decompile
        
        ```java
        public final class HelloKt {  // Kt는 파일의 확장자
        	public static final void main(@NotNull String[] args) {
        		Intrinsics.checkParameterIsNotNull(args, "args");
        		String var1 = "Hello Kotlin";
        		System.out.println(var1);
        	}
        
        	// $FF: synthetic method
        	public static void main(String[] var0) {
        		main();
        	}
        }
        ```
        

## main()에서 매개변수를 사용하는 경우

### 코드 보조에서 maina로 선택하는 경우

- main(args: Array<String>)
    
    ```kotlin
    fun main(args: Array<String>) {
    	println(args[0]) // 외부의 첫번째 인자
    	println(args[1]) // 외부의 첫번째 인자
    	println(args[2]) // 외부의 첫번째 인자
    }
    ```
    
- 프로그램 외부에서 인자를 받아들인다.

---

## 자료형과 변수

### 자료형

- Int : 정수
- String : 문자열
- Float : 실수
- …

### 변수

- val (value) : 불변형 (immutable)
    - 일단 선언하고 그 값을 초기화하면 더 이상 값을 바꿀 수 없다.
- var (variable) : 가변형 (mutable)
    - 나중에 값을 변경할 수 있다.

### 변수의 선언

```kotlin
// {선언 키워드} {변수 이름}: {자료형} = {값}
val username: String = "Kildong"

val username = "Kildong"  // 자료형을 추론하여 String으로 결정
var username  // 자료형을 지정하지 않은 변수는 사용할 수 없다.
var init: Int.  // 사용전 혹은 생성자 시점에서 init 변수를 초기화 해야한다.
val number = 10.  // number 변수는 Int 형으로 추론
```

- 뒤에 자료형은 생략 가능 (값 추론 가능할 경우)
- 자료형을 선언만 한 경우에는 추론할 수 없기 때문에 반드시 자료형을 명시해야한다.
- 선언 시 주의사항 (네이밍 규칙)
    - 변수 이름은 123abc와 같이 숫자로 시작해서는 안된다.
    - 변수 이름에는 while, if와 같이 코틀린에서 사용되는 키워드(예약어)는 사용할 수 없다.
    - 변수 이름은 의미 있는 단어를 사용하여 만드는 것이 좋다.
    - 여러 단어를 사용하여 변수 이름을 지을 경우 카멜 표기법을 사용하라.

## 네이밍 규칙

### 일반 변수, 함수명 등 (카멜 표기법)

- camelCase
- numberOfBooks
- myFirstNumber

### 클래스, 인터페이스 등 (파스칼 표기법)

- AnimalCategory
- CarEngine

## 자료형 알아보기

### 기본형 (Primitive data type)

- 가공되지 않은 순수한 자료형으로 프로그래밍 언어에 내장
- int, long, float, double 등
- **코틀린에서는 사용하지 않는다!**
- 성능 자체는 기본형이 더 좋다. 직접 데이터를 다루기 때문

### 참조형 (Reference type)

- 동적 공간에 데이터를 둔 다음 이것을 참조하는 자료형
- Int, Long, Float, Double 등
- 코틀린에서는 참조형만 사용하여 데이터를 관리한다.
    - **향후 컴파일 과정에서 기본형으로 변환된다. (성능을 위해!)**

### [Java] 기본형과 참조형의 동작 원리

```java
int a = 77; // 기본형
Person person = new Person();   //객체 참조형으로 person 객체를 위해 참조 주소를 가진다.
```

- stack 영역에 기본형 변수의 값과 객체의 참조 주소가 담긴다.
- 객체의 참조 주소는 Heap 영역(동적 공간)에 있는 객체를 참조한다.

### 정수형

![KakaoTalk_Photo_2023-01-13-02-11-52.jpeg](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/73459a30-0d49-4be5-9a2b-b56d0b8a5351/KakaoTalk_Photo_2023-01-13-02-11-52.jpeg)

- 부호 없는 정수형을 사용하면 두 배의 양수를 표현할 수 있다.
- 내가 다루고자하는 범위와 비슷한 형태의 자료형을 사용하는 것이 좋다.
- 자료형 사용 예시
    - 자료형 생략
        
        ```kotlin
        val num05 = 127     // Int 형으로 추론
        val num06 = -32768     // Int 형으로 추론
        val num07 = 2147483647     // Int 형으로 추론
        val num08 = 9223372036854775807     // Long 형으로 추론
        ```
        
        - 127은 Byte 형 안에 들어가지만, 기본형으로 자료형이 선언되는 타입은 Int
        - 추론은 무조건 Int (기본)
        - 단, 범위가 크면 Long
    - 접미사, 접두사 사용
        
        ```kotlin
        val exp01 = 123  // Int 형으로 추론
        val exp02 = 123L  // 접미사 L을 사용해 Long 형으로 추론
        val exp03 = 0x0F  // 접두사 0x를 사용해 16진 표기가 사용된 Int 형으로 추론
        val exp04 = 0b00001011  // 접두사 0b를 사용해 2진 표기가 사용된 Int 형으로 추론
        ```
        
    - 작은 값의 사용
        
        ```kotlin
        val exp08: Byte = 127  // 명시적으로 자료형을 지정 (Byte)
        val exp09 = 32767  // 명시적으로 자료형을 지정하지 않으면 short형 범위의 값도 Int형으로 추론
        val exp10: Short = 32767  // 명시적으로 자료형을 지정 (Short)
        ```
        
    - 부호 없는 정수 자료형
        
        ```kotlin
        val uint: UInt = 153u
        val ushort: UShort = 65535u
        val ulong: ULong = 46322342uL
        val ubyte: UByte = 255u
        ```
        
        - 뒤에 u를 붙여 unsigned 값을 표현할 수 있다.
    - 큰 수를 읽기 쉽게 하는 방법
        - 읽기 쉽게 하기 위해 언더 스코어 _ 를 포함해 표현
            
            ```kotlin
            val number = 1_000_000
            val cardNum = 1234_1234_1234_1234L
            val hexVal = 0xAB_CD_EF_12
            val bytes = 0b1101_0010
            ```
            

### 실수형

![KakaoTalk_Photo_2023-01-13-02-28-42.jpeg](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7a705c79-86d6-4275-9467-d23bbf3c97ed/KakaoTalk_Photo_2023-01-13-02-28-42.jpeg)

### 공간 제약에 따른 부동 소수점 연산의 단점

```kotlin
package chap02.section2

fun main() {
	var num: Double = 0.1
	
	for (x in 0..999) {  // 범위 연산자 사용
		num += 0.1
	}

	println(num)  // 100.09999999999999859
}
```

- 0.1을 1000번 더하면 100이 나와야하는데, 소수점 자리에 이상한 숫자가 나온다.

### 그 밖의 자료형

![KakaoTalk_Photo_2023-01-13-03-07-45.jpeg](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4fb23f6d-8ee9-47b2-93a0-138feee4268a/KakaoTalk_Photo_2023-01-13-03-07-45.jpeg)

### 문자열

- String으로 선언되며, String Pool이라는 공간에 구성
    
    ```kotlin
    package chap02.section2
    
    fun main() {
    	var str1: String = "Hello"
    	var str2 = "Word"
    	var str3 = "Hello"
    
    	println("str1 === str2: ${str1 === str2}")   // === : 참조가 같은지를 확인한다.
    	println("str1 === str3: ${str1 === str3}")
    	
    	// 출력결과
    	// false
    	// true
    }
    ```
    
- 문자열은 문자형이 배열로 있는 형태다.
- 문자열은 Heap 안에 있는 특수한 공간인 String Pool 안에 들어간다.
    - Stack 영역에는 해당 String pool 안에 있는 특정 주소를 참조하여 저장한다.
    - var로 선언된 **str1의 참조 주소는 가변형으로 바꿀 수 있다** (다른 값 지정 가능)
    - 하지만 **일단 선언되어 생성된 메모리 공간의 값은 변경되지 않는다**. (변경 불가능)
- 문자열 값을 변경하면 String Pool에 새로운 공간을 할당하고 값을 넣어 그 값의 주소를 참조하도록 변경한다.
- 내용물이 같으면 String Pool의 같은 주소를 참조하기 때문에 들어있는 값이 같다.
    
    ![KakaoTalk_Photo_2023-01-13-03-20-02.jpeg](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7dc60861-b582-4d48-8279-237f930f4b56/KakaoTalk_Photo_2023-01-13-03-20-02.jpeg)
    

## 표현식에서 문자열

### 표현식과 $ 기호를 사용하여 문자열 출력하기

```kotlin
var a = 1
val s1 = "a is $a".  // String 자료형의 s1을 선언하고 초기화. 변수 a가 사용된다.
```

---

## null을 허용한 변수 검사

- 코틀린의 변수 선언은 **기본적으로 null을 허용**하지 않는다.
    
    ```kotlin
    val a: Int = 30
    val b: String = "Hello"
    ```
    
    - 선언만 하고 아무 값이 들어있지 않을 때 해당 변수에 access 하려고 하면 오류가 발생한다.
    - 컴파일 단계에서 값이 없는 변수가 있다면 컴파일하지 않는다.
- **null 값이 가능하도록 선언**하려면 다음과 같이 작성한다.
    
    ```kotlin
    val a: Int**?** = null
    var b: String**?** = null
    ```
    
    - 이 형식대로 선언한 경우 null일 가능성이 존재하기 때문에 null 가능성을 검사해주는 것이 좋다.
    - 체크하지 않고 그냥 사용할 경우 NullPointerException이 발생한다.
        - 단순 출력은 상관 없으나 null인 상태에서 연산되는 멤버에 접근하고자 할 때
- NullPointerException은 자바스크립트, 자바 등에서 발생할 가능성이 존재한다.
    - 하지만, 코틀린은 기본적으로는 null을 허용하지 않기 때문에 안전하게 프로그래밍 할 수 있다.

## null 처리 방법 비교

- Kotlin에서는 기본적으로 NotNull이고 Nullable 표현에만 ‘?’가 사용된다.
    
    ```kotlin
    fun set(a: String, b: String?) {  // a: null 불가능, b: null 가능
    	//Do nothing
    }
    
    var temp: String? = null
    var size = -1
    if (temp != null) {
    	size = temp.length
    }
    
    // or
    
    var temp: String? = null
    val size = if (temp != null) temp.length else -1
    ```
    

## 세이프 콜과 non-null 단정 기호 활용

```kotlin
fun main() {
	var str1 : String? = "Hello Kotlin"
	str1 = null
	println("str1: $str1 length: ${str1.length}")  // null을 허용하면 length가 실행되지 않음
```

- Safe-call
    - str1?.length
- non-null 단정 기호
    - str1!!.length
    - 사용하지 않는 것이 좋다.

## 엘비스 연산자 사용

- str1?.length ?: -1

---

## 코틀린의 자료형 변환

- 기본형을 사용하지 않고 참조형만 사용
- 서로 다른 자료형은 변환 과정을 거친 후 비교

```kotlin
val a: Int = 1  // 정수형 변수 a를 선언하고 1을 할당
val b: Double = a  // 자료형 불일치 오류 발생
val c: Int = 1.1  // 자료형 불일치 오류 발생
```

- 변환 메서드 사용
    
    ```kotlin
    val b: Double = a.toDouble()  // 변환 메서드 사용
    ```
    
- 표현식에서 자료형의 자동 변환
    
    ```kotlin
    val result = 1L + 3  // Long + Int -> result는 Long
    ```
    
- 자바에서 타입 캐스팅 관련 공부를 좀 더 해야 할 것 같다!

### 변환 메서드 종류

- toByte: Byte
- toLong: Long
- toShort: Short
- toFloat: Float
- toInt: Int
- toDouble: Double
- toChar: Char

## 이중 등호와 삼중 등호

- == : 값만 비교하는 경우
- === : 값과 참조 주소를 비교할 때

```kotlin
val a: Int = 128
val b: Int = 128

println(a == b)  // true
println(a === b)  // true
```

- 자바에서는 ==에서 값과 참조 주소를 비교하기 때문에 주의해야한다.

### 참조 주소가 달라지는 경우

```kotlin
val a: Int = 128
val b: Int? = 128

println(a == b)  // true
println(a === b)  // false  
```

- a의 경우 컴파일러 내부에서는 기본형으로 사용된다. (int)
- b의 경우 **?가 있기 때문에 기본형이 아닌 객체**가 된다! (Integer)
