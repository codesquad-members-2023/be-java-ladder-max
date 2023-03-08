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
