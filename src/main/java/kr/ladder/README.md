# 1️⃣ 미션 정리 1
label 명 step-1, branch 명 feature1
## 설계 순서
1. 사다리를 담을 2차원 배열을 만든다
2. 사다리를 저장할 Ladder 클래스를 만든다.
3. Input 을 담을 InputView 클래스, Output 을 담을 OutputView 클래스를 만든다.
4. 사다리를 담을 2차원 배열은 ladder[사다리 높이][사람 수 + (사람 수 - 1)]로 만든다
5. ladder[row][column] 으로 설정했을 때, column 은 '|' (사람 수)와 '-' 나 ' ' (사람 수 - 1)을 넣을 공간을 만든다.
6. 0을 포함 한 index 짝 수 번째에 '|' 을 넣는다.
7. index 홀 수 번째에 random 으로 '-' 나 ' ' 을 넣는다.
8. 홀 수 번째는 둘 중 하나를 random 으로 넣어야 하므로 Random 클래스를 이용해 nextBoolean() 메서드를 사용한다.

### 구현 주의 사항
1. 메서드 길이는 최대 10라인 으로 작성.
2. 메서드는 각자 한가지 일만 하도록 최대한 작게 만들기.
3. 예외처리 보다는 출력을 먼저 생각하기.

## 설계한 클래스와 역할
1. InputView : 안내 메세지를 출력하고, 사람 수와 사다리 높이를 받는다.
2. Ladder : InputView 에서 받은 사람 수와 사다리 높이를 이용해 사다리를 만들고, 클래스 내부에 저장한다.
3. OutputView : Ladder 에서 만든 사다리를 이용해 2차원 배열을 출력한다.
4. Application : InputView, Ladder, OutputView 를 관리한다.

-----
# 2️⃣ 미션 정리 2
label 명 step-2, branch 명 feature2

## 설계 순서
### 구현 순서를 고려하며 프로그래밍 한다.
1. step-1 을 리팩토링한다.
- 리팩토링이 무엇인지, 리팩토링의 필요성을 설명 가능하게 알아본다.
- 네이밍 컨벤션을 지켰는지 확인한다.
- depth를 2단계에서 1단계로 줄인다.

### step-1 수정
1. .gitignore 에서 의미를 모르고 사용했던 불필요한 ignore들을 삭제.
2. 설계 과정을 readme에 정리.
3. 안내문 상수 처리.
4. 메서드 이름 변경.
5. depth 2단계에서 1단계로 수정하기.

-----
# 3️⃣ 미션 정리 3
label 명 step-3, branch 명 feature3

## 설계 순서
1. step-2의 리팩토링 하기 위한 구현 순서를 정한다.
2. 구현 순서를 정하고 Application의 리팩토링까지 마친 후, Ladder를 리팩토링 하기 위해서 Generic 을 알아본다.
### 구현 순서
#### InputView
##### input 받은 사람 이름을 배열로 만들어 return 하는 메서드 추가
1. 사람 이름을 묻는 message 상수에 추가
2. 입력받은 문자가 올바른 문자인지 확인
   1. 1~5글자 사이가 아니면 다시 입력 받는다.
   2. 쉼표 기준으로 나눈 문자열의 길이가 0이면 다시 입력 받는다.
3. 올바른 문자로 된 ArrayList 를 return 한다.
#### OutputView
##### 사람 이름 출력을 위한 output 메서드 추가
1. ArrayList 로 된 사람 이름을 사다리 너비에 맞게 가공한다.
   - ArrayList (사람 이름)는 parameter로 입력 받는다.
2. 가공 된 ArrayList를 출력한다.
#### Application (main())
##### 사람 이름을 Application에 저장한다.
- 여기에 저장하는게 맞는지는 잘 모르겠다.
#### Ladder
1. 사람 이름에 따른 사다리의 폭 수정
2. 라인 겹치게 불가 ex) |-|-| 불가, | |-| 가능.
3. 배열 대신 ArrayList와 Generic 사용

-----
# 4️⃣ 미션 정리 4-1
label 명 step-4, branch 명 feature4
## 구현 순서
1. 나의 코드를 한번 찬찬히 살펴본다.
2. 동료 피드백 기반으로 step3 리팩토링
3. 코스의 호눅스 피드백 기반으로 step3 리팩토링
4. step4의 요구사항에 맞게 리팩토링

### 설계 순서
#### 동료 피드백 기반으로 step3 리팩토링
1. main()을 다루는 클래스를 따로 생성.
   - main()에서는 사다리 게임을 run()하는 기능만 할 수 있게 설정.
2. getLadder() 말고 toString()으로 작성.
3. commit 할 때, 맨 처음에 Type: 기입

#### 코스의 호눅스 피드백 기반으로 step3 리팩토링

#### step4의 요구사항에 맞게 리팩토링

-----
# 4️⃣ 미션 정리 4-2
label 명 step-4, branch 명 feature4
## 리팩토링
1. 복잡한 사다리 만드는 로직 수정
   1. random.nextBoolean()의 결과로, 문자열 5개씩 받기 ("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" 혹은 "-----")
   2. List<List\<String>> 부분 클래스로 나누기
   3. getLadder() 에서 toString()을 오버라이딩 하는 것으로 바꾸기.
      - OutputView의 메서드도 변경
2. 메서드 이름 변경
3. 테스트 코드 작성

