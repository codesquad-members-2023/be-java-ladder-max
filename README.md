# Java Lotto

- Last Update: 2023-3-6

## 학습 계획
-[ ] 자바 클린 코딩 기초
-[ ] 자바 문자열
-[ ] 리스트와 제네릭
-[ ] Java Collection Framework
-[ ] TDD Basic
-[ ] Java Exception
-[ ] Java Enum
-[ ] SparkJava
-[ ] JVM

## 자바 클린 코딩 기초
### 객체지향 생활체조 원칙
#### 1. 한 메서드에 오직 한 단계의 들여쓰기(indent)만 한다.
#### 2. else 예약어를 쓰지 않는다.   
   1. 효과
       - 가독성 향상    
         ex. return 문으로 메소드에서 나옴 -> 불필요한 코드 실행 생략 + 잠재적 오류 예방
       - 조건문을 더 적게 쓰는 코드를 지향하게 됨 -> 코드를 더 작은 단위로 분리하게 됨 -> 객체지향
   2. 관련 기법
       - Guard Clause(Early Return, 보호절 숙어)   
         사전 조건을 판별하여 거짓이라면 예외 혹은 반환 처리하여 더 이상 다음 단계가 실행되지 않도록 사전에 차단하는 방식
      ```java
      class NoGuardClause{
        void foo(int a, int b, int c){
            if(a != 0){
                if(b != 0){
                    if(c != 0){
                        //실행할 코드
                    }
                }
            }
        }
      }
      
      class GuardClause{
        void foo(int a, int b, int c){
            if(a == 0){
                return;
            }
            if(b == 0){
                return;
            }
            if(c == 0){
                return;
            }
            //실행할 코드
        } 
      }
      ```
      
   <details>
   <summary>참고자료</summary>
   
   - Guard Clause   
   https://codify.tistory.com/137
   - 성능과 가독성을 높이는 분기 처리 방법
   https://jeaha.dev/80
   - 조건부 로직 간소화
   https://sungjk.github.io/2021/04/17/refactoring-04.html
   - 객체지향 생활체조 원칙
   https://devwooks.tistory.com/59
   </details>    

#### 3. 모든 원시값과 문자열을 포장한다.    
#### 4. 한 줄에 점을 하나만 찍는다.
#### 5. 줄여쓰지 않는다(축약 금지).
#### 6. 모든 엔티티를 작게 유지한다.
#### 7. 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
#### 8. 일급 콜렉션을 쓴다.
#### 9. 게터/세터/프로퍼티를 쓰지 않는다.

## 자바 문자열
