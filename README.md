# Java Ladder
## Mission. 사다리 게임 1단계 - 기본 기능 구현
### 미션 설계
1. Application 클래스
   - Controller 클래스에 의존
   - main 메서드 안에서 run()
2. Controller 클래스
   - Input 클래스에 의존
   - Validation 클래스에 의존
   - Ladder 클래스에 의존
   - Encoding 클래스에 의존
   - Output 클래스에 의존
   - run()
     - output.printMessageN()
     - input.intputN()
     - validation.validateInputN()
     - output.printMessageM()
     - input.intputM()
     - validation.validateInputM()
     - ladder.createLadder(int[])
     - encoding.encodeOutput(String[][])
     - output.printLadder(String)
- Input 클래스
  - inputN(), n을 입력받는다.
  - inputM(), m을 입력받는다.
- Validation 클래스
  - validationInputN(int) : n이 int형이 아니면 예외처리
  - validationInputM(int) : m이 int형이 아니면 예외처리
  - validateInput(String)
- Ladder 클래스
  - createLadder(int[])
    - createLadderEmpty(int[]) : String[m][n+2] 크기로 빈 배열 생성
    - makeLadderLength : 사람 수 만큼 '|' 로 세로를 채우기
    - makeLadderWidth : 가로 사다리 만들기
      - createRandomLadderWidth() : 랜덤으로 '-'나 ' '을 반환
  - String[][] 형으로 완성된 사다리 반환
- Encoding 클래스
  - encoding.encodeLadder(String[][]) : String[][]으로 받은 사다리를 String 형으로 반환
- Output 클래스
  - printMessageN : N 입력을 위한 메세지 출력
  - printMessageM : M 입력을 위한 메세지 출력
  - printLadder(String) : String으로 받은 사다리를 화면에 출력


- Last Update: 2023-03-06

## 코드 리뷰

* [텍스트와 이미지로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://github.com/code-squad/codesquad-docs/blob/master/codereview/README.md)

* [동영상으로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://youtube.com/watch?v=lFinZfu3QO0&si=EnSIkaIECMiOmarE)
