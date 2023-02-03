### if-else 문의 간략화

```kotlin
var max: Int
if (a > b)
	max = a
else
	max = b
```

```kotlin
val max = if (a > b) a else b
```

- 변수 선언 시 할당문 사용
- [의문] 자바도 가능한가? → 안됨
    
    ```kotlin
    public class MyClass {
        public static void main(String args[]) {
            int a = 1;
            int b = 10;
            int x = if (a > b) a else b;
            
            System.out.println("x: " + x);
        }
    }
    
    /MyClass.java:5: error: illegal start of expression
            int x = if (a > b) a else b;
                    ^
    /MyClass.java:5: error: not a statement
            int x = if (a > b) a else b;
                               ^
    /MyClass.java:5: error: ';' expected
            int x = if (a > b) a else b;
                                ^
    /MyClass.java:5: error: not a statement
            int x = if (a > b) a else b;
                                      ^
    4 errors
    ```
---
- return이 필요하면 람다보단 익명함수가 좋지만, [의문] 익명함수는 많이 쓰게 되면 어떤 원리로 이것을 사용하는지 혼란이 올 수 있다.
	- 익명 함수는 이름이 없기 때문에 많이 사용하는지 혼란이 올 수 있다.
	- 메소드 네이밍이 없기 때문!
