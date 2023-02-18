## let()

- 함수를 호출하는 **객체 T를 이어지는 block의 인자로 넘기고 block의 결과값 R을 반환**
    
    ```kotlin
    public inline fun<T, R> T.let(block: (T) -> R): R {.. return block(this)}
    ```
    
    - 매개변수 block은 **T를 매개변수로 받아 R을 반환**
    - let() 함수 역시 R을 반환
    - 본문의 this는 객체 T를 가리키는데, 람다식 결과 부분을 그대로 반환한다는 뜻
    - 다른 메서드를 실행하거나 연산을 수행해야 하는 경우 사용

### let() 사용해보기

```kotlin
fun main() {
	val score: Int? = 32
	// var score = null

	// 일반적인 Null 검사
	fun checkScore() {
		if (score != null) {
			println("Score: $score")
		}
	}

	// let을 사용해 Null 검사를 제거
	fun checkScoreLet() {
		**score?.let** {println("Score: $it")}
		val str = score.let {it.toString()}
		println(str)
	}

	checkScore()
	checkScoreLet()
}
```

- score가 null 가능성이 있기 때문에 ?(세이프콜) 호출
    - null이 아니면 ?이후의 문장을 실행하고, null이면 아무 일도 일어나지 않음
- it은 score 자체를 let 안으로 복사해온다.

### let 함수의 체이닝(chaining)

- 체이닝이란 여러 메서드 혹은 함수를 연속적으로 호출하는 기법이다.

```kotlin
fun main() {
	var a = 1
	val b = 2

	a = a.let {it + 2}.let {
		println("a = $a")
		val i = it + b
		i
	}

	println(a)   // 5
}
```

- 최종적으로 i가 반환되어 a에 저장된다.
- 첫번째 블록의 처리결과를 다시 let 블록으로 넘겨 처리할 수 있다.
    - 이때는 블록의 마지막 식이 반환된다.
    - 코드의 가독성을 생각하면 많은 let은 사용하지 않는게 좋다.

### let의 중첩 사용

- 중첩 사용
    
    ```kotlin
    var x = "kotlin!"
    
    x.let { outer ->
    	outer.let {inner ->
    		print("Inner is $innder and outer is $outer")  // 이 때는 it이 아닌 명시적 이름 사용
    	}
    }
    ```
    
    - 중첩 사용의 경우 it으로 사용하기 힘들기 때문에 명시적인 이름이 필요하다.
    - x의 내용이 outer에 복사되고, outer는 inner로 다시 한 번 복사된다.
- 반환값은 바깥쪽의 람다식에만 적용
    
    ```kotlin
    var x = "Kotlin!"
    
    x = x.let {outer ->
    	outer.let {inner ->
    		print("Inner is $inner and outer is $outer")
    		"Inner String"  // 반환되지 않음
    	}
    	"Outer String"   // 이 문자열이 반한돼 x에 할당
    }
    ```
    

### [활용 예] 커스텀 뷰에서 let() 활용하기

- 안드로이드의 커스텀 뷰에서 padding 값을 지정
    
    ```kotlin
    val padding = TypedValue.applyDimension(
    	TypedValue.COMPLEX_UNIT_DIP, 16f, resources.displayMetrics).toInt()
    
    setPadding(padding, 0, padding, 0)   // 왼쪽, 오른쪽 padding 설정
    ```
    
    ```kotlin
    val padding = TypedValue.applyDimension(
    	TypedValue.COMPLEX_UNIT_DIP, 16f, resources.displayMetrics).toInt()
    .let {padding -> setPadding(padding, 0, padding, 0)   // 계산된 값을 padding이라는 이름의 인자로 받음
    			}
    ```
    
    ```kotlin
    val padding = TypedValue.applyDimension(
    	TypedValue.COMPLEX_UNIT_DIP, 16f, resources.displayMetrics).toInt()
    .let {padding -> setPadding(it, 0, it, 0)   // 패딩 대신 it 사용
    			}
    ```
    

### null 가능성 있는 객체에서 let() 활용하기

- null 검사
    - let을 세이프 콜(?.)과 함께 사용하면 If (null ≠ obj)와 같은 null 검사 부분을 대체
        
        ```kotlin
        var obj: String?   // null일 수 있는 변수 obj
        ...
        if (null != obj) {   // obj가 null이 아닐 경우 작업 수행(기존 방식)
        	Toast.makeText(applicationContext, obj, Toast.LENGTH_LONG).show()
        }
        ```
        
        ```kotlin
        obj?.let {    // obj가 null이 아닐 경우 작업 수행 (safe calls + let)
        	Toast.makeText(applicationContext, it, Toast.LENGTH_LONG).show()
        }
        ```
        
    - obj가 null이 아닌 경우에만 let 블록 구문을 수행하고, null이면 아무런 일도 하지 않게 되기 때문에 NPE 방지
