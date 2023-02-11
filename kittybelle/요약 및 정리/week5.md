## 6-2 널 포획해야겠어! 클로저(Closure)

### 클로저

- **람다식으로 표현된 내부 함수**에서 외부 범위 변수에 접근 가능하다는 개념
- 값을 가져옴 → **참조형**
- 람다식 내의 외부 변수는 값 유지를 위해 람다가 포획(capture)한 변수

```kotlin
fun main() {

    val calc = Calc()
    var result = 0 // 외부의 변수
    calc.addNum(2,3) { x, y -> result = x + y }  // 클로저
    println(result) // 값을 유지하여 **5가 출력**
}

class Calc {
    fun addNum(a: Int, b: Int, add: (Int, Int) -> Unit) { // 람다식 add에는 반환값이 없음
        add(a, b)
    }
}
```

- 람다식은 Unit이지만, 외부 변수 result에 접근하여 5출력

```kotlin
// 길이가 일치하는 이름만 반환
fun filteredNames(**length**: Int) {
    val names = arrayListOf("Kim", "Hong", "Go", "Hwang", "Jeon")
    val filterResult = names.filter {
        it.length == **length** // 바깥의 length에 접근 
    }
    println(filterResult)
}
...
filteredNames(4)
```

- 모소에서는 매개변수 pos 값을 final static int position으로 붙잡았었음.
- 코틀린에서는 바깥의 length에 접근하는 것이 가능하여서 두 length의 길이 비교가 가능

## 6-3 너 한 일은 결과와 함께 반환해, 알았지? - let()

### 코틀린 제공 표준 라이브러리 함수

- let(), apply(), with(), also(), run()
- **확장 함수 형태의 람다식**으로 구성
- 코드 단순화 가능

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7c2a54db-fe12-48b5-b00f-7bb1ba8972c5/Untitled.png)

- T : 형식 매개변수
    - 어떠한 데이터 타입도 가능함
- it ↔ this
    - it : 값을 **복사**하여 가져옴
    - this : 자기 **자신 참조**
    

### let()

- 함수를 호출하는 객체 T를 이어지는 block의 인자로 넘기고 결과값 R 반환
- `public inline fun <T, R> T.let(block: (T) -> R): R { ... return block(this) }`
    - T : 어떤 요소
    - R : 반환
    - 어떤 타입 T도 let으로 확장 가능
- **it**과 **세이프콜 ?. 이용 → null 검사 대체**
    
    ```kotlin
    		val score: Int? = 32
    
    		// null 가능성 -> if문으로 체크하는 것이 일반적
    		fun checkScore() {
    				if (score != null) 
    						println("Score: $score")
    		}
    
        // let을 사용 -> ?. safe call 이용하여 null 검사를 제거
        fun checkScoreLet() {
            score?.let { println("Score: $it") } // ① score을 it으로 받아옴
            val str = score.let { it.toString() } // ②
            println(str)
        }
    ```
    
- **체이닝**
    - 여러 메소드나 함수를 연속 호출
    - 코드 가독성을 위해 너무 많이 사용은X
    
    ```kotlin
    var a = 1
    var b = 2
    
    a = a.let { it + 2 }.let { // it + 2 = 3
        val i = it + b
        i  // 마지막 식 반환
    }
    println(a) //5
    ```
    
- 중첩 사용
    - it 사용 어려움
    - 명시적으로 이름(outer) 사용
    - **반환값은 바깥쪽 람다식에만** 적용됨
    
    ```kotlin
    var x = "K"
    x.let { outer ->
    		outer.let { inner ->
    				print("Inner is $inner and outer is $outer")
    				"Inner String" // 반환되지 않음	
    		}
    		"Outer String" // 반환되어 x에 할당
    }
    ```
    
- 안드로이드 커스텀뷰에서 padding 값 지정
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b769eb25-9e47-4e48-9acb-e36f43ef16e2/Untitled.png)
    
    - 별도의 padding 변수 생성 없이 it을 사용하여서 메모리 공간 절약

## 6-4 너 할 일 해. 난 그냥 반환할게. 올쏘! - also()

### also

- **반환값이 없다**는 점에서 let과 차이
- 객체 T 자체를 반환 → 코드 수행 결과와 관계없이 **T 객체 this를 반환**
- `public inline fun <T> T.also(block: (T) -> Unit): T { block(this); return this }`
    
    ```kotlin
    var m = 1
    m = m.also { it + 3 } // m 객체를 넣어서 it으로 받아 4가 된다. 하지만 4반환X
    println(m) // 원본 값 1 반환!!
    ```
    

