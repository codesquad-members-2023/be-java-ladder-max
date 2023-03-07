# Java Ladder

- Last Update: 2023-3-7

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
-[ ] 미션 구현   

## 자바 클린 코딩 기초

### 객체지향 생활체조 원칙
<details>
<summary></summary>

#### 1. 한 메서드에 오직 한 단계의 들여쓰기(indent)만 한다.   
   - 한 메서드 안에 중첩된 제어구조가 있다면 다단계의 추상화를 코드로 짠 것이며, 고로 한 가지 이상의 일을 하고 있다는 뜻이다.
정확히 한 가지 일을 하는 메서드들로 작업을 하면 코드가 달라지기 시작한다. 애플리케이션의 각 단위가 더 작아짐에 따라 재사용의 수준은 기하급수적으로 상승하기 시작한다.

#### 2. else 예약어를 쓰지 않는다.   
- 효과
    - 조건문을 더 적게 쓰는 코드를 지향 -> 코드를 더 작은 단위로 분리(다형성 등) -> 객체지향
     - 가독성 향상    
     ex. return 문으로 메소드에서 탈출 -> 불필요한 코드 실행 생략 + 잠재적 오류 예방
- 방법
     - 다형성 (ex. 전략 패턴)
     - Early Return
     - 삼항 연산자
     - Guard Clause(보호절 숙어)   
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

#### 3. 모든 원시값과 문자열을 포장한다.
- 원시형 변수로는 컴파일러가 의미적으로 맞는 프로그램 작성을 안내할 수 없다. 객체로라면 아주 사소하더라도 컴파일러와 프로그래머에게 그 값이 어떤 값이며, 왜 쓰고 있는지에 대한 정보를 전하는 셈이다.

#### 4. 한 줄에 점을 하나만 찍는다.
- 어떠한 코드 한 줄에서라도 점이 하나 이상 있다면 어쩌면 객체는 다른 두 객체를 동시에 다루고 있을지도 모른다. 이 경우 그 객체는 중개상, 즉 너무 많은 사람들에 대해 지나치게 알고 있는 꼴이다. 그 모든 점들이 연결돼 있다면 대상 객체는 다른 객체에 깊숙이 관여하고 있는 셈이다. 이런 중복된 점들은 캡슐화를 어기고 있다는 방증이기도 하다. 객체가 자기 속을 들여다보려 하기보다는 뭔가 작업을 하도록 만들어야 한다. 캡슐화의 주 요점은 클래스 경계를 벗어나 알 필요가 없는 타입으로 진입하지 않는 것이다.
- 책임 소재의 오류   
  단일 책임 원칙 : 모든 클래스는 하나의 책임만 가지며, 클래스는 그 책임을 완전히 캡슐화해야 한다.
- 디미터의 법칙(LoD)   
  "최소한의 지식 원칙(The Principle of Least Knowledge)으로 알려져 있으며, 모듈은 자신이 조작하는 객체의 속사정을 몰라야 한다는 것을 의미한다.

#### 5. 줄여쓰지 않는다(축약 금지).
- 클래스와 메서드 이름을 한두 단어로 유지하려고 노력하고 문맥을 중복하는 이름을 자제하는 것이 좋다. 클래스 이름이 Order라면 shipOrder라고 메서드 이름을 지을 필요가 없다. 짧게 ship()이라고 하면 클라이언트에서는 order.ship()라고 호출하며, 간결한 호출의 표현이 된다.

#### 6. 모든 엔티티를 작게 유지한다.
- 이 말은 50줄 이상 되는 클래스와 파일이 10개 이상인 패키지는 없어야 한다는 뜻이다. 50줄 이상의 클래스는 보통 한 가지 일 이상을 하는 것이며, 따라서 코드의 이해와 재사용을 점점 더 어렵게 끌고 간다. 클래스를 작게 작성할 때 난감한 경우는 같이 있어야 말이 되는 동작의 묶음이 있을 때다. 이는 패키지를 최대한 활용해야 하는 곳이기도 하다. 클래스가 점점 작아지고 하는 일이 줄어들며 패키지 크기를 제한함에 따라 패키지가 하나의 목적을 달성하기 위해 모인 연관 클래스들의 집합을 나타낸다는 사실을 알아차리게 된다. 패키지도 클래스처럼 응집력 있고 단일한 목표가 있어야 한다. 패키지를 작게 유지하면 패키지 자체가 진정한 정체성을 지니게 된다.
#### 7. 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
- 새로운 인스턴스 변수를 하나 더 기존 클래스에 추가하면 클래스의 응집도는 즉시 떨어진다. 속성의 집합에서 객체를 협력 객체의 계층구조로 분해하면 더 직접적으로 효율적인 객체 모델에 이른다.
```java
class Animal{
    String name;
    String species;
    String color;
    String sound;
        }
```
```java
class Animal{
    Species species;
    String name;
}
class Species{
    String color;
    String sound;
}
```

