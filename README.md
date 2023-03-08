# 사다리 게임 만들기
- `1주차/14주차`
- `2023-03-06(월) ~ 2023-03-10(금)`
---
## 그룹 스터디
## 1. 오늘의 학습 목표
- 1단계 완료하기: 사다리 만들어서 출력하기

## 2. 요구사항을 분석하여 정리하기

### 입력 InputView class
- 입력 메서드
  - m, n을 입력 받는다
  - 입력값 검증
  - m, n을 반환 -> 따로 class 만들기(dao 처럼)
- 입력값 검증 메서드(m,n이 int형 인지 검사, 0 이상인지 검사)
  - 검증 실패시 다시 입력받도록 한다
- 프로그램 종료 메서드
  - q를 입력하면 종료하기

### ?? 궁금증: 사람 수 = 사다리 수 아닌가요? (x)
- 사다리 수가 가로 줄을 말하는 건지?? (x)
- => 사다리 수 = 사다리 높이 (o)

### 사다리 Ladder class : 사다리를 만들어 주는 역할
- 사다리 만들기 메서드(사람_수 int n, 사다리_높이 int m)
  - 2차원 배열 생성(y축:사다리_높이, x축:사람_수+사람_수-1)
  - 가로줄 배치하기()
  - 2차원 배열을 반환
- 가로줄 배치하기 메서드 (어떻게 위치를 정할 것인가?)
  - 램덤 함수로 가로줄 개수 정하기(숫자 제한 필요)
  - 가로줄 위치 정하기
    - x축: 2차원 배열 index 홀수 위치 중 랜덤
    - y축: 사다리 높이 사이에서 랜덤
    - 이미 입력된 위치엔 추가하지 않도록 한다

### 출력 OutputView class
- 사다리 출력 메서드
- Ladder에서 2차원 배열을 받아와 출력

### 메인 컨트롤러 Main class
- 프로그램 실행 메서드
  - 입력 받기 : m,n = InputView.입력_받기();
  - 사다리 만들기 : String[][] ladder = Ladder.사다리 만들기();
  - 출력하기 : OutputView.출력(ladder);
  - while 문으로 반복해서 실행하기

## 3. 어떻게 작업을 진행할 것인가?
- 입력 단계 - n,m은 일단 임의의 값을 선언하여 넘겨 주고. 입력 로직은 나중에 짜기
  - why? 테스트하기 편할 듯
  - junit test 는 시간 남으면 연습용으로 짜보기
- 사다리 로직 만들기
  - 메서드 1개를 완성할 때 마다 2단계 리팩토링 적용해 보기
  - 학습 내용을 기록하기 위해서 개발-self 피드백 시간을 가져보고 싶어서
  - 어느 정도 완성하고 피드백 하는게 좋은지 생각해 보기
- 프로젝트 구조 생각해 보기
  - gist에선 생각 없이 했었는데, 오늘은 해봐야 겠다
- 목표 데드라인(22시)
  - 22시 이후는 학습 정리 및 개인 학습

---

# step-1 학습
## .gitkeep 이 뭐지?
- Git은 디렉토리만 따로 staging 영역에 추가할 수 없다. 
- 디렉토리를 commit 하기 위해 추가해 주는 더미 파일.

## gradle 사용법

# step-1 구현

---

# step-2 학습
## 리팩토링이란?
- 소프트웨어의 기능을 변경하지 않으면서 코드의 구조와 가독성을 개선하는 과정
- 코드의 가독성을 높이고 프로그램의 유지 보수성 향상을 위해 실시한다
- 예시) 코드 중복 제거, 메서드를 분리하여 메서드 크기 줄이기, 중첩된 if 문이나 반복문 제거

# step-2 구현

## 1. depth 개선
### step-2 1차 개선
| 클래스.메서드                         | 설명                             | 개선 전 depth | 개선 후 depth |
|---------------------------------|--------------------------------|------------|------------|
| GameController.runApplication() | 프로그램 흐름 제어                     | 0          | 0          |
| Ladder.makeLadder()             | 사다리 만들기                        | 0          | 1          |
| Ladder.addPlayerLine()          | 사다리에 세로줄 추가하기                  | 3          | 1          |
| Ladder.addBridge()              | 사다리에 가로줄 추가하기                  | 3          | 1          |
| Ladder.shouldBuildingBridge()   | 사다리 배열에 가로줄을 추가할 지 결정          | 0          | 0          |
| + Ladder.insertBridge()         | 사다리에 가로줄 추가하기(addBridge에서 분리됨) | -          | 1          |
| InputView.inputPlayerCount()    | 참여할 사람의 수 입력받기                 | 0          | 0          |
| InputView.inputLadderHeight()   | 사다리의 높이 입력받기                   | 0          | 0          |
| OutputView.printLadder()        | 사다리 출력하기                       | 2          | 1          |
| + OutputView.printLadderRow()   | 사다리 이차원 배열의 행 출력하기             | -          | 1          |
| Main.main()                     | 프로그램 반복 실행하기, ~~예외처리~~         | 2          | 1          |
| + Main.runApplication()         | 프로그램 실행하기, 예외처리                | -          | 1          |


