# 실행 결과

## step 1

- 랜덤하게 실행된다.

<img width="370" alt="스크린샷 2023-03-06 오전 11 53 42" src="https://user-images.githubusercontent.com/62871026/223008816-16e1be3c-c96b-43f2-818e-20e64ec6bc36.png">
<img width="373" alt="스크린샷 2023-03-06 오전 11 53 57" src="https://user-images.githubusercontent.com/62871026/223008864-890f0039-8514-4447-893e-5306fd4c8e34.png">
<img width="360" alt="스크린샷 2023-03-06 오전 11 55 53" src="https://user-images.githubusercontent.com/62871026/223009146-7913dfb6-d5a2-4b1b-a6fb-58e7a9141c06.png">
<img width="361" alt="스크린샷 2023-03-06 오후 12 01 40" src="https://user-images.githubusercontent.com/62871026/223009724-c8c27d17-6fe0-4723-a9e8-6907c8baf3e8.png">

## step 2

- [step 1](#step-1)과 실행 결과는 동일하다.
  - 리팩토링만 한 것이기 때문에

## step 3

- step-1, step-2도 같이 실행되도록 구현했다.
- step-1, step-2의 코드와 겹치는 부분이 많아 어떻게 해야 할지가 가장 큰 고민이다. 

<img width="668" alt="스크린샷 2023-03-06 오후 3 50 38" src="https://user-images.githubusercontent.com/62871026/223038807-d8e8c7e6-eae5-42c2-a01d-0b3f84076348.png">

## 논리적 오류 해결

- `|-----|-----|` 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
  - 위 요구 사항을 뒤늦게 봐서 boolean 깃발을 이용하는 방식으로 해결했다.
  - 몇 번을 실행해도 겹치지 않는다.

<img width="652" alt="스크린샷 2023-03-06 오후 4 05 19" src="https://user-images.githubusercontent.com/62871026/223041329-21a1cb85-2f59-44f9-bfad-8a6757a35c22.png">
<img width="656" alt="스크린샷 2023-03-06 오후 4 08 05" src="https://user-images.githubusercontent.com/62871026/223041795-be1689a5-08f7-4ae2-bb5d-5060544199d8.png">

## 두번째 논리적 오류 해결

- 위와 같은 방법은 사다리의 개수에 따른 해결 방법이 아님
- Participants 수에 따라 깃발의 접근 방식이 나뉘어야 하는데 그걸 인지하지 못했음
  - 깃발의 위치 수정
  - 한줄 한줄 출력할 때 깃발을 false로 바꿔줘야 위와 같은 논리적 오류가 발생하지 않음

<img width="652" alt="스크린샷 2023-03-06 오후 4 16 27" src="https://user-images.githubusercontent.com/62871026/223043213-8d5d50ac-98ee-4561-bee7-c579e8f31ab7.png">
<img width="809" alt="스크린샷 2023-03-06 오후 4 28 22" src="https://user-images.githubusercontent.com/62871026/223045385-7b77c4a4-89ea-4364-be76-2aa7fa3eb27b.png">