# Step-3 : 사다리 모양 개선하기
- 2023.03.08(수)

---

# 계획/고민 거리
## [1] 사다리를 배열대신 List로 변경하기 ✅ (2h)
1. [배열대신 List로 변경하기] 이차원 배열처럼 List 안에 List를 넣을지 다른 객체를 만들지
   1. `List<List<Charactor>`로 변경

### 사다리 배열을 List로 변경하니 OutputView 까지 변경하게 되어있다 ✅
- 기존 사디리 출력 방식:
  - 사다리를 출력하기 위해 Ladder에서 getter로 사다리 배열을 반환한고, OutputView가 배열 출력 로직을 처리하였다.
  - 이렇게 하니 Ladder에서 사다리 배열을 List로 변경할 때 OutputView의 배열 출력 로직을 List 출력 로직으로 변경해야 됐다
  - Ladder에서 toString 메서드를 오버라이딩 하여 문자열을 반환해주는 식으로 변경해야 겠다

## [2] 사용자 이름 입력받기 ✅ (1h)
1. 사용자 이름은 어디에 저장할 것인가? 
   1. Players 객체를 따로 만들기 
      - input 한 이름들을 배열로 반환하게 되는데, 이를 다른 객체에서 처리하게 되면 변경이 어려운 코드가 될 것 같아서
      - 출력시 Players에서 문자열을 만들어 출력하도록 할 예정
   2. InputView에서 이름 입력 받기
   3. Players에 저장 - GameController가 해줄 예정
   4. 사용자 수를 구하여 Ladder로 넘겨주기 -> Ladder 객체 만들기

### 유효성 검사는 어디서 하는게 좋을까? - InputView vs Players ✅
- 객체의 역할을 먼저 생각해 보자
  - InputView : 사용자로 부터 입력받기
  - Player : 사용자들에 관한 정보를 저장/제공
- 입력값 검증은 입력에 더 가까운 걸까?
- InputView는 Player 외 여러가지 정보를 입력받을 수 있다 -> 그래서 뭐 어쩌라고?
  - Player 이름들, Ladder의 높이
  - InputView가 보든 입력값을 검증하게 되면 유지보수할 때 헷갈릴 것 같다
- 각 객체별로 Validation 객체를 따로 두자
  - PlayersValidation, LadderValidation : 각 객체(Players, Ladder)에 관한 입력값을 검증하는 역할
  - InputView 에 Validation을 다 넣으면 의존성이 많이 생겨서 싫다
  - 이걸 어디서 사용하면 되지? 각 객체를 생성할 때 생성자에서 하기?

- 아! 아직 미래는 생각하지 말고 처음 생각한 대로 InputView에서 하자

### 이름이 똑같으면 어떻게 될까?
- 게임 진행에 문제가 생길수도 있을것 같다.
  - 아니? 이름은 배열로 받기 때문에 배열 index로 처리하면 문제 없을수도 있지 않을까?
  - 다음 단계에서 생각해 보자

## [3] 사다리 bridge를 겹치지 않게 하기 ✅ (1h)
1. 사디리 한 칸에 bridge가 있다는 것을 어떻게 나타낼 수 있을까?
   1. 단순히 List의 index로 왼쪽/오른쪽에 접근하여 bridge가 있는지 확인하기? 다른 방법이 생각나지 않는다.

## [4] 사다리의 bridge 길이 늘리기 ✅ (1h)
1. 이건 Ladder의 toString() 에서 만들어 주기
   1. 출력시 세로선 사이는 5칸으로 만들어 주기
   2. 다리가 있으면 '-' 를 5개로 만들어 주기
   3. 이걸 사다리 초기화 시 EMPTY_SPACE 변수를 `'-----'` 이렇게 해줘도 될 듯
      - 그럼 char에서 다시 String으로 바꿔야 된다
      - String 타입으로 보관하고 그대로 출력하는 것과 char로 보관하고 출력할때 연산하는 것 중 어느것이 더 이득일까?
      - 차이는 repeat이 반복문이라면 toString()의 시간 복잡도가 $n^{2}$에서 $n^{3}$ 으로 늘어남. n은 5
      - String으로 보관하면 메모리는... List의 String 참조공간 마다 8 byte 씩(stack area), heap area에 `-----`10byte, `     `10byte <- 이걸 리터럴로 공유하는 건가?
      - char로 보관하면 메모리는... List<Character> 는 어떤식으로 메모리에 저장되는지 모르겠다
   4. 답 안나오니 그냥 char로 하자!
   
## [5] 사다리 출력시 이름도 출력하기 ✅ (0.25h)
1. OutputView에서 User를 매개변수로 받아 출력하기
