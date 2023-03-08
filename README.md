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
