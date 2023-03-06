# Java Ladder

- 1 단계 : Ladder 객체를 위한 클래스 생성 및 구현
  - 사다리의 라인만 표시하는 2차원 배열 구현
  - n명의 사람과 m개의 사다리 개수 = (n - 1) * m 짜리 배열로 구현 후 출력 시 | 붙여줌.
  - 랜덤값으로 라인이 있는지 없는지만 표시
  - 문제 상황
    - char[] 배열은 스트림으로 변환할 수 없다. -> CharStream이 존재하지 않음.
    - intelliJ 한글 깨짐 현상
  - 해결
    - char[] 배열을 String 배열로 변환
    - 참고: https://da-nyee.github.io/posts/intellij-console-encoding-issue/

## 코드 리뷰

* [텍스트와 이미지로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://github.com/code-squad/codesquad-docs/blob/master/codereview/README.md)

* [동영상으로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://youtube.com/watch?v=lFinZfu3QO0&si=EnSIkaIECMiOmarE)
