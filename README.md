# Java 사다리 게임

- Last Update: 2023-03-06

## 학습계획
1. 루카스 Java Programming의 자바 문자열 파트를 학습한다.
2. 사다리 게임 1단계 기능을 구현한다.
3. 2단계 요구사항대로 리팩토링을 진행한다.
4. 리스트와 제네릭 파트를 학습한다.
5. 3단계 기능을 ArrayList를 사용해서 구현한다.
6. 4단계 요구사항대로 리팩토링을 진행한다.
7. 구현 내용 및 학습한 내용을 정리한다.

## 자바 문자열
### String의 생성
```java
// String의 생성 방법 2가지
String a = "문자열";
// 그러나 new를 이용해서 생성하는 것은 좋지 않다.
String b = new String("문자열");
```
String은 ""를 사용해서 생성하면 String Pool이라는 영역에 저장되어서 재사용된다.  
그러나 new를 사용해서 생성하면 같은 문자열이어도 Heap 영역에 객체를 계속 생성해서 사용하게 된다.  
그러므로 String은 ""로 생성하는 것이 메모리를 효율적으로 사용한다.
```java
String s1 = "cat";
String s2 = "cat";
String s3 = new String("cat");

s1 == s2 // true
s1 == s3 // false
```
> - String은 객체이지만 문자의 배열이다.
> - String은 한번 생성하면 값을 변경할 수 없는 불변객체이다.
### String + String
String은 immutable하기 때문에 String + String으로 문자열을 결합하면 기존 String 객체가 변경되는 것이 아니라
새로운 String 객체를 생성하는 것이다.  
String은 +를 할 때마다 메모리를 계속해서 할당하고 해제하게 된다.  
그래서 여러 개의 String을 결합할 때는 StringBuilder를 사용하면 효율적이다.
### StringBuilder
```java
StringBuilder sb = new StringBuilder();
sb.append("step1 : 기본 기능 구현");
sb.append("\n");
sb.append("step2 : 리팩토링");
String s = sb.toString();
// step1 : 기본 기능 구현
// step2 : 리팩토링
```
### StringBuilder vs. StringBuffer
StringBuilder와 StringBuffer는 둘 다 String의 불변성으로 인한 문제를 해결하기 위해서 문자열의 크기를 유연하게 변경할 수 있도록 만든 클래스이다.  
단, StringBuffer는 동기화를 지원해서 멀티쓰레드 환경에서 안전하다는 특징이 있다.  
그래서 단일쓰레드 환경에서는 동기화 처리를 하지 않는 StringBuilder의 성능이 더 좋다.

## 1단계 - 기본 기능 구현
### 입력을 받는 Input 클래스
- input() : 사람 수와 사다리 높이를 입력받아 int[]로 리턴해준다.
### 사다리에 관련된 기능을 하는 Ladder 클래스
- 사다리 높이 height와 사다리 라인 char 이차원 배열 line을 가진다.
- createLine() : n과 m을 입력 받아서 [n-1][m] 크기의 이차원 배열에 랜덤하게 라인을 생성한다.
- getRandomLine() : 랜덤하게 '-' 또는 ' ' 을 리턴한다.
- print() : 사다리 전체를 출력한다.

## 2단계 - 리팩토링 맛보기
### 요구사항
- 메소드는 한 가지 일만 하도록 하고 최대 10라인을 넘지 않도록 구현한다.
- 들여쓰기는 2단계에서 1단계로 줄인다.
- else를 사용하지 않는다.
- 구현 순서를 고려하며 프로그래밍 한다.
- naming convention을 지킨다.

### 구현 순서
1. Input 클래스 구현
2. Ladder 클래스 - 랜덤하게 line 문자 생성하는 메소드 구현
3. Ladder 클래스 - line을 랜덤한 문자로 채우는 메소드 구현
4. Ladder 클래스 - 사다리를 출력하는 메소드 구현

### naming convention
- 낙타 표기법(Camel Case) : 의미를 가지는 단어의 첫 글자는 대문자, 나머지는 소문자
- 클래스명 첫글자는 대문자
- 메소드명, 변수명 첫글자는 소문자
- 클래스명과 변수명은 주로 명사, 메소드명은 주로 동사

### 이중 for문 분리
depth를 2단계에서 1단계로 줄이기 위해서 이차원 배열을 생성하고 순회하기 위한 이중 for문에서 
내부 for문을 메소드로 분리한다.
- 하나의 열을 생성하는 메소드 createOneColumn()으로 분리
```java
public void createRadder(int num, int height) {
    this.height = height;
    radder = new char[num-1][height];

    for(int i = 0; i< radder.length; i++){
        createOneColumn(i);
    }
}
```
- 하나의 행을 String으로 반환하는 메소드 makeOneRow()으로 분리
```java
public void printRadder() {
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<height; i++){
        sb.append(makeOneRow(i));
        sb.append("\n");
    }
    System.out.println(sb);
}
```
> 사다리의 라인을 가지고 있는 이차원 배열명 line이 애매한 이름인 것 같아서 line -> radder 로 변경했다.  
> createLine() -> createRadder()  
> print() -> printRadder()

### 실행결과
![capture1](https://user-images.githubusercontent.com/57559288/223097601-82dee291-abe4-41b9-acea-06cb0e78a034.png)
