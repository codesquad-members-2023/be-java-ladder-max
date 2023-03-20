## 사다리 게임

<details>
<summary>사다리게임 1주차 계획</summary>
<div markdown="1">


**구현 사항**

- [x] [사다리게임 Step1 기본기능 구현(2023.3.6)](#사다리-게임-step1)

- [x] [사다리게임 Step2 (리팩토링) (2023.3.6)](#사다리-게임-step2)

- [x] [사다리게임 Step3 사다리 모양 개선(2023.3.7)](#사다리-게임-step3)

- [x] [사다리게임 Step4 (리팩토링) (2023.3.8)](#사다리-게임-step4)

- [x] [사다리게임 Step4 v2(리팩토링) (2023.3.9)](#사다리게임-step4-v2)

- [x] [사다리게임 Step4 v3(리팩토링) (2023.3.10)](#사다리-게임-step4-v3)

- [ ] [사다리게임 Step5]()

- [ ] [사다리게임 Step6]()



| 개념                                      | Step            |
| ----------------------------------------- | --------------- |
| StringBuilder & String Buffer             | Step1           |
| commitMessage 작성요령                    | Step2           |
| 클린코딩                                  | Step2           |
| 객체지향생활체조 원칙                     | Step4           |
| TestCode에서 터미널 입력 구현             | Step4           |
| object 형변환                             | Step4           |
| String.format()                           | Step4           |
| Error And Exception 종류 공부             | Step4  추가구현 |
| Assertion (org.junit, org.assertj 차이점) | Step4 추가구현  |
| java.lang                                 | Step4 추가구현  |
| ifPresent, isPresent,findFirst            | Step4 추가구현  |





## 사다리 게임 Step1

- [x] StringBuilder & String Buffer


- [x] n명의 사람과 m개의 사다리 개수를 입력한다.

- [x] 사다리 라인은 랜덤하게 있거나 없다. (`" - "` or `"  "`)

- [x] 사다리 생성 후 출력



### Step1 diagram



![step1_diagram(final)](https://raw.githubusercontent.com/CDBchan/Typora-img/main/img/step1_diagram(final).PNG)



## 사다리 게임 Step2

- [x] commitMessage 작성요령
- [x] 클린코딩
- [x] 메서드의 크기가 최대 10라인을 넘지 않도록 구현한다.
- [x] 들여쓰기(indent) depth를 2단계에서 1단계로 줄인다.
- [x] else를 사용하지 않는다.

### Step1과 비교했을때 개선 또는 구현 사항

- 2중 for문을 줄이기(indent depth를 2단계 ->1단계)
- 분기문 줄이기 (else를 사용하지 않는 방향으로 구현)



## 사다리 게임 Step3

- [x] 플레이어를 이름을 사용해서 추가 (이름은 최대 5글자)
- [x] 사람이름은 쉼표를 기준으로 구분
- [x] 사람 이름은 5글자를 기준으로 사다리 폭 증가
- [x] 사다리 라인이 겹치지 않도록 한다. (사다리가 다음과같이 생성되면 안된다. |-----|-----|)
- [x] 요구사항

> 구현을 할때 아래와 같은 **요구사항** 을 만족시키며 구현한다.
>
> - 메소드의 크기는 최대 10라인
> - indent depth를는 1단계
> - else 사용 X
> - ArrayList 와 Generic을 활용해 구현

### Step2와 비교했을때 개선 또는 구현 사항

- 클래스명을 좀더 직관적으로 변경

    - Main -> LadderGame .. 등

- InputHandler 클래스에 사용자의 이름 및 사다리 높이를 받는 메서드 getHeight,getName 메서드 구현

- Ladder클래스 안에 randomCheck 메서드를통해 사다리 라인이 겹치지 않도록 구현

- InputHandler 클래스에 사용자의 이름이 5글자가 넘는지 확인하는 validate 메서드 추가



### Step3 diagram

![step3_diagram](https://raw.githubusercontent.com/CDBchan/Typora-img/main/img/step3_diagram.PNG)



### Step3 결과

![step3_result](https://raw.githubusercontent.com/CDBchan/Typora-img/main/img/step3_result.PNG)



## 사다리게임 Step4

- [x] 객체지향생활체조 원칙
- [x] TestCode에서 터미널 입력 구현
- [x] object 형변환
- [x] String.format()

- [x] 패키지분리 및 적절한 접근제어자 사용
- [x] 로직을 구현하는 코드에 단위 테스트 구현

- [x] 코드 리팩토링



### Step3와 비교했을때 개선 또는 구현사항

- domain, View 패키지를 통해 클래스를 구분했다

- Ladder 클래스에 존재하는 ArrayList ladder를 출력하기위해 getter를 사용하는대신, toString()을 override 해 getter 메서드를 제거했다.

- InputOutputController 와 LadderGameController를 포함하는 controller패키지를 추가했다.

- 사다리의 Line의 상태를 가지고있는 LadderLine Class를 추가했다.

    - ![LadderLine](https://raw.githubusercontent.com/CDBchan/Typora-img/main/img/LadderLine.PNG)

      ArrayList ladder에 LadderLine클래스에 존재하는 ArrayList<boolean> points를 저장한다.

      LadderLine객체는 사다리에 존재하는 하나의 가로 라인을 나타낸다.

      ![ExampleOfLadder](https://raw.githubusercontent.com/CDBchan/Typora-img/main/img/ExampleOfLadder.PNG)

      위와같이 출력되는 사다리가 있다 가정할때 ArrayList ladder와 ArrayListPoints의 내부 값들의 다음과 같다.

      ![LadderLineEx](https://raw.githubusercontent.com/CDBchan/Typora-img/main/img/LadderLineEx.PNG)

      사다리의 첫번째줄에서 3번째에만 hung이 존재하기에 ArrayList<boolean> points 안에 값은 false/false/true/false가 된다.

      사다리 두번째줄은 false/true/false/true 가된다.. 이런식으로 ArrayList ladder에 LadderLine 객체를 저장한다.

- LadderLine에 points에 대한 validate 메서드 추가했다.(연속적인 true가 들어오는지 판단한다.)

### Step4 diagram

![step4_diagram](https://raw.githubusercontent.com/CDBchan/Typora-img/main/img/step4_diagram.PNG)





## 사다리게임 Step4 v2

- [x] Error And Exception 종류 공부

- [x] Assertion (org.junit, org.assertj 차이점)

- [x] java.lang 패키지

- [x] git 명령어 연습

- [x] 로직에 대한 테스트 코드 추가



### Step4와 비교했을때 개선 또는 구현사항

- InputHandler,OutputHandler보다는 패키지명에맞게 InputView,OutputView로 변경했다.
- 잘못된 입력이 들어왔을때 예외를 발생시키는 validate 메서드들을 추가했다
    - player가 1명이하일때 예외 발생
    - 사다리 높이가 1미만일때 예외 발생



### Step4 v2 diagram

![step4_v2_diagram](https://raw.githubusercontent.com/CDBchan/Typora-img/main/img/step4_v2_diagram.PNG)



## 사다리게임 Step4 v3

- [x] 전체적인 메서드명 및 변수명 수정
- [x] 전체적인 코드 리팩토링



### Step4 v3 diagram

![step4_v3_diagram](https://raw.githubusercontent.com/CDBchan/Typora-img/main/img/step4_v3_diagram.PNG)



### Step4 v2와 비교했을때 개선 또는 구현사항

- 메서드명만보고 동작을 유추할수 있도록 메서드명을 수정했다.
- LadderLine에 존재하는 validator를 포함하는 LinePointsValidator클래스를 만들어 주었다.


</div>
</details>

<details>
<summary>사다리게임 2주차 계획</summary>
<div markdown="1">

## 사다리게임 2주차 계획

### **주간계획**

- [ ] Java Programming 개념
- [ ] Object Chapter10까지 읽기
- [x] 사다리게임 5단계까지 구현
- [ ] (선택) 로또 게임
- [ ] Spring 복습

### **3.13 계획**

- [x] 사다리게임 Step5
- [ ] Java Programming 개념 10 까지
- [ ] Object Chapter4



## 사다리게임 Step5

- [x] 사다리 게임 결과 출력



## Step5 다이어그램

![step5_diagram](https://raw.githubusercontent.com/CDBchan/Typora-img/main/img/step5_diagram.PNG)



### Step4와 비교했을때 개선 또는 구현 사항

Line을 생성하는 일을 LadderLine이아닌 RandomLineGenerator클래스가 하도록 했다.

ExcutionResult 클래스에 LadderGame에 대한 결과를 Map형태로 가지고 있으며, user의 input에 따라 사다리게임 결과를 출력한다. 

### Step5 결과
![step5_결과](https://raw.githubusercontent.com/CDBchan/Typora-img/main/img/step5_결과.PNG)

### 3.14 계획

- [x] Java Programming 개념
    - [x] Java Collection Framework
        - [x] equals
        - [x] hashCode

    - [x] TDD Basic

- [ ] ~~Object Chapter4~~
- [x] Solid
- [x] OOP 4원칙
- [x] 사다리게임 Step5 테스트 코드


### 3.15 계획

- [x] OOP 원칙,Solid 원칙, Object책에 의거한 코드 리팩토링
    - [x] 네이밍 중복되지않게 수정
    - [x] 각 클래스별 기능 정리
    - [x] SRP
- [x] 사다리 생성시 연결 안되는 곳이 있으면 연결할수 있는 기능 추가

</div>
</details>

## LadderGame

| 클래스                   | 필드                                            | 기능                                                         |
| ------------------------ | ----------------------------------------------- | ------------------------------------------------------------ |
| Players                  | playersList                                     | ~~User로부터 players를 입력받고~~ player에 대한 유효성 검사  |
| Results                  | resultList                                      | ~~User로부터 results를 입력받고~~ result에 대한 유효성 검사  |
| LadderHeight             | ladderHeight                                    | ~~User로부터 ladderHeight를 입력받고~~ ladderHeight에 대한 유효성 검사 |
| InputOutputController    | inputHandler,outputHandler                      | 모든 input과 output을 처리                                   |
| LadderGameController     | ioController,players,ladderHeight,result,ladder | ladderGame을 control                                         |
| Ladder                   | ladder, ~~ladderHeight~~, ~~countOfPeople~~     | 사다리를 만들며, 사다를 탈수 있는 기능을 가지고 있다.        |
| LadderLine               | points,lineWidth                                | RandomLineGenerator를 통해 사다리 Line을 만들며, player의 위치를 기준으로 좌우로 연결된 사다리의 유무를 판단하는 기능을 가지고 있다. |
| RandomLineGenerator      |                                                 | 사다리 Line을 생성하는 기능 및 유효성 검사를 한다.           |
| ExecutionResultGenerator | resultMap, ~~ladder,player,result~~             | 사다리 게임의 결과를 Map형태로 저장한다.                     |
| InputView                |                                                 | console을 통해 입력을 받는 기능을 담당한다.                  |
| OutputView               |                                                 | 모든 출력을 담당한다.                                        |
| ~~ExecutionResult~~      | ~~resultMap~~                                   | ~~User로부터 player를 입력으로 받아 결과를 출력하는 기능을 가지고 있다.~~ |



![최종](https://raw.githubusercontent.com/CDBchan/Typora-img/main/img/최종.PNG)



### 예외처리

player가 1명일때

player 이름이 6이상 일때

Ladder height가 1 이하일때

Results의 갯수가 player명수와 다를때

Ladder생성시 이어지지 않는 부분이 존재할때



### 개선점

InputOutputController에 존재하는 메서드를 public으로 만들고 각 객체 players,ladderHeight,Results의 생성자를 통해 값을 초기화 한다. 이렇게하면 InputOutputController와 Players,LadderHeight,Results의 의존성이 사라질수 있다.



Validator만을 모아둔 class을 두자, 어차피 input에 대해서만 Validate를 해주니 하나의 클래스에 Validate를 모아두자.