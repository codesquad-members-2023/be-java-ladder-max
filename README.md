# Java Ladder

- Last Update: 2022-12-28

## 코드 리뷰

* [텍스트와 이미지로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://github.com/code-squad/codesquad-docs/blob/master/codereview/README.md)

* [동영상으로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://youtube.com/watch?v=lFinZfu3QO0&si=EnSIkaIECMiOmarE)

# step-1 구현 결과
```
Hello world!
참여할 사람은 몇 명인가요?
3
최대 사다리 높이는 몇 개인가요?
5
|   | - | 
|   |   | 
| - |   | 
|   | - | 
|   | - | 


Hello world!
참여할 사람은 몇 명인가요?
5
최대 사다리 높이는 몇 개인가요?
5
| - | - |   | - | 
| - | - |   |   | 
|   | - | - |   | 
|   | - | - |   | 
|   | - | - | - | 

```

# step-2 구현 결과

```java
public String[][] createBasicArr (){
        String[][] arr = new String[length][width];
        for(int i = 0; i<length; i++) {
            for(int j = 0 ; j<width; j++) {
                arr[i][j] = (j%2==0?"|":" ");
            }
        }
        randomBar(arr);
        return arr;
    }
```

```java
private String[][] createBasicArr (){
            String[][] arr = new String[length][width];
            for(int i = 0; i<length; i++) {
                createStick(arr,i);
            }
            randomBar(arr);
            return arr;
    }

private void createStick(String[][] arr,int i){
            for(int j = 0 ; j<width; j++) {
            arr[i][j] = (j%2==0?"|":" ");
            }
    }
```
- 다음과 같이 2중 포문을 사용하는 함수는 배열과 인덱스를 인자로 보내 새로운 함수에 for문을 돌려서 뎁스를 줄임
- 외부에서 사용하지 않는 함수들은 접근제어자를 public에서 private로 변경


# step-3

## User 클래스
입력 이름 format 지정 하는 클래스

## MakeLader 클래스
사다리를 만드는 클래스

한 줄 씩 사다리 모양을 만들어서 사다리 층의 갯수 만큼 리스트를 채워둠

## 설계 
1. true/false 를 판단 반복 횟수 (사람*2 -1) * 사다리 층수
    1. true 면 "|" add
    2. false 면 한번 더 true false 판단하는 메소드
        1. boolean 배열을 두고 연속으로 true가 나오면 공백 아니면 "-----"

2. 출력 메소드
    1. 사다리 층 수 마다 "\n" 해서 출력


# step-4

## Line 클래스
사다리 한 줄을 만드는 클래스
- 사다리 중복체크 
- 사다리 그리기
## Ladder 클래스
line 클래스를 담은 리스트를 이용하여 사다리 전체를 만드는 클래스
## User 클래스
참여자 관련 처리 클래스
- 형식 설정
- 유저 리스트 생성
## Validator 클래스
이름 글자 수 예외 처리 클래스

## 리팩토링 내용 -1
- step-3 방식에서 재 구현 ( 이중 리스트 사용 )
- Exception을 이용해 예외 처리
- 클래스의 자료구조들은 자신의 클래스 내에서만 사용하게 함

## 리팩토링 내용 -2 
- 테스트 코드 작성 
- 메서드 함수형으로 변경

# step-4 클래스 다이어그램
<img width="681" alt="diagram" src="https://user-images.githubusercontent.com/100547825/224796750-290c1f5a-f92e-4852-9a38-ecc8c679bd58.png">

# 2주차 학습계획
- [x]  step-5 설계 및 구현
- [ ]  오브젝트 책 읽기
- [ ] 테스트 코드 공부하기

# step-5

## 클래스 다이어 그램
<img width="841" alt="img1" src="https://user-images.githubusercontent.com/100547825/225596290-bce774ff-fb9e-4bde-980a-ec43de0c60ba.png">

## 구현 결과
```
참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
light,honux,jk,crongfgg
각 항목은 다섯글자 이하로 입력해주세요
참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
light,honux,jk,crong
결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)
asdfadfs,gadgsgds
입력한 유저 수와 결과 수가 다릅니다.
결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)
sadfafsd,a,f,g
각 항목은 다섯글자 이하로 입력해주세요
결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)
당첨,꽝,꽝,꽝
최대 사다리 높이는 몇 개인가요?
5
light honux jk    crong 
 |     |-----|     |
 |-----|     |     |
 |     |     |     |
 |-----|     |     |
 |-----|     |-----|
당첨    꽝     꽝     꽝     
결과를 보고 싶은 사람은?
pobi
해당 유저 존재하지 않음
결과를 보고 싶은 사람은?
light
실행결과
꽝
결과를 보고 싶은 사람은?
jk
실행결과
당첨
결과를 보고 싶은 사람은?
all
실행결과
light  : 꽝
honux  : 꽝
jk     : 당첨
crong  : 꽝

결과를 보고 싶은 사람은?
춘식이
춘식이 입력 게임종료

Process finished with exit code 0
```
## 구현 내용

### 사다리 이동

유저 리스트보다 1 작은 사다리 리스트 때문에 사다리 시작 인덱스를 -1이라고 생각하고 구현하려 했으나 정리가 잘되지 않아서

시작 인덱스를 0으로 두고 비교하는 시점에서 0이 들어갈 경우만 생각해서 조건을 처리하여 해결했다.

~~~java
public int moveLine(int userNumber,int countOfPerson){
        if(userNumber>0 && point.get(userNumber-1)){
            return userNumber-1;
        }
        if(userNumber<countOfPerson && point.get(userNumber)) {
            return userNumber+1;
        }
        return userNumber;
    }
~~~
~~~ java
public int ladderMove(int userNumber) {
        for(Line temp : ladder) {
            userNumber = temp.moveLine(userNumber, countOfPerson);
        }
        return userNumber;
    }
~~~

### 예외처리

입력 부분에서 유효성을 검사 하기 때문에 예외가 발생하면 다시 입력하도록 함

Input.java
~~~java
public  String vaildName() throws IOException {
        String name = insertUser();
        Validator validator = new Validator();
        while (!validator.nameValidate(name.split(","))){
            name = insertUser();
        }
        return name;
    }
~~~
Validator.java
~~~java
    public boolean nameValidate(String[] name){
        try {
            checkLimit(name);
            return true;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void checkLimit(String[] name){
        for(String temp : name) {
           statementLimit(temp);
        }
    }
    public void statementLimit(String name) {
        if(name.length()>5) {
            throw new IllegalArgumentException("각 항목은 다섯글자 이하로 입력해주세요");
        }
    }
~~~

ResultLog.java

결과는 ResultLog 클래스의 List<ResultDto>에 저장 되어 있는 값들을 조회 하는 
방식이므로, 유효성 검증을 리스트가 만들어지는 클래스에서 함.
~~~ java
    private List<ResultDto> resultLog;

    private String findResult(String name) {
        for (ResultDto temp : resultLog) {
            if(temp.getUserName().equals(String.format("%-6s",name))) {
                return "실행결과\n"+temp.getResult();
            }
        }
        throw new IllegalArgumentException("해당 유저 존재하지 않음");
    }


    public String existValidate(String name,Input input) throws IOException {
        if(name.equals("춘식이")){
            return "춘식이 입력 게임종료";
        }
        if(name.equals("all")){
            return toString();
        }
        try {
            return findResult(name);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return existValidate(input.insertFindUser(),input);
    }
~~~

### 리스트 접근 최소화???
외부에서 리스트의 내용이 필요 한 것들은 다음과 같이 String 형식으로 보냄

~~~ java
    private List<String> userList(){
        return Arrays.stream(name.split(","))
                .map(this::formatName)
                .collect(Collectors.toList());
    }

    public String individualUser(int i){
        return userList().get(i);
    }
~~~

## dto 사용
map과 비교했을 때 dto는 setter 메서드를 사용하지 않으면 생성자로 값을 초기화해주어 불변 객체를 만들 수 있어 전달 과정 중 변조를 막을 수 있다고 한다. 

값을 다른 객체로 전달해야 할 때는 값을 덮어쓸 수 있는 map 보다 좋은 방법이라고 하여 dto를 사용해 봤다.

아래 링크로 조금 더 공부해봐야 명확한 이유를 알 수 있을것같다.

[참조]https://mangkyu.tistory.com/164

## 느낀 점
예외처리 너무 까다로웠다.

객체지향적 설계/구현이 너무 어렵다.

최대한 노력해 봤는데 제대로 한 건지 모르겠다.

이번주 안에 목표했던 5단계를 끝내서 후련하다. 


# step - 6 구현 결과

<img width="1440" alt="image" src="https://user-images.githubusercontent.com/100547825/226191921-d3a32a24-2c92-424d-a43d-d0442cad6d14.png">
<img width="1440" alt="image" src="https://user-images.githubusercontent.com/100547825/226191984-6a814c54-12af-4063-8033-fd5b2d96bb5b.png">

<img width="1440" alt="image" src="https://user-images.githubusercontent.com/100547825/226192029-79ce9f45-b583-4539-b124-e36f19cf02a5.png">

<img width="1440" alt="image" src="https://user-images.githubusercontent.com/100547825/226192073-7e7776dd-dec1-41d8-a6f4-974244053552.png">

<img width="1440" alt="image" src="https://user-images.githubusercontent.com/100547825/226192095-a056fb25-8e05-4d21-ac34-f7b6ee75704d.png">

<img width="1440" alt="image" src="https://user-images.githubusercontent.com/100547825/226192122-6c5ebf3a-5d7a-44c0-891d-542711afd955.png">

## 구현 과정
Input 클래스를 이용해 콘솔에서 input 받는 부분을 빼고는 쓰던 로직들을 사용했고, 컨트롤러에서 매핑을 통해 웹 input에서 값들을 받아와서 서비스에서 가공하여 다시 웹으로 출력했다.

템플릿 엔진 타임리프를 통해 자바에서 던진 객체들을 받아 html에 뿌렸다.

예외 처리 같은 경우는 자바에서 쓴 Exception 부분을 어떻게 처리할지 몰라 완벽하게 구현하지 못하고 실패 값을 따로 지정해 줘서 출력시켰다.

## 아쉬운 점
비동기로 구현해 보고 싶었으나 form 액션만을 사용해서 페이지와 데이터를 넘기는 것도 익숙하지 않아 구현하지 못했다.

예외 처리 부분을 어떻게 처리해야 할지 몰라서 처리하지 못한 부분이 아쉽다.

컨트롤러와 서비스를 나눈다고 나눴지만 한 가지 메서드가 한 가지 일만 하지 않고 여러 일을 하는 느낌이다. 수정하려면 사다리게임 로직을 건드려야 할 거 같아 시간 관계상 시도하지 못했다.





