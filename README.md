# Java Ladder 학습 계획

### 1 단계 : Ladder 객체를 위한 클래스 생성 및 구현
  - 사다리의 라인만 표시하는 2차원 배열 구현
  - n명의 사람과 m개의 사다리 개수 = (n - 1) * m 짜리 배열로 구현 후 출력 시 | 붙여줌.
  - 랜덤값으로 라인이 있는지 없는지만 표시
  - 문제 상황
    - char[] 배열은 스트림으로 변환할 수 없다. -> CharStream이 존재하지 않음.
    - intelliJ 한글 깨짐 현상
  - 해결
    - char[] 배열을 String 배열로 변환
    - 참고: https://da-nyee.github.io/posts/intellij-console-encoding-issue/

### 2 단계 : 코드 리팩토링
  - else문 제거
  - 들여쓰기가 2이상인 메소드 분리
  - Naming Convention

### 3 단계 : 사다리 모양 개선
  - 사람 이름은 5자 기준, 사다리 폭도 그에 맞게 고려해야함.
  - 라인이 겹치지 않게 해야함.(양 옆에 라인이 올 수 없다.)
  - 배열을 Generic + List로

### 4 단계 : 리팩토링과 TDD
  - TDD란 무엇인가?
  - 일급 객체와 리팩토링?
  - 패키지 분리는 어떻게 해야 좋은가?
  - 접근 제어자를 효율적으로 사용하려면 어떻게 해야하는지?

### 5 단계 : 실행결과 출력
  - Setter을 지양해야 하는 이유는 무엇일까?

## 코드 리뷰

* [텍스트와 이미지로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://github.com/code-squad/codesquad-docs/blob/master/codereview/README.md)

* [동영상으로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://youtube.com/watch?v=lFinZfu3QO0&si=EnSIkaIECMiOmarE)
