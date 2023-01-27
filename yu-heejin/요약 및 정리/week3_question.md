## 궁금한 점 정리

[의문] 라벨 표기법이란?

- 인라인으로 선언되지 않은 람다식 함수에서 리턴을 사용하는 경우, 그냥 사용할 수 없으며 라벨 표기(@label)표기와 함께 사용해야한다.
- 이름 붙은 반복문이랑 비슷한 기능인 것 같다.
- [https://velog.io/@sangh00n/코틀린-Label-표현식](https://velog.io/@sangh00n/%EC%BD%94%ED%8B%80%EB%A6%B0-Label-%ED%91%9C%ED%98%84%EC%8B%9D)
- [https://backtony.github.io/kotlin/2022-04-12-kotlin-basic-3/](https://backtony.github.io/kotlin/2022-04-12-kotlin-basic-3/)

[의문] inline을 붙였는데 분기하는 이유는? - 미해결

![스크린샷 2023-01-27 오전 1.46.26.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4fa2f75f-f0d8-40ff-a335-562e8ca7fe09/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2023-01-27_%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB_1.46.26.png)

[의문] 지역 함수와 인라인 함수의 차이점? (분기하는가?)

- 지역함수는 분기하고 인라인 함수는 분기하지않는다
- 인라인은 스택에 함수가 쌓이는 구조가 아니라 코드 자체가 복사되기 때문이다.

[의문] 전역변수는 어떤 메모리를 사용하는가?

- 데이터 영역에 저장된다!
- [https://snupi.tistory.com/9](https://snupi.tistory.com/9)
- [https://medium.com/@cocoa3078/kotlin과-java의-가장-바닥-d51db10b87b7](https://medium.com/@cocoa3078/kotlin%EA%B3%BC-java%EC%9D%98-%EA%B0%80%EC%9E%A5-%EB%B0%94%EB%8B%A5-d51db10b87b7)