# Step-5 : 실행결과 출력
- 2023.03.13(월)

## 2주차 주간 계획
- 2023.03.13(월)
  - 사다리 step-5 진행 (7h + α)
  - 저녁에 Objects 1장 책 읽고 정리하기 (2h)
- 2023.03.14(화)
  - 사디리 step-6 할 수있을까? 못하겠으면 로또 게임 step-1 진행 (7h + α)
  - 알고리즘 1문제 (3h, 조금 늦게 잔다)
- 2023.03.15(수)
  - 만약 step-6를 진행했다면 step-6 계속 진행 || 로또 게임 step-2 (5h + α)
  - *마스터 클래스(2h)*
  - Object 스터디 대비 1장 복습 (2h)
- 2023.03.16(목)
  - 사다리 step-6 계속 진행 || 로또 게임 step-2 계속 진행 (7h + α)
    - 사다리 타는 과정을 애니메이션으로 표현해보고 싶다.
  - Object 스터디 처음 시작(3h)
- 2023.03.17(금)
  - 이번주 미션 키워드 학습
  - *스쿼드 세견, 그룹 회고(2h)*
  - 알고리즘 2문제 (4h)

---
# 키워드
## setter 쓰지 않는 이유?

## DTO(Data Transfer Object)가 정확이 뭔지? DTO는 왜 setter 써도 되는지?

# 계획/고민거리
## [1] 실행 결과를 입력 받는다 ✅
- InputView.inputResult() 로 입력 받기
- 플레이어의 이름을 입력받는 로직과 똑같이 입력받는다
- 플레이어의 수와 같은 개수만큼 입력받게 한다
    - Destination, DestinationGroup 객체를 따로 생성하여 도착지에 대한 정보를 보관/관리한다
    - why? 한 객체에 몰아넣으면 test하기 어려워서 객체를 분리하여 하나씩 검사할 수 있도록
- (미해결) 개수를 어떻게 강제할 것인가?

## [2] 사다리 타는 로직을 작성한다 ✅
- GameController 에서 로직 작성
  - Controller가 Ladder를 가지고 있게 한다
  - Ladder.climbDownLadder()에서 반복문 안에 Player가 사다리를 이동하게 하는 로직 작성
    - 사다리 row만큼 반복문을 돈다
    - LadderRow에서 플레이어의 위치를 index로 표시
    - 사다리 row의 List마다 좌/우 가로줄(bridge)가 있는지 확인하여 플레이어 위치(index) 이동
- 이동이 끝나면 Player와 결과를 어딘가에 저장한다(Result, ResultGroup)
  - ~~(key-value) Map으로 처리하려면 key의 중복을 제거해야 한다 -> 별로~~
    - 중복이 되도 괜찮지 않나?? 다른 자료구조는 없을까?
    - (미해결) Player 이름 중복 제거 로직 추가? or 이름에 번호를 붙여주기?
  - Result, ResultGroup 객체를 추가하여 저장하기

## [3] 결과를 출력한다 - 1명씩 출력, 전체 출력 ✅
- Result에 저장된 내용을 출력

## [4] 프로그램 종료 기능 추가 ✅
- 종료 처리 메서드를 만들고 InputView의 각 입력 메서드마다 종료 처리 메서드를 호출하도록 한다.
  - 입력값이 `춘식이`이면 프로그램 종료, 아니면 계속 다음 로직을 진행하도록 한다.
  - 종료 명령어를 `--quit`으로 변경

# 코드 리뷰 반영
## [1] 유효성 검사 추가 및 검사 실패시 반복 입력 받기 ✅
1. 도착지 개수가 플레이어 수와 일치하는지 검사
  - PlayerGroup에서 플레이어 수를 받아와 DestinationGroup을 생성할 때 생성자 매개변수로 넣어 준다
  - DestinationGroup 내부에서 유효성 검사
2. 사다리 높이 유효성 검사
  - Ladder 객체 생성자에서 사다리 높이를 1 이상, 20 이하로만 생성할 수 있도록 한다

## [2] GameController 메서드 분리 ✅
- PlayerGroup, DestinationGroup, Ladder, ResultGroup을 생성하는 부분을 각각 메서드로 분리
- 메서드 명은 `create*()`으로 한다

## [3] main에 있던 예외 처리 및 로직 이동 ✅
1. 예외 처리 로직은 어디에 위임할 것인가? (발생한 곳에서 처리가 가능한가?)
2. while문은 어디에서 처리할 것인가

## [4] test 코드 SoftAssertion 사용 ✅
- SoftAssertion을 사용하여 앞쪽에서 테스트 코드가 실패해도 테스트가 끝나지 않고 계속 이어나갈 수 있도록 한다

## [5] test 코드 정확한 예외를 지정해 주기 ✅
- Exception -> IllegalArgumentException 사용

## [6] Player name 출력 로직 간소화 하기 ✅
- 다른 사람들은 어떻게 했는지 살펴보기
- 중첩된 String.format()을 제거하고 " "를 직접 붙여주는 형태로 변경

## [7] 패키지 분리 ✅
- domain을 destination, ladder, player, result로 나누기
