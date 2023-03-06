# Java Ladder
## 이번 미션에서 지킬 원칙
- PR cycle에 익숙해지기
- 처음에 완벽해지려고 생각하지 말고 계속 고치기
- 버전을 계속 관리하면서 했던 작업들을 다 기록하기
## ver 0.1 기능 체크리스트
- [x] Input Class - 값을 입력 받는 class
  - [x] inputPlayers() - 참여할 인원을 입력받고 반환
  - [x] inputHeight() - 최대 사다리 높이를 입력받고 반환
- [x] Ladder Class - 사다리를 만들고 관리하는 class
  - [x] instance variable
    - int players - 참여하는 인원
    - int height - 사다리의 높이
    - boolean[][] rungs - 사다리의 가로대
  - [x] Ladder(int players, int height) - 입력받은 인원 수와 높이에 맞춰 사다리 생성
  - [x] buildRungs() - 난수 값에 따라 가로대를 생성
  - [ ] getRungs() - 사다리의 rungs 정보를 배열로 반환
- [ ] Output Class - 사다리를 출력하는 class
  - [ ] printLadder(boolean[][] rungs) - 입력받은 사다리의 정보를 출력