### Ladder.addPlayerLine() depth 개선
```java
/* 개선 전 */
public class Ladder {

    public String[][] makeLadder(int playerCount, int ladderHeight) {

        // ... 생략

        // player line(세로 줄) 추가
        addPlayerLine(ladder);

        // ... 생략

        return ladder;
    }

    private String[][] addPlayerLine(String[][] ladder) {
        for(int i = 0; i < ladder.length; i++) {
            for(int j = 0; j < ladder[i].length; j++) {
                if(j%2 == 0) {
                    ladder[i][j] = "|";
                }
            }
        }

        return ladder;
    }

    // ... 생략
}
```
- addPlayerLine()에서 2중 for 문이 사다리 이차원 배열의 모든 값에 접근하고 있다.
- 모든 값에 접근하면서 if문으로 line이 들어갈 위치를 판별한다

```java
/* 개선 후 */
public class Ladder {

    public String[][] makeLadder(int playerCount, int ladderHeight) {

        // ... 생략

        // player line(세로 줄) 추가
        for(int row = 0; row < ladder.length; row++) {
            addPlayerLine(ladder, row);
        }

        // ... 생략

        return ladder;
    }

    private String[][] addPlayerLine(String[][] ladder, int row) {
        for(int col = 0; col < ladder[0].length; col += 2) {
            ladder[row][col] = "|";
        }

        return ladder;
    }

    // ... 생략
}
```
- 기존의 2중 for문에서 바깥 for문을 makeLadder() 메서드로 이동
- addPlayerLine()에 남아있는 for문의 index 값을 `+2`만큼 증가하도록 변경하여 if문을 사용하지 않고도 line이 들어갈 위치를 판별하도록 변경
- for문의 index 명도 `i, j`에서 `row, col`로 변경하여 가독성 개선

### Ladder.addBridge() depth 개선
```java
/* 개선 전 */
public class Ladder {

    public String[][] makeLadder(int playerCount, int ladderHeight) {

        // ... 생략

        // bridge(가로 줄) 추가
        addBridge(ladder);

        return ladder;
    }
    
    // ... 생략
    
    private String[][] addBridge(String[][] ladder) {
        for(int i = 0; i < ladder.length; i++) {
            for(int j = 0; j < ladder[i].length; j++) {
                if(j%2 != 0 && shouldBuildingBridge()) {
                    ladder[i][j] = "-";
                }
            }
        }

        return ladder;
    }

    private boolean shouldBuildingBridge() {
        return (int)(Math.random() * 2) == 1? true : false;
    }

}
```
- addBridge()에서 2중 for 문이 사다리 이차원 배열의 모든 값에 접근하고 있다.
- 모든 값에 접근하면서 if문으로 bridge가 들어갈 위치를 판별한다

```java
/* 개선 후 */
public class Ladder {

    public String[][] makeLadder(int playerCount, int ladderHeight) {

        // ... 생략

        for(int row = 0; row < ladder.length; row++) {
            addPlayerLine(ladder, row);
            addBridge(ladder, row);
        }

        return ladder;
    }
    
    // ... 생략
    
    private String[][] addBridge(String[][] ladder, int row) {
        for (int col = 1; col < ladder[0].length; col += 2) {
            insertBridge(ladder, row, col);
        }

        return ladder;
    }

    private boolean shouldBuildingBridge() {
        return (int)(Math.random() * 2) == 1? true : false;
    }

    private void insertBridge(String[][] ladder, int row, int col) {
        if (shouldBuildingBridge()) {
            ladder[row][col] = "-";
        }
    }

}
```
- 기존의 2중 for문에서 바깥 for문을 makeLadder() 메서드로 이동
- addBridge()에 남아있는 for문의 index 값을 `1`부터 시작하여 `+2`만큼 증가하도록 변경하여 if문을 사용하지 않고도 bridge가 들어갈 위치를 판별하도록 변경
- for문의 index 명도 `i, j`에서 `row, col`로 변경하여 가독성 개선
- addBridge()에서 bridge를 추가할지 랜덤으로 정해주는 로직과 사다리 이차원 배열에 bridge를 삽입하는 로직 분리
  - 차원 배열에 bridge를 삽입하는 로직을 insertBridge() 메서드로 분리

