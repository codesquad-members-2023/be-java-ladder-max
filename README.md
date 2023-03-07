# Java Ladder
## 이번 미션에서 지킬 원칙
- PR cycle에 익숙해지기
- 처음에 완벽해지려고 생각하지 말고 계속 고치기
- 버전을 계속 관리하면서 했던 작업들을 다 기록하기
## 구현 기능 목록
- Input Class - 값을 입력 받는 class
  - inputPlayers() - 참여할 인원을 입력받고 반환
  - inputHeight() - 최대 사다리 높이를 입력받고 반환
- Ladder Class - 사다리를 만들고 관리하는 class
  - instance variable
    - int players - 참여하는 인원
    - int height - 사다리의 높이
    - boolean[][] rungs - 사다리의 가로대
  - Ladder(int players, int height) - 입력받은 인원 수와 높이에 맞춰 사다리 생성
  - buildRungs() - 난수 값에 따라 사다리 전체의 가로대를 생성
    - buildRungRow() - 사다리의 폭을 입력받아 가로대 한줄을 생성
      - buildSingleRung() - 난수를 이용하여 사다리 가로대 하나를 생성
  - getRungs() - 사다리의 rungs 정보를 배열로 반환
- Output Class - 사다리를 출력하는 class
  - printLadder(boolean[][] rungs) - 입력받은 사다리의 정보를 출력
    - writeOneRow(boolean[] rungRow) - 입력받은 rung의 배열에 따라서 stringBuilder를 사용하여 문자열로 변환
      - convertRungToString(boolean rung) - 입력받은 boolean값을 String으로 변환하여 반환
## 변경 사항 모음
### ver 0.1 내용
- Input Class - 값을 입력 받는 class
  - inputPlayers() - 참여할 인원을 입력받고 반환
  - inputHeight() - 최대 사다리 높이를 입력받고 반환
- Ladder Class - 사다리를 만들고 관리하는 class
  - instance variable
    - int players - 참여하는 인원
    - int height - 사다리의 높이
    - boolean[][] rungs - 사다리의 가로대
  - Ladder(int players, int height) - 입력받은 인원 수와 높이에 맞춰 사다리 생성
  - buildRungs() - 난수 값에 따라 가로대를 생성
  - getRungs() - 사다리의 rungs 정보를 배열로 반환
- Output Class - 사다리를 출력하는 class
  - printLadder(boolean[][] rungs) - 입력받은 사다리의 정보를 출력
### ver 0.2 패치노트
- Ladder 클래스의 buildRungs() 메서드 메서드
  - buildRungs() 메서드가 2중 반복문을 포함하고 있어 가독성을위해 buildSingleRung(), buildRungRow 메서드로 분리했습니다.
- Output 클래스의 printLadder() 메서드 분리
  - printLadder()메서드가 2중 반복문을 포함하고 있어 가독성을 위해 분리
- Output 클래스의 printLadder() 메서드 리팩토링
  - print메서드를 계속 호출하여 구현했었는데 너무 보기 어렵습니다. 그래서  StringBuilder 메서드를 사용하여 구현했습니다.
