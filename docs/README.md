# java-ladder
2023 백엔드 자바 사다리게임 프로젝트

## feedback
- PR은 하루에 하나만, 한 PR에는 하나의 미션만 보내기
- 객체 간의 협력 중점으로 고민해보기

## 학습 계획표
| 날짜  | 학습키워드                | 세부내용                        |
|-----|----------------------|-----------------------------|
| 3/6 | `git`                | - 브랜치 생성 및 포크<br/>- CLI 명령어 |
| 3/7 | `git`<br/>`OOP` | - PR<br/>- 오브젝트 1~2장 정리     |
| 3/8 | `enum`               | - enum 활용 사례                |

## 1단계 - 기본 기능 구현 (3/7)
### Check List
- [x] 참가자 인원을 입력할 수 있도록 한다.
- [x] 사다리 최대 개수를 입력할 수 있도록 한다.
- [x] 입력값을 기반으로 사다리 상태를 출력한다.
    - 2차원 배열 활용

## 2단계 - 리팩토링 (3/7)
### Check List
- [x] 네이밍 컨벤션을 잘 지켰는지?
- [ ] 최소한의 단위로 메서드를 분리했는지?(indent 2단계 이하)

### 작업 결과
- 좀 더 효율적이고 간결한 코드를 만들기 위한 방법 고민해보기(메서드를 더 분리해봐야 할지..)
```java
public class LadderGenerator {
  int maxHeight;
  int column;
  String[][] ladder;

  public LadderGenerator(int joinMembers, int maxHeight) {
    column = joinMembers + (joinMembers - 1);
    ladder = new String[this.maxHeight = maxHeight][column];
  }

  public String[][] generateLadder() {
    generateLadderArray();
    generateRandomLine();
    generateBorderLine();
    return ladder;
  }

  public void generateLadderArray() {
    ladder = new String[maxHeight][column];
    for (int i = 0; i < ladder.length; i++) {
      for (int j = 0; j < ladder[i].length; j++) {
        ladder[i][j] = " ";
      }
    }
  }

  public void generateRandomLine() {
    Random random = new Random();
    for (int i = 0; i < ladder.length; i++) {
      for (int j = 0; j < ladder[i].length; j++) {
        if (j % 2 != 0 && random.nextBoolean()) {
          ladder[i][j] = "-";
        }
      }
    }
  }

  public void generateBorderLine() {
    for (int i = 0; i < ladder.length; i++) {
      for (int j = 0; j < ladder[i].length; j++) {
        if (j % 2 == 0) {
          ladder[i][j] = "|";
        }
      }
    }
  }
}
```

## 3단계 - 사다리 모양 개선