### OutputView.printLadder() depth 개선
```java
/* 개선 전 */
public class OutputView {

    public void printLadder(String[][] ladder) {
        for(int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                System.out.print(ladder[i][j] == null? " " : ladder[i][j]);
            }
            System.out.println();
        }
    }
}
```
```java
/* 개선 후 */
public class OutputView {

    public void printLadder(String[][] ladder) {
        for(int row = 0; row < ladder.length; row++) {
            printLadderRow(ladder[row]);
        }
    }

    private void printLadderRow(String[] ladderRow) {
        for (int col = 0; col < ladderRow.length; col++) {
            System.out.print(ladderRow[col] == null? " " : ladderRow[col]);
        }
        System.out.println();
    }
}
```
- 이중 for문을 메서드로 분리

### Main.main() depth 개선 밎 역할 분리
```java
/* 개선 전 */
public class Main {
    public static void main(String[] args) {
        GameController controller = new GameController();

        while (true) {
            try {
                controller.runApplication();
            } catch (NumberFormatException e) {
                System.out.println("잘못된 값을 입력하였습니다. 다시 입력해 주세요.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
```
- 프로그램을 반복 실행시키는 while문과 예외처리가 같은 main 메서드에 있어 메서드가 2가지 역할을 한다
- depth도 2까지 들어가게 된다

```java
/* 개선 후 */
public class Main {

    private static GameController controller = new GameController();

    private static void runApplication() {
        try {
            controller.runLadderGame();
        } catch (NumberFormatException e) {
            System.out.println("잘못된 값을 입력하였습니다. 다시 입력해 주세요.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        while (true) {
            runApplication();
        }

    }
}
```
- 반복 실행하는 while문은 main()에 두고
- game 실행과 예외처리 부분은 runApplication()에 따로 분리
  - depth는 개선되었으나, 여전히 runApplication()은 프로그램 실행과 예외처리를 담당한다
  - ? 예외처리를 완전히 분리할 순 없는건가 ?

## 2. Ladder 개선 - 생성자를 통해 인스턴스를 생성하도록 변경
- 기존 방식은 `String[][] ladder = new Ladder.makeLadder(int, int)`로 사다리를 만들었다
  - 이 방식은 ladder가 다른 곳에서 변경될 가능성이 있기 때문에 Ladder 객체에 ladder의 상태를 보관하고, Ladder 가 ladder의 상태를 스스로 관리하는 방식으로 변경함

## 3. Laddr 개선 - Stirng[][] 을 char[][]로 변경
- 한번에 하나의 문자만 들어가기 때문에 메모리 용량이 작은 char 배열로 변경
- char 배열을 바로 출력하기 위해 null 대신 공백문자 추가

## 4. OutputView - StringBuilder로 출력하도록 변경
- 성능 향상을 위해 System.out.print 대신 StringBuilder 사용하도록 변경

## step-2 최종 변경 사항
| 클래스.메서드                         | 설명                                     | depth |
|---------------------------------|----------------------------------------|-------|
| GameController.runApplication() | 프로그램 흐름 제어                             | 0     |
| + Ladder()                      | Ladder의 생성자                            | 0     |
| + Ladder.getLadder()            | 사다리 이차원 배열을 반환(depp copy하여 반환)         | 1     |
| Ladder.makeLadder()             | 사다리 만들기                                | 1     |
| + Ladder.initLadder()           | 사다리 이차원 배열 공백문자로 초기화하기                 | 1     |
| Ladder.addPlayerLineIntoRow()   | 사라디 이차원 배열 열에 세로줄 추가하기                 | 1     |
| Ladder.addBridgeIntoRow()       | 사라디 이차원 배열 열에 가로줄 추가하기                 | 1     |
| Ladder.shouldBuildingBridge()   | 사다리 배열에 가로줄을 추가할 지 결정                  | 0     |
| + Ladder.insertPlayerLine()     | 사다리 이차원 배열의 지정된 위치에 세로줄 삽입             | 0     |
| + Ladder.insertBridge()         | 사다리 이차원 배열의 지정된 위치에 가로줄 삽입             | 1     |
| InputView.inputPlayerCount()    | 참여할 사람의 수 입력받기                         | 0     |
| InputView.inputLadderHeight()   | 사다리의 높이 입력받기                           | 0     |
| OutputView.printLadder()        | 사다리 출력하기                               | 1     |
| + OutputView.appendLadderRowToStringBuilder()   | 사다리 이차원 배열의 행을 StringBuilder에 append하기 | 1     |
| Main.main()                     | 프로그램 반복 실행하기, ~~예외처리~~                 | 1     |
| + Main.runApplication()         | 프로그램 실행하기, 예외처리                        | 1     |

---
- [[3단계] 사다리 모양 개선](Step-3.md)
