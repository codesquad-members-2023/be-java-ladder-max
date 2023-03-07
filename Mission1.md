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
    - validationInputN(int) : n이 int형이 아니면 예외처리, n이 0보다 크지 않으면 예외처리
    - validationInputM(int) : m이 int형이 아니면 예외처리, m이 0보다 크지 않으면 예외처리
    - validationInputInteger(String)
    - validationInputPositive(int)
- Ladder 클래스
    - createLadder(int[])
        - createLadderEmpty(int[]) : String[m][n+2] 크기로 빈 배열 생성
        - makeLadderLength : 사람 수 만큼 '|' 로 세로를 채우기
        - makeLadderWidth : 가로 사다리 만들기
            - createRandomLadderWidth() : takeRandom()에서 반환된 값을 laddersFrame에 저장
                - LadderLine의 takeRandom()에서 랜덤으로 '-'나 ' '을 반환
    - String[][] 형으로 완성된 사다리 반환
- Encoding 클래스
    - encoding.encodeLadder(String[][]) : String[][]으로 받은 사다리를 String 형으로 반환
- Output 클래스
    - printMessageN : N 입력을 위한 메세지 출력
    - printMessageM : M 입력을 위한 메세지 출력
    - printLadder(String) : String으로 받은 사다리를 화면에 출력
- LadderLine Enum 클래스
    - stick : "-", blank : " "
    - takeRandom() : 랜덤으로 값을 반환


### 구현 결과
![ex1](https://user-images.githubusercontent.com/57451700/223053238-f18c4736-4bfa-447d-8523-7b41c78737da.png)    
![ex2](https://user-images.githubusercontent.com/57451700/223053325-ac5e56fc-ad65-4853-b21c-24ccdd033d0c.png)    
![result](https://user-images.githubusercontent.com/57451700/223053367-cc43a79e-c92a-4bfb-9d24-85f13e9e9c70.png)    
