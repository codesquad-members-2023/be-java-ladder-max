# Java Ladder

- Last Update: 2022-12-28

## 코드 리뷰

* [텍스트와 이미지로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://github.com/code-squad/codesquad-docs/blob/master/codereview/README.md)

* [동영상으로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://youtube.com/watch?v=lFinZfu3QO0&si=EnSIkaIECMiOmarE)

<br/>

---

<br/>

Last Update: 2023-03-06

# 🪜 사다리 게임

- 기간(1주차): 23-03-06 ~ 23-03-10 [5d]
- 2023 코드스쿼드 BE max에서 진행한 `사다리 게임`을 구현하는 미션

## 🖥 출력 예시

```
참여할 사람은 몇 명인가요?
3
최대 사다리 높이는 몇 개인가요?
5

|-| |
| |-|
|-|-|
| |-|
|-| |
```

## ⚠️ [PR 가이드](https://github.com/code-squad/codesquad-docs/blob/main/codereview/README.md)

- 미션의 각 단계를 마무리 한 후 PR을 보낸다.
- PR 보낼때 label 설정: 각 단계별 라벨 (ex: step-1) 을 지정해서 보낸다.

## ✔️ 1단계 - 기능 요구사항

- [X] n명의 사람을 입력하는 기능
- [X] n개의 사다리 개수를 입력하는 기능
- [X] 랜덤으로 사다리를 생성하는 기능
    - 사다리가 있으면 `-` 표시, 없으면 `" "`(공백문자) 표시, 양옆에는 `|`로 표시
- [ ] 사다리를 출력하는 기능