### it과 also의 활용 → 디렉토리 생성

```kotlin
fun makeDir(path: String): File {
		val result = File(path)
		result.mkdirs()
		return result
}

fun makeDir(path: String) = path.let{ File(it) }.also{ it.mkdirs() }
```

- let : 식의 결과 반환 → 이 결과는 다시 also로 넘겨짐.
- 중간 결과가 아닌, 넘어온 결과만 반환

## 6-5 널 확장시켜 놓고 난 반환한다. - apply()

### apply()

- also처럼 호출하는 객체 T를 전달 후, 객체 자체인 this 반환
    - 차이점 : (T)로 받아서 처리하지 않고, T.()의 형태로 람다식이 확장함수로서 처리
    - 괄호 안에 (T)로 T를 넘기는 게 아니라서 it을 사용하지 않고, this를 사용
    
    ```kotlin
    // let
    public inline fun <T, R> T.let(block: (T) -> R): R { ... return block(this) }
    
    // also
    public inline fun <T> T.also(block: (T) -> Unit): T { block(this); return this }
    
    // apply
    public inline fun <T> T.apply(block: T.() -> Unit): T { block(); return this }
    ```
    
- 안드로이드 스튜디오 활용
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/62708506-bf0c-4edf-96f6-02e66693e5c7/Untitled.png)
    
    - apply → 반복되는 param. 코드 간결
    - this로 받고, this.gravity… this 생략한 것
- 디렉토리 생성 활용
    
    ```kotlin
    fun makeDir(path: String): File {
    		val result = File(path)
    		result.mkdirs()
    		return result
    }
    
    File(path).apply{ mkdirs() }
    ```
    

## 6-6 그냥 실행하고 결과를 반환 - run()

### run()

- 2가지 방식
    - `public inline fun <R> run(block: () -> R): R  = return block()`
        - block 내용 수행 후 결과를 함수의 반환값으로 사용 → block 자체를 반환하는 형태
    - `public inline fun <T, R> T.run(block: T.() -> R): R = return block()`
        - 확장함수 형태로 나온 결과물을 반환

```kotlin
val a = 10
skills = run {
    val level = "Kotlin Level:" + a
    level // 마지막 표현식이 반환됨
}
println(skills) // Kotlin level: 10 출
```

- 반환한다는 점에서 apply의 단점 보완

## 6-7 난 단독으로 실행돼 반환하는 녀석이지 - with()

### with

- `public inline fun <T, R> with(receiver: T, block: T.() -> R): R  = receiver.block()`
    - T를 담아두는 매개변수 receiver가 존재
- 단점
    - 세이프콜(?.)을 지원X → let과 함께 사용
    
    ```kotlin
    supportActionBar?.let {
        with(it) {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_clear_white)    
        }
    }
    
    supportActionBar?.run {
        setDisplayHomeAsUpEnabled(true)
        setHomeAsUpIndicator(R.drawable.ic_clear_white)
    }
    ```
    
- 기본적으론 Unit 반환
    - 필요 시 식을 입력하여 마지막 표현식 반환 가능
    - WithTest.kt 참고

## 6-8 사용했으면 닫어! 쫌! - use()

### use()

- 확장함수의 형태로, T.use
- `public inline fun <T : Closeable?, R> T.use(block: (T) -> R): R`
- 파일 읽기
    - 파일 열고, 사용하고, 닫던 과정
    - 코틀린으로 한줄로 축약 가능
    
    ```kotlin
    fun main() {
    
        PrintWriter(FileOutputStream("d:\\test\\output.txt")).use {
            it.println("hello")
        }
    }
    ```
    
    - use의 구현부분 참고
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e86736e8-656c-476b-97c8-a2308ea0c44c/Untitled.png)
    

## 6-9 자주 사용되는 기타 표준 함수

### takeIf(), takeUnless()

- **takeIf()** : 람다식이 **true** → 객체 T반환, 그렇지 않다면 null 반환
- **takeUnless()** : 람다식이 **false** → 객체 T반환, 그렇지 않다면 null 반환
    
    ```kotlin
    public inline fun <T> T.takeIf(predicate: (T) -> Boolean): T?
      = if (predicate(this)) this else null
    ```
    
- if문 간략화
