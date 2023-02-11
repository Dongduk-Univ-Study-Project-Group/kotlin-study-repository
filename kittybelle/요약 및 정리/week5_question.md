### [질문 1] 6-4 댓글 : 객체 변경

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/de1c44e2-b10e-482a-b3bb-c5f472e2cb51/Untitled.png)

- 객체 내부의 값을 바꾼다는 것의 의미
- 자바로 돌려보자.
    - 해당 내용은 함수로 객체의 필드 값을 변경하는 것으로, 자바에서는 setter, getter로 바꾸는 것과 비슷함
    - 객체 : final 상수로 선언해도 세터, 게터로 잘 바뀐다!!
    - int : 상수로 선언하면 안바뀐다.
- 기본형은 안되고 참조형은 변경 가능!!! 주소값을 참조한다는 것의 의미 (heap 영역)

### [질문 2] 6-6 RunTest.kt

```kotlin
fun main() {
    // apply와 run 비교
    data class Person(var name: String, var skills: String)
    var person = Person("KittyBelle", "Kotlin")

    val returnObj = person.run { // apply에서는 person 객체 자기 자신 반환
        this.name = "SomSom"
        this.skills = "Java"
        "Success" // 반환됨
    }
    println(person)
    println("returnObj: $returnObj")

    val returnObj2 = person.apply {// run과 비교하기
        this.name = "Elsa"
        this.skills = "Python"
        "Success" // 반환 안됨
    }
    println(person)
    println("returnObj2: $returnObj2")
}
```

- 반환한다더니 실행결과 똑같은 이유는?
    - run apply 차이
    - 반환하지 않는다는 apply의 단점을 run이 보완함!
- 메소드명을 잘못써서 실행결과가 같게 나왔던 것