- else문이 포함된 문장 대체
    
    ```kotlin
    val firstName: String?
    var lastName: String
    ...
    
    // if 문을 사용한 경우
    if (null != firstName) {
    	print("$firstName $lastName")
    } else {
    	print("$lastName")
    }
    ```
    
    ```kotlin
    // let을 사용한 경우
    firstName?.let { print("$it $lastName") } ?: print("$lastName")
    ```
    
    - ?: (엘비스 연산자)를 사용하면 더 편리하게 연산할 수 있다.

## also()

- also()는 함수를 호출하는 객체 T를 이어지는 블록에 전달하고 객체 T자체를 반환한다.
    
    ```kotlin
    // 표준 함수의 정의 let과 비교
    public inline fun <T, R> T.let(block: (T) -> R): R = block(this)
    
    public inline fun <T> T.also(block: (T) -> Unit): T {block(this); return this}
    ```
    
    - 람다식 안에 반환값은 없고, 함수 자체의 반환값은 자기 자신이다.
- also는 **블록 안의 코드 수행 결과와 상관없이 T인 바로 객체 this를 반환**
    
    ```kotlin
    var m = 1
    m = m.also {it + 3}
    println(m)  // 원본 값 1
    ```
    

### let, also 비교하기

```kotlin
fun main() {
	data class Person(var name: String, var skills: String)
	var person = Person("Kildong", "kotlin")

	val a = person.let {
		it.skills = "Android"
		"success"  // 마지막 문장을 결과로 반환
	}

	println(person)
	println("a: $a")   // String

	val b = persion.also {
		it.skills = "java"
		"success"    // 마지막 문장은 사용되지 않음
	}

	println(person)
	println("b: $b")   // Person의 객체 b
}
```

### 특정 단위의 동작 분리

- 디렉터리 생성 활용
    
    ```kotlin
    // 기존의 디렉터리 생성 함수
    fun makeDir(path: String): File {
    	val result = File(path)
    	result.mkdirs()
    	return result
    }
    ```
    
    ```kotlin
    // let, also를 통한 개선된 함수
    fun makeDir(path: String) = path.let{**File(it) (결과 R)**}.also{it.mkdirs()}
    ```
    
    - let은 식의 결과를 반환하고 그 결과를 다시 also를 통해 넘겨진다.
        - 이때 **중간 결과가 아니라 넘어온 결과만 반환**한다.

## apply()

- apply() 함수는 also() 함수와 마찬가지로 **호출하는 객체 T를 이어지는 block으로 전달하고 객체 자체인 this를 반환**
    
    ```kotlin
    // 표준 함수의 정의 let, also와 비교
    public inline fun <T, R> T.let(block: (T) -> R): R = block(this)
    public inline fun <T> T.also(block: (T) -> Unit): T {block(this); return this}
    
    public inline fun<T> T.apply(block: T.() -> Unit): T {block(); return this}
    ```
    
    - **T.()와 같은 표현에서 람다식이 확장 함수로서 처리**

### apply() 사용해보기

```kotlin
fun main() {
	data class Person(var name: String, var skills: String)
	var person = Person("kildong", "kotlin")

	// 여기서 this는 person 객체를 가리킨다.
	person.apply {this.skills = "Swift"}
	println(person)

	val retrunObj = person.apply {
		name = "Sean"   // this는 생략할 수 있다.
		skills = "Java"   // this 없이 객체의 멤버에 여러번 접근
	}

	println(person)
	println(returnObj)
}
```

```kotlin
Person(name=Kildong, skills=Swift)
Person(name=Sean, skills=Java)
Person(name=Sean, skills=Java)
```

- 추가 사항
    
    ```kotlin
    person.also {it.skills = "Java"}  //it으로 받고 생략할 수 없다.
    person.apply {skills = "Swift"}   // this로 받고 생략 가능
    ```
    

### 레이아웃을 초기화할 때 apply() 활용하기

- 레이아웃 초기 시 기존 코드
    
    ```kotlin
    // 기존 코드
    val param = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT)
    param.gravity = Gravity.CENTER_HORIZONTAL
    param.weight = 1f
    param.topMargin = 100
    param.bottomMargin = 100
    ```
    
    ```kotlin
    val param = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT).apply {
    	gravity = Gravity.CENTER_HORIZONTAL
    	weight = 1f  // param을 사용하지 않고 값을 직접 지정할 수 있다.
    	topMargin = 100
    	bottomMargin = 100
    }
    ```
    

### 디렉터리 생성 시 apply() 활용하기

```kotlin
// 기존 코드
fun makeDir(path: String): File {
	val result = File(path)
	result.mkdirs()
	return result
}

File(path).apply {mkdirs()}
```

## run()

- run() 함수는 **인자가 없는 익명 함수처럼 동작**하는 형태와 **객체에서 호출하는 형태** 두 가지로 사용된다.
    
    ```kotlin
    public inline fun <R> run(block: () -> R): R = return block()
    public inline fun <T, R> T.run(block: T.() -> R): R = return block()
    ```
    

### 간단한 사용 예시

```kotlin
var skills = "Kotlin"
println(skills)  // kotlin

val a = 10
skills = run {
	val level = "kotlin Level:" + a
	level  // 마지막 표현식이 반환된다.
}
println(skills)   // kotlin Level:10
```