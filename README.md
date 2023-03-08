# Java Ladder

- Last Update: 2023-03-06

## 코드 리뷰

* [텍스트와 이미지로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://github.com/code-squad/codesquad-docs/blob/master/codereview/README.md)

* [동영상으로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://youtube.com/watch?v=lFinZfu3QO0&si=EnSIkaIECMiOmarE)



## 학습 계획

- git flow (git branch 전략)
- commit message 규약(AngularJS commit conventions)
- 객체지향 생활체조 원칙
- Junit 5
- 클린코드
- SOLID

## 1단계 미션

### 구현할 기능 목록

- 참여할 사람의 수를 입력 받는다. ✅
- 최대 사다리 높이를 입력 받는다. ✅
- 참여한 사람은 사다리 높이에 맞게 랜덤한 사다리 라인을 가진다. ✅
  - 2차원 배열을 이용한다. ✅
- 사다리를 출력한다. ✅

### 실행 결과

```tex
참여할 사람은 몇 명인가요?
3
최대 사다리 높이는 몇 개 인가요?
5

|-| |
| | |
|-|-|
| |-|
|-|-|
```

## 2단계 미션

### 학습 계획

- char
- String
- StringBuilder, StringBuffer 차이점
- Generic
- Git

### 구현할 기능 목록

- 메서드의 크기가 최대 10라인을 넘지 않도록 구현한다.✅
- 들여쓰기 depth를 2단계에서 1단계로 줄여라.✅
- else를 사용하지 마라.✅
- 구현 순서를 고려하면서 프로그래밍한다.✅
- naming convention을 지키면서 프로그래밍한다.✅

## 3단계 미션

### 학습 계획

- 객체지향적 설계
  - 결합도
  - 응집도
- 단위 테스트
  - 기능에 대한 특정 요구사항이 있어서 해당 기능이 잘 작동하는지 확인.
- 일급 컬렉션

### 구현할 기능 목록

- 참여할 사람 이름을 입력 받는다.
  - 사람의 이름은 쉼표로 구분한다.
  - 사람의 이름은 최대 5글자이다.
  - 참여할 사람은 최소 2명이다.
- 참여할 사람 이름을 출력한다.
- 사다리 라인이 겹치지 않도록 한다.
- 사다리 객체에서 배열 대신 ArrayList와 Generic을 구현한다.
