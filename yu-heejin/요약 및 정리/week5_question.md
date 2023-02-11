## 의문점 해결

```kotlin
val **isPositive**: (Int) -> Boolean = {
	val **isPositive** = it > 0
	isPositive   // 마지막 표현식이 반환된다.
// 마지막 라인이 true 혹은 false로 정해져서 해당 값이 반환된다.
}

val isPositiveLabel: (Int) -> Boolean = number@ {
	val isPositive = it > 0
	return@number isPositive    // 라벨을 사용하여 반환된다.
}
```

- [의문] 내부에 같은 변수 이름을 사용할 수 있나..?
    - 인텔리제이에서 오류는 안 난다!
    - 함수 내부에서는 사용해도 되는 것 같다.

- 이러한 구조가 가능한 이유는 result라는 이름의 참조를 전부 감싸서 특수한 데이터 구조로 만들어 놓기 때문이다. (?)
    
    ```kotlin
    calc.addNum(2, 3, (Function2)(new Function2() {
         // $FF: synthetic method
         // $FF: bridge method
         public Object invoke(Object var1, Object var2) {
            this.invoke(((Number)var1).intValue(), ((Number)var2).intValue());
            return Unit.INSTANCE;
         }
    
         public final void invoke(int x, int y) {
            result.element = x + y;
         }
      }));
    ```
    
    - 자바로 디컴파일 해보니까 **람다는 익명 객체를 만들어서 그 내부에 함수를 만들어서 사용한다.**
    - **자바 Ref.IntRef로 래핑한 후 참조한다! 자바는 final밖에 포획이 안되기 때문이다.**
    
- result의 경우 람다식 내부에서 재할당되어 사용된다. [미해결]
    - 이 때 할당된 값은 유지되어 출력문에서 사용할 수 있다.
    - 클로저에 의해 독립된 복사본을 가지고 사용되는 것
    - 값을 변경할 수 있는데 왜 독립된 복사본?

### 함수의 매개변수에 접근

```kotlin
fun filteredNames(length: Int) {
	val names = arrayListOf("kim", "Hong", "Go", "Hwang", "Jeon")
	val filterResult = names.filter **{**
		// filterName의 길이와 컬랙션의 길이를 비교
		it.length == length   // 바깥의 length에 접근
	**}**
	println(filterResult)
}
...
```

- 함수 자체를 같이 포획해 해당 매개변수에 접근한다.
- filter는 names에 있는 확장 함수이며, 람다식의 형태로 되어있다.
- 전반적으로 뭔 말인지 잘 모르겠다! [미해결]

→ 미해결된 문제는 다음주까지 알아오기
