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
- [ ]  step-5 설계 및 구현 (2일안에 못하면 포기 후 로또구현)
- [ ]  오브젝트 책 읽기
- [ ] 테스트 코드 공부하기
