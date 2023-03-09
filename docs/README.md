# java-ladder
2023 백엔드 자바 사다리게임 프로젝트

## 주의사항
- PR은 하루에 하나만, 한 PR에는 하나의 미션만 보내기
- 객체 간의 협력 중점으로 고민해보기

## 학습 내용
| 날짜       | 학습키워드          | 세부내용                               |
|----------|----------------|------------------------------------|
| 03.06(월) | `git`          | - 브랜치 생성 및 포크<br/>- CLI 명령어        |
| 03.07(화) | `git`<br/>`OOP` | - PR<br/>- 오브젝트 들춰보기               |
| 03.08(수) | `enum`<br/>`OOP` | - enum 활용 사례<br/>- 오브젝트 1장 정독 후 정리 |
| 03.09(목) |                |                                    |


---
# 23.03.07 (화)
## 1단계 - 기본 기능 구현
### Check List
- [x] 참가자 인원을 입력할 수 있도록 한다.
- [x] 사다리 최대 개수를 입력할 수 있도록 한다.
- [x] 입력값을 기반으로 사다리 상태를 출력한다.
    - 2차원 배열 활용

## 2단계 - 리팩토링
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
---
# 23.03.09 (목)

## To-do
- [x] 학습계획 작성
- [ ] 그룹리뷰 내용을 바탕으로 코드 개선하기 // 2단계
- [ ] `자바 문자열` 학습 후 정리
- [ ] `리스트와 제네릭` 학습 후 정리

## 그룹리뷰
>- IDE 메서드 분리 기능을 이용해 메서드 분리 연습과 코드 가독성 향상하기
>- 출력에 필요한 문자열을 상수 처리하기
>- main 메서드에서는 객체의 동작만 보이게끔 수정하기
>  - 생성자에서 new 연산자를 사용하는 방법이 있다.
>- 접근제어자를 신경써서 캡슐화, 객체 간 협력에 집중하도록 하기
>- naming과 커밋 메시지 신경쓰기

그룹리뷰를 준비하는 시간이 필요할 것 같다.  
준비되지 않은 상태에서 내가 고민했던 과정과 해결 과정을 조리있게 말하는게 쉽지 않았다.  
다음 리뷰부터는 내가 얘기하고자 하는 내용을 다듬어 간결하게 전달해서 동료들의 입장에서 피드백이 원활할 수 있도록 노력해보자.


## 3단계 - 사다리 모양 개선