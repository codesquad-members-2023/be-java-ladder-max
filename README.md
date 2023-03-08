# Java - Ladder

---

* Last Update : 2023-03-09

<br>

## 💻 구현 현황

---

* 패키지 및 클래스 생성 (Done)
  * Application Class : 사다리 게임 어플리케이션
  * controller package
    * Controller Class : 사용자가 게임을 요청하면 게임 결과를 반환
  * domain package : 비즈니스 로직, 데이터 관리
    * Ladder Class : Input Class, LadderLine Class 반환값으로 사다리 모양 생성
    * LadderLine Class : 사다리 사이의 다리를 랜덤으로 생성
  * view package : 사용자에게 보여지는 화면 (콘솔)
    * Input Class : 참여자 수 및 사다리 개수 입력
    * Output Class : 사다리 게임 결과 출력

<br>

* 첫번째 리팩토링 (~ing)

<br>

---

## ✍ 새로 알게된 지식

* numberFormatException : 문자열을 숫자로 변환할 때 변환할 수 없는 문자열이 들어올 경우 발생하는 예외
  * `abc`를 숫자형으로 변환하려고 할 때 예외 발생
  * `-123.4`를 숫자형으로 변환하려고 할 때 `-`와 `.`는 문자로 인식되므로 예외 발생



<br>

## Step 1. 기본 기능 구현

---

### ✔ 기능요구사항
- [x] 간단한 사다리 게임을 구현한다.
- [x] n명의 사람과 m개의 사다리 개수를 입력한다.
  * 입력값은 `BufferedReader`로 받는다.
  * 입력값이 유효값인지(양수인지) 확인하는 절차를 포함한다.
- [x] 사다리 라인은 랜덤 값에 따라 있거나 없을 수 있다.
  * 사다리가 있으면 `-`를 표시하고, 없으면 `" "`(공백문자)를 표시한다.
  * 이 단계에서 사다리(`-`)가 겹치는 것은 염두에 두지 않는다.
  * 양 옆에는 `|`로 세로를 표시한다.
- [ ] 사다리 상태를 화면에 출력한다.

### ✔ 프로그래밍 요구사항
- [ ] 메서드의 크기가 최대 10라인을 넘지 않도록 구현한다.
- [x] 메서드가 한 가지 일만 하도록 최대한 작게 만든다.
- [x] 2차원 배열을 학습하고 이를 이용해서 문제를 해결한다.

<br>

### 💡 고민 포인트 

---

#### 🤔 `"참여할 사람은 몇 명인가요?"` 출력 메서드를 Input Class 내부에 넣을까, Output Class 내부에 넣을까?
❗ Input Class에는 입력값을 받는 StringBuffer 기능만 넣고 Output Class에 모든 출력 메서드를 넣으려고 했는데, 아래와 같은 이유로 Input Class에 넣었다.<br>
&nbsp; (1) 두 클래스 모두 출력 기능을 담당하는 view package 안에 있는데 굳이 모든 출력문을 Output Class에 넣을 이유가 없는 것 같다. <br>
&nbsp; (2) 위 출력문은 입력값을 받기 위한 일종의 UI 기능이므로 Input Class에 넣는 게 더 적합해 보인다. 

<br>

#### 🤔 `String[][]` 2차원 배열을 출력하기 위해 `toString` 메서드를 재정의. 이때 `toString`의 위치는 domain 패키지와 view 패키지 중 어느 곳에 넣는 게 좋을까?
❗ 처음에는 출력을 위해 `toString` 메서드를 사용하는 거니까 view package에 넣어야 된다고 생각했는데, 더 찾아보니 `toString` 메서드를 이용하여 객체 내부 상태를 확인(객체가 가진 모든 정보를 반환, 디버깅, 로깅에 적합) 할 수 있으므로 domain package가 더 적합하다고 한다.

<br>

#### 🤔 외부클래스의 메서드를 호출할 때 <방법1>객체를 생성하고 생성된 객체를 직접 참조하여 메서드를 호출, <방법2>객체를 외부에서 주입받고 주입받은 객체를 이용하여 메서드를 호출, 두 가지 방법 중 어떤 것을 선택하는 게 좋을까? <br>
❗ 방법2 선택. 어떤 방법이 더 좋다는 정답은 없고, 상황에 따라 다르겠지만, 방법2(의존성주입) 사용 시 객체 간 결합도를 낮추고 유지보수성이 높으며 단위테스트에 용이하다고 한다. 



