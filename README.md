﻿Junit?? 

### Git Commit Convention

커밋내용을 일관적이게 작성하는 방법이다. 해당 형식을 아는 사람이라면 



### StringBuilder VS StringBuffer

- StringBuilder가 더 효율적이다. 왜 그럴까?



## 1 - 1

JDK 11 ??

---

### 구현부

메서드의 크기가 10라인, 최대한 작게.

2차원배열을 사용한다.

---

인원과 사다리의 높이를 입력
- 무엇을 입력할지 안내문을 출력한다.
- 출력과 입력을 2회 (사람수, 사다리 높이) 실행한다.
- 입력받은 값을 이용한 크기로 2차원 배열을 사용할 것이다.
  - 배열에는 이후 출력을 위한 문자, 문자열이 들어갈 예정이다. 

사다리의 가로줄은 랜덤
- yes or no 니까 0.5를 기준으로 rand를 써보자.
- 그리고 2차원 배열의 홀수칸에 값을 넣기?
- 그리고 내려갈때 그 값을 확인해서 이동한다.

출력
- 2차원 배열을 그대로 출력.

---

## 1 - 2

들여쓰기를 1단계로 줄여라.
- 2차원 배열의 한 행씩을 채울 때, 무작위로 사다리의 발판을 채우는 부분에서 for + if 가 사용되고 있다.
  - fillLine 메소드에서 각 칸을 순회하게 하고, 값을 넣는 새로운 메소드를 만들어야겠다.

else를 사용하지 말아라.
- break point를 활용하면 else의 사용을 줄일 수 있겠다.

구현순서를 고려하며 프로그래밍한다??
- 프로그램의 흐름이 흘러가는 방향에 맞춰 프로그래밍을 하라는 말일까?

Naming convention
- 클래스, 메소드, 변수 의 이름만 봐도 이게 무슨 일을 할 지 짐작할 수 있게끔 명명한다.
- Java는 Camel Case를 따르도록 한다.
  - Camel Case : 첫번째 단어는 소문자로 시작, 이후 단어들의 첫 글자는 대문자로 쓰는 방식이다.
    - 클래스와 변수의 이름은 명사, 메소드의 이름은 동사 로 시작하는 경우가 많다.

### 2단계 미션 후

다음 날 그룹리뷰를 할때, 커밋의 빈도와 그 내용이 많이 부족함을 느꼈다. 커밋만 봐서는 어떤 클래스 어떤 메소드가 수정됐는지조차 알 수 없는 경우가 있었다.

3단계 미션을 진행할 때는 이 부분에 좀 더 신경써서 진행해보도록 해야겠다.

입력을 받고 이를 반환해서 활용할때 int형 배열을 사용해서 값을 전달했다. 이 부분이 다른 사람이 볼 때 이게 뭔지 명확하지가 않을 것 같다.  
특히 값을 전달하는 배열인 userInput의 index가 0인 값이 참여자, 1인 값이 사다리의 높이 인데 이걸 나 말고 누가 알겠는가. 값을 전달하기 위한 클래스를 만들어서 전달해봐야겠다.

--- 

## 1 - 3

### 사전지식

- List와 ArrayList
- 리스트와 제네릭

### 요구사항

- 이전에는 숫자로 참여자의 수를 알았다면, 이번에는 쉼표로 구분되는 이름의 갯수를 통해 참여자의 수를 파악한다.
  - 쉼표를 기점으로 문자열을 나눠서 그 개수를 파악하자.
- 사다리를 출력할때 참여자의 이름을 같이 출력한다.
  - 사다리 출력 전에 참여자의 이름을 담은 내용을 출력하는 방식으로.
- 사람 이름은 최대 5글자이고 이름을 사다리 위에 출력해줘야 하므로, 이를 고려해서 사다리의 폭도 넓어져야한다.
  - 기존에 사다리의 발판이 - 이었으니 ----- 로 바꿔서 한다.
    - 앞에서 구상한 내용처럼 String을 이용해서 하면 될 것 같다.
- 정상적인 사다리게임의 진행을 위해 발판이 겹치지 않도록 한다. (사다리 게임에는 좌우 선택이 존재하면 안된다.)
  - 일단 구상은 사다리의 왼쪽부터 발판을 랜덤하게 채워간다.
  - 그리고 발판을 채울때 왼쪽 발판이 존재하는지 확인하고, 없는 경우에만 랜덤메소드를 호출하게 하자.

### 프로그래밍 요구사항 

1,2 단계의 요구사항을 기본으로 변경된 내용은 배열 대신에 ArrayList와 Generic을 활용하는 것.

---

구현 성공하고 하나씩 차례대로 진행하기.


## 마스터 클래스

### 이런저런 질문타임

클래스와 클래스 사이의 관계에는 정답이 없다. 클래스들의 역할을 나눠보는게 좋다. 

정렬 등 출력에 관한 것을 처리하는 View가 있을 수도 있고, 값을 검증하는 메소드가 있을 수도 있고.

IDE의 extractmethod. 

> papabear : 읽었으면 하는 책이 딱 2권 있는데, 디자인패턴, 리팩토링.

reflection 

기본적으로 private로 메소드를 작성하면서 보수적으로 프로그래밍하다가, 필요한 경우 public으로 전환하는 방식으로 작성한다.

인터페이스를 쓰는 경우

똑같은 메서드 시그니쳐, 

드라이버의 경우. 예를 들어 콘솔에 사다리를 그려주는 렌더러가 있다. Web용 렌더러가 있을 수도 있다.???????????

implement 하는 클래스에서는 메소드 바디를 채워야 한다. 한 클래스는 커맨드라인에 그려주는 렌더러. 다른 클래스는 웹에 렌더링 해주는 렌더러.

인터페이스 를 변수의 이름으로 주고, new web or new commandline 처럼 해서 사용한다.  
이렇게 하면 메소드의 이름이 같다. 같은 인터페이스에서 호출한 메소드이기 때문에.

---

## 강의

### Java Helloworld

Hello, World! 가 없는 컴퓨터 Language는 없다. 

HelloWorld가 왜 대단한가!

실행하는 프로그램의 이름은 클래스명을 따서 지어지게 된다. 



main의 args. 아무 입력이 없는데 동작한다. 

예전에는 콘솔에서 java HelloWorld asdasdasd 의 형태로 args를 줄 수 있었다. 지금은 IDE에서 설정을 통해 입력해줄 수 있다.

일반적으로 다른 클래스의 메소드를 호출하려면 import가 필요하다. 그런데 sout은 없다?

Java.lang이 