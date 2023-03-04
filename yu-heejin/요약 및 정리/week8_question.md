- [의문] 객체 == 인스턴스? 갑자기 헷갈린다. 클래스 → 객체(인스턴스)?
    - 클래스의 타입으로 선언되었을 때 객체라고 부르고, 그 객체가 메모리에 할당되어 실제 사용될 때 인스턴스라고 부른다.
    [https://gmlwjd9405.github.io/2018/09/17/class-object-instance.html](https://gmlwjd9405.github.io/2018/09/17/class-object-instance.html)


- [의문] 자바도 프로퍼티라는 말을 쓰지않나..?
    - **프로퍼티 = field + getter/setter**
    - 프로퍼티는 실제로 데이터가 저장되는 공간(Field), 저장된 값을 읽으려고 할 때 호출되는 함수(Getter), 그리고 값을 저장하려고 할 때 호출되는 함수(Setter)로 이루어져 있다.

## Kotlin에서의 private

### 변수를 private로 설정한 경우

```kotlin
package com.study.dongamboard.domain.post.entity

class Post {
    private var title: String = "title"
}

fun main() {
    var post = Post()

    println(post.title)  // Cannot access 'title': it is private in 'Post'
}
```

- 디컴파일 결과는 다음과 같다.
    
    ```java
    public final class Post {
       private String title = "title";
    }
    ```
    

### 변수를 public으로 설정한 경우

```java
package com.study.dongamboard.domain.post.entity

class Post {
    var title: String = "title"
}

fun main() {
    var post = Post()

    println(post.title)
}
```

- 디컴파일 결과는 다음과 같다.
    
    ```java
    public final class Post {
       @NotNull
       private String title = "title";
    
       @NotNull
       public final String getTitle() {
          return this.title;
       }
    
       public final void setTitle(@NotNull String var1) {
          Intrinsics.checkNotNullParameter(var1, "<set-?>");
          this.title = var1;
       }
    }
    ```
    
    - 변수 자체를 private로 하고, 게터와 세터가 자동으로 추가된다.
- 게터를 따로 정의할 수도 있다.
    
    ```java
    package com.study.dongamboard.domain.post.entity
    
    class Post {
        private var title: String = "title"
    
        fun getTitle(): String {
            return title
        }
    }
    
    fun main() {
        var post = Post()
    
        println(post.getTitle())
    }
    ```