## 사다리 게임

- [x] commit 메세지 작성 방법

- [x] java 문자열 관련 학습자료 참고해서 공부하기

- [x] 사다리게임 1단계 구현하기

- [x] 클린코드 관련 학습자료 참고해서 공부하기

- [x] 사다리게임 2단계 구현하기

- [ ] 사다리게임 3단계 구현하기

- [ ] 사다리게임 4단계 구현하기



### 사다리 게임 Step1

- [x] n명의 사람과 m개의 사다리 개수를 입력한다.
- [x] 사다리 라인은 랜덤하게 있거나 없다. (`" - "` or `"  "`)
- [x] 사다리 생성 후 출력



### Step1 diagram

![step1_diagram(final)](https://raw.githubusercontent.com/CDBchan/Typora-img/main/img/step1_diagram(final).PNG)

**InputOutputManager**

InputHandler, OutputHandler(입출력) 클래스를 제어한다.


**ladder**

랜덤한사다리를 만들어주는 클래스 이다.

### 사다리 게임 Step2

- [x] 메서드의 크기가 최대 10라인을 넘지 않도록 구현한다.
- [x] 들여쓰기(indent) depth를 2단계에서 1단계로 줄인다.
- [x] else를 사용하지 않는다.


### 사다리 게임 Step3

- [x] 플레이어를 이름을 사용해서 추가 (이름은 최대 5글자)
- [x] 사람이름은 쉼표를 기준으로 구분
- [x] 사람 이름은 5글자를 기준으로 사다리 폭 증가
- [x] 사다리 라인이 겹치지 않도록 한다.
- [x] 요구사항

> 구현을 할때 아래와 같은 **요구사항** 을 만족시키며 구현한다.
>
> - 메소드의 크기는 최대 10라인
> - indent depth를는 1단계
> - else 사용 X
> - ArrayList 와 Generic을 활용해 구현



### Step3 diagram

![step3_diagram](https://raw.githubusercontent.com/CDBchan/Typora-img/main/img/step3_diagram.PNG)



### Step3 결과

![step3_result](https://raw.githubusercontent.com/CDBchan/Typora-img/main/img/step3_result.PNG)
