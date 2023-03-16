<<<<<<< HEAD
# **기능요구사항**

- [X]  사다리 게임에 참여하는 플레이어의 이름을 최대 5글자까지 부여할 수 있다.
   - 플레이어의 이름 → String으로 받아야겠다.
   - String 배열로 받아서 split 메서드 등을 이용? (,를 기준으로)
   - 최대 5글자 → 정규표현식 이용? && 유효성 검증은 어떤식으로 해줘야할까?
      - 가령 “pobi,honux,crong,jk”가 아니라 “pobi,   honux,  crong,   JK”와 같다면?
   -
- [X]  사다리 출력시 이름도 같이 출력한다.
   - 사다리의 열 숫자가 곧 사람의 숫자이다.
   - 출력을 할 때 한 번에 모든 사람을 출력해줘야 한다?
   - 출력을 어떻게 해줄 수 있을까? 2단계까지 했듯이 배열
- [X]  사람 이름은 쉼표(,)를 기준으로 구분한다.
`   - Input을 받을 때 매개로 StringTokenizer? 내지는 String 배열? 내지는 StringBuilder? StringBuffer?
   - StringBuilder와 StringBuffer의 차이를 나는 잘 알고 있는가?
      - StringBuilder는 append 메서드로 받아서 출력할 때 한 번에 뽑아서 쓰곤했다.
      - StringBuffer는 잘 모름(사용해본적이 적고 익숙하지도 않다.)`
- [X]  사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.사람 이름을 5자 기준으로 출력하ㅍ기 때문에 사다리 폭도 넓어져야 한다.
   - 사다리 폭이 넓어져야 한다는 말의 의미?
      - 사다리 열 사이의 간격이 “(띄어쓰기 5개)” 또는 “——-”(”-”기호 5개)와 같은 형식이란 말인가?
- [X]  사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.

  ``* **|-----|-----|**` 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.