#### 8. 일급 콜렉션을 쓴다.
- 콜렉션을 포함한 클래스는 반드시 다른 멤버 변수가 없어야 한다.
- 효과
  ##### 1. 비지니스에 종속적인 자료구조
  - 특정 조건으로만 생성 할 수 있는 자료구조를 일급 콜렉션으로 생성하여, 검증 로직 생략 가능
  ##### 2. Collection의 불변성을 보장
  - Java의 final은 재할당만 금지하므로, 콜렉션의 데이터를 변경할 수 있는 등 완전한 불변성을 보장하지 않는다.
    그래서 Java에서 불변성을 구현하기 위해서는 일급 콜렉션이나 래퍼 클래스를 활용한다.
  - 일급 콜렉션으로 불변 콜렉션 구현   
    콜렉션의 값을 변경할 수 있는 메소드가 없는 일급 콜렉션을 만든다.
  - 래퍼 클래스 (ex. Integer, Character)   
    래퍼 클래스는 불변 객체이기 때문에 한 번 값이 할당되면 변경이 불가능하다.
    
  ##### 3. 상태와 행위를 한 곳에서 관리
  ```java
    import java.util.List;
    class Animals{
        //상태
        List<String> animals = {"고양이", "강아지"};
        
        //행위
        long animalCount = animals.stream()
                            .count();
    }
  ```
    위 코드는 상태와 행위가 따로 관리되고 있다.
  ```java
    import java.util.List;
    class Main{
        List<String> animals = {"고양이", "강아지"};
  
        //상태와 행위가 animalGroups라는 한 곳에서 관리되고 있다.
        AnimalGroups animalGroups = new AnimalGroups(animals);
        long animalCount = animalGroups.getCount();
    }

    class AnimalGroups{
        private List<String> animals;
        
        public AnimalGroups(List<String> animals){
            this.animals = animals;
        }     
  
        public long getCount(){
            return animalCount = animals.stream()
                            .count();
        } 
   }
  ```
  위 코드는 상태와 행위가 animalGroups라는 한 곳에서 관리되고 있다.   

  ##### 4. 이름이 있는 컬렉션
  - 별도의 타입으로 만듦으로써 변수명으로만 구분하는 것보다 의미가 명확해진다.
  - 타입명으로 검색이 가능해진다.
  
#### 9. 게터/세터/프로퍼티를 쓰지 않는다.
- 강한 캡슐화 경계의 바탕에 깔린 사상은 동작의 검색과 배치를 위해 남겨둔 코드를 만질 다른 프로그래머를 위해 객체 모델의 단일한 지점으로 유도하려는 것이다. 
- “말을 해, 묻지 말고”
- 효과
    - 중복 오류의 극적 축소
    - 새 기능의 구현을 위한 변경의 지역화 개선


#### 참고 자료
- Guard Clause   
  https://codify.tistory.com/137
- 성능과 가독성을 높이는 분기 처리 방법
  https://jeaha.dev/80
- 조건부 로직 간소화
  https://sungjk.github.io/2021/04/17/refactoring-04.html
- 객체지향 생활체조 원칙   
  https://devwooks.tistory.com/59
- 더 나은 소프트웨어를 향한 9단계: 객체지향 생활 체조
  https://developerfarm.wordpress.com/2012/02/03/object_calisthenics_summary/
- 일급 컬렉션의 소개와 써야할 이유
  https://jojoldu.tistory.com/412
- 래퍼 클래스
  http://www.tcpschool.com/java/java_api_wrapper

</details>

## 자바 문자열
