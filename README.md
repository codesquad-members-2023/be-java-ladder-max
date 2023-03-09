# 목차

- [Java Ladder](#Java-Ladder)
- [학습목표](#학습목표)

# Java Ladder

- Last Update: 2022-3-9

## Todolist

- [x] ConsoleInput 클래스의 사용자 입력 기능 리팩토링
- [x] 이중 반복문을 일종 반복문으로 리팩토링
- [x] static 출력 메서드를 인스턴스 메서드로 변경
- [x] 사용자 이름 입력 및 검증 기능 구현
- [x] 콘솔 출력을 위한 사용자 이름 및 사다리 포맷팅
- [ ] 브리지 연속으로 나오지 않게 하기

## 기능요구사항

- 사다리 게임
    - [x] n명의 사람과 m개의 사다리 높이의 사용자 입력
        - 사람은 최소 2명 이상이어야 합니다.
        - 사다리의 최소 높이는 1 이상이어야 합니다.
        - 사용자가 입력에 맞지 않은 범위나 문자 입력시 경고 메시지 출력후 다시 입력하게 합니다.
    - [x] 랜덤한 사다리 라인 생성
        - 사다리 라인 : `"-"`
        - 사다리 라인 없음 : `" "`(공백 문자)
        - 사다리 기둥 : `"|"`
    - [x] 사다리 출력
        - 출력시 이름도 같이 출력되어야 합니다.
    - [x] 사다리 게임에 참여하는 사용자 이름 입력
        - 사용자의 이름은 최대 5글자까지 부여할 수 있습니다.
        - 사용자 이름 입력시 쉼표(,)를 기준으로 구분합니다.
        - ex) pobi,honux,crong,jk
    - [ ] 사다리의 브릿지(-----)가 한 라인에 2개 이상 연속으로 이어지면 안됩니다.

## 프로그래밍 요구사항

- 메서드 크기는 최대 10라인입니다.
- 메서드가 한 가지 일만 하도록 합니다.
- else를 사용하지 마십시오.
- ArrayList와 Generic을 활용하십시오.

## 예상 결과 및 동작 예시

```
참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
pobi,honux,crong,jk

최대 사다리 높이는 몇 개인가요?
5

실행결과

  pobi  honux crong   jk
    |-----|     |-----|
    |     |-----|     |
    |-----|     |     |
    |     |-----|     |
    |-----|     |-----|
```

```
참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
pobi,honux,crong,jkawoeifnoawefn
참여할 사람의 이름은 영어 최대 5글자로 구성되어야 합니다. 다시 입력해주세요

참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
pobi
참여할 사람은 최소 2명 이상이어야 합니다. 다시 입력해주세요.

참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
pobi123, jk
참여할 사람의 이름은 영어 최대 5글자로 구성되어야 합니다. 다시 입력해주세요

참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
pobi,honux,crong,jk

최대 사다리 높이는 몇 개인가요?
abc
적절하지 않은 입력입니다. 1 이상의 사다리 높이를 입력해주세요.

최대 사다리 높이는 몇 개인가요?
5

실행결과

  pobi  honux crong   jk
    |-----|     |-----|
    |     |-----|     |
    |-----|     |     |
    |     |-----|     |
    |-----|     |-----|
```

## 도메인 모델

![](img/img_7.png)

## 빌드 및 실행

```shell
$ ./gradlew build
$ java -jar ./build/libs/java-lotto-1.0-SNAPSHOT.jar
```

# 학습목표

- [x] [String, StringBuilder, StringBuffer 비교](#String,-StringBuilder,-StringBuffer-비교)
- [x] [String과 new String() 차이](#String과-new-String()-차이)
- [x] [Return Early Pattern](#Return-Early-Pattern)
- [x] [private 메서드 테스트 지양해야 하는 이유 학습](#private-메서드-테스트-지양해야-하는-이유)
- [x] [클린 코딩 기초 학습](#클린-코딩-기초)
- [ ] [static 메서드와 인스턴스 메서드의 비교](#static-메서드와-인스턴스-메서드의-비교)
- [ ] PR 머지 승인전에 브랜치를 따서 해당 브랜치 기반으로 작업하여 다시 PR할 경우 커밋이 딸려오는 문제해결하기

## String, StringBuilder, StringBuffer 비교

### String, StringBuilder, StringBuffer의 특징

- String : String 객체는 한번 값이 할당되면 변하지 않은 `불변성(Immutable)`을 가집니다.
- StringBuilder, StringBuffer : 한번 값이 할당되더라도 한번 더 다른 값이 할당되면 할당된 공간이 변하는 `가변성(mutable)`을 가집니다.

### String vs StringBuilder/StringBuffer

```java
public class StringTest {

    @Test
    @DisplayName("String, StringBuilder, StringBuffer 객체간의 주소변화를 확인하는 테스트")
    public void compareAddress() {
        String str = "String";
        StringBuilder sb = new StringBuilder();
        StringBuffer sbf = new StringBuffer();

        sb.append("StringBuilder");
        sbf.append("StringBuffer");

        // 연산전 객체들의 주소
        System.out.printf("String 객체 주소 : %d%n", str.hashCode());
        System.out.printf("StringBuilder 객체 주소 : %d%n", sb.hashCode());
        System.out.printf("StringBuffer 객체 주소 : %d%n", sbf.hashCode());

        str += "Test";
        sb.append("Test");
        sbf.append("Test");

        System.out.println("===========================");
        System.out.printf("String 객체 주소 : %d%n", str.hashCode());
        System.out.printf("StringBuilder 객체 주소 : %d%n", sb.hashCode());
        System.out.printf("StringBuffer 객체 주소 : %d%n", sbf.hashCode());
    }
}
```

```text
String 객체 주소 : -1808118735
StringBuilder 객체 주소 : 771485597
StringBuffer 객체 주소 : 1943040889
===========================
String 객체 주소 : 420381795
StringBuilder 객체 주소 : 771485597
StringBuffer 객체 주소 : 1943040889
```

위 실행 결과와 같이 String 객체의 주소는 연산후에 변했지만 StringBuilder/StringBuffer 객체는 주소가 변하지 않았음을 알 수 있습니다.

### String

```shell
String str = "hello";
str = str + "world";
```

위와 같은 코드 실행시 문자열의 저장과정은 다음 그림과 같습니다.

![](img/img.png)

1. 스택 공간에 str 포인터가 생성됩니다.
2. str 포인터는 힙 영역의 String Pool 공간에 "hello"가 저장된 주소를 가리킵니다.
3. "hello world" 문자열을 저장하도록 명령어를 실행합니다.
4. str 포인터가 기존 "hello"가 저장된 주소에서 "hello world"가 저장된 주소를 가리키도록 합니다.
5. 더이상 참조하지 않은 "hello" 주소 공간을 가비지 컬렉션(GC, Garbage Collection)이 제거합니다.

- String은 불변성 객체이기 때문에 변하지 않은 문자열을 읽을때 좋은 성능을 기대할 수 있습니다.
- 문자열의 추가, 수정, 삭제 등의 연산이 자주 일어나는 로직에서는 String 객체를 사용하면 힙 메모리에 많은
  가비지가 생성되어 힙 메모리 부족으로 성능에 영향을 미칠 수 있습니다.

### StringBuilder / StringBuffer

StringBuilder와 StringBuffer의 관계는 다음과 같습니다.

![](img/img_1.png)

위 그림과 같이 StringBuilder와 StringBuffer는 같은 부모인 AbstractStringBuilder 추상 클래스의 자식 클래스들입니다.

AbstractStringBuilder의 필드 멤버는 다음 2가지를 가지고 있습니다.

- value : 문자열의 값을 저장하는 byte 배열
- count : 현재 문자열의 크기 값을 가지는 int 타입 변수

AbstractStringBuilder 추상 클래스의 append() 메서드는 다음과 같습니다.

```java
abstract class AbstractStringBuilder implements Appendable, CharSequence {

    // ...
    public AbstractStringBuilder append(String str) {
        if (str == null) {
            return this.appendNull();
        } else {
            int len = str.length();
            this.ensureCapacityInternal(this.count + len);
            this.putStringAt(this.count, str);
            this.count += len;
            return this;
        }
    }
}
```

- 문자열을 추가하게 되면 추가할 문자열의 길이만큼 우선 배열의 공간을 늘려주고 늘린 공간에 문자열을 넣어주는 방식입니다.
- 따라서 StringBuilder와 StringBuffer에 append를 통해서 값을 추가하여도 같은 주소 공간을 참조하게 되는 것입니다.

![](img/img_2.png)

1. 스택 공간에 StringBuilder 타입의 포인터가 생성됩니다.
2. append("hello")를 호출하여 sb 포인터가 가리키는 주소를 시작으로 "hello" 문자열 값을 추가합니다.
3. append(" world")를 호출하여 sb 포인터가 가리키는 주소를 시작으로 " world" 문자열 값을 추가합니다.
4. sb 포인터가 가리키는 힙 주소는 변경되지 않습니다.

위 그림과 같이 StringBuilder 또는 StringBuffer 타입의 객체로 값을 추가하거나 제거하여도 같은 주소 공간을 참조하게 되고,
값이 가변성을 가지게 됩니다.

### StringBuilder vs StringBuffer

- 두 클래스의 가장 큰 차이점은 동기화(Syncronization) 유무입니다.
- **String, StringBuffer는 동기화를 지원하여 멀티 쓰레드 환경에서 안전합니다.** (thread-safe)
- **StringBuilder는 동기화를 지원하지 않아서 멀티 쓰레드 환경에서 사용하는 것은 적합하지 않지만** 동기화를 고려하지 않는
  단일 쓰레드 환경에서는 StringBuffer보다 성능이 좋습니다.

### 정리

- String : 문자열 연산이 적고, 멀티 쓰레드 환경일 경우
- StringBuffer : 문자열 연산이 많고, 멀티 쓰레드 환경일 경우
- StringBuilder : 문자열 연산이 많고, 단일 쓰레드이거나 동기화를 고려하지 않는 경우

![](img/img_3.png)

#### StringBuffer보다 StringBuilder가 성능이 좋은 이유

StringBuffer는 동기화를 지원하여 멀티 스레드 환경에서는 안전하게 동작하지만 StringBuilder는 동기화를 지원하지 않습니다.
그래서 단일 스레드 환경에서는 StringBuilder를 사용하는 것을 권장하고 성능이 빠릅니다.

#### String이 StringBuffer/StringBuilder보다 문자열 추가연산에서 느린 이유

String의 `immutable` 특성때문입니다. String 타입으로 추가 연산을 수행하면 새로운 힙공간에 문자열 값을 생성하고 가리켜야합니다.
그리고 가비지 컬렉션에 의해서 안쓰는 값을 처리하게 됩니다. 따라서 추가 연산이 많을 수록 더 많은 시간과 메모리를 소모하게 되어
StringBuffer/StringBuilder보다 연산에서 느린 성능을 보여주게 됩니다.

## String과 new String() 차이

```java
public class StringTest {

    @Test
    @DisplayName("문자열 상수를 이용한 문자열 객체와 new String을 통한 문자열 객체간의 차이를 확인하는 테스트")
    public void testcase2() {
        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");

        System.out.println("str1 주소 : " + System.identityHashCode(str1));
        System.out.println("str2 주소 : " + System.identityHashCode(str2));
        System.out.println("str3 주소 : " + System.identityHashCode(str3));
    }
}
```

```shell
str1 주소 : 323770651
str2 주소 : 323770651
str3 주소 : 1776927822
```

위 실행결과와 같이 문자열 상수값("hello")으로 저장한 str1과 str2는 주소값이 같은 것을 볼 수 있고 new String("hello")로 객체 생성한
str3의 주소는 str1, str2와 다른 것을 볼 수 있습니다.

str1,str2와 str3간에 주소가 다른 이유는 **문자열 상수값("hello")으로 저장한 str1, str2 포인터는 힙 영역의 `String Pool` 공간에 있는
"hello" 공간의 주소를 가리키기 때문**입니다. 반면 new String("hello")으로 생성한 str3 포인터는 **힙 영역의 String Pool 공간 밖**의 있는
곳에 저장하였기 때문입니다.

이를 그림으로 표현하면 다음과 같습니다.

![](img/img_4.png)

### 정리

- String 타입 변수에 문자열 상수값("hello") 저장 : 힙영역의 String Pool 공간에 저장
- new String("hello")로 저장 : 힙 영역의 String Pool 공간이 아닌 곳에 저장

## Return Early Pattern

### Return Early Pattern 필요성

예를 들어 다음과 같은 코드가 있습니다.

```java
class Example {

    public String returnStuff(SomeObject argument1, SomeObject argument2) {
        if (argument1.isValid()) {
            if (argument2.isValid()) {
                SomeObject otherVal1 = doSomeStuff(argument1, argument2);
                if (otherVal1.isValid()) {
                    SomeObject otherVal2 = doAnotherSutff(otherVal1);

                    if (otherVal2.isValid()) {
                        return "Sutff";
                    } else {
                        throw new Exception();
                    }
                } else {
                    throw new Exception();
                }
            } else {
                throw new Exception();
            }
        } else {
            throw new Exception();
        }
    }
}
```

위와 같은 코드에서 다음과 같은 것을 발견할 수 있습니다.

- 코드의 비선형적인 흐름 : 중첩된(nested) if문으로 인하여 코드를 따라가기 어렵습니다.
- 각 if에 대응하는 else를 확인하기 어렵습니다. if 블록이 클수록 if에서 처리하는 에러를 읽기 어렵게 만듭니다.
- 예상되는 결과를 찾으려면 중첩된 if문을 따라가면서 코드의 흐름을 읽어야 합니다.
- 위 예제의 경우, 예외 케이스가 else에서 발생합니다. 만약 else가 실행문을 종료하지 않는다면, 코드의 나머지가 실행될 것입니다.
  이는 불필요한 에러를 발생 시킬 수 있습니다.

위와 같은 예제는 또한 몇가지 안티 패턴을 포함합니다.

- [Else is considered smelly](https://wiki.c2.com/?ElseConsideredSmelly) :
  조건이 복잡할 경우 else문은 두배로 복잡해집니다. 왜냐하면 읽는 사람은 if문이 실패하기 위한 복잡한 조건을 생각해야하기 때문입니다.
  그리고 if 블록이 클수록 어떠한 조건을 정했는지 까먹기 쉽습니다.
  따라서 중첩된 if와 else는 읽는 사람을 혼랍스럽게 합니다.
- [Arrow anti-pattern](https://wiki.c2.com/?ArrowAntiPattern) :
  코드의 모양이 마치 화살과 같다고 붙여진 패턴이름입니다.
  위 예제와 같이 중첩된 if문과 루프로 인해서 만들어집니다.

### Return Early Pattern 개념

- Return Early은 함수 혹은 메서드를 작성하는 방법으로, Return Early을 사용하여
  예상하는 결과가 함수의 끝에서 리턴하도록 하는 패턴입니다.
- 조건이 충족되지 않았을때 코드의 나머지 부분이 실행문을 종료(예외처리를 리턴함으로써)시킵니다.

다음 코드는 위 anti-pattern을 가지고 있는 예제를 Return Early 패턴으로 적용한 예제입니다.

```java
class Example {

    public String returnStuff(SomeObject argument1, SomeObject argument2) {
        if (!argument1.isValid()) {
            throw new Exception();
        }

        if (!argument2.isValid()) {
            throw new Exception();
        }

        SomeObject otherVal1 = doSomeStuff(argument1, argument2);

        if (!otherVal1.isValid()) {
            throw new Exception();
        }

        SomeObject otherVal2 = doAnotherStuff(otherVal1);

        if (!otherVal2.isValid()) {
            throw new Exception();
        }

        return "Sutff";
    }
}
```

위 예제를 통해 다음과 같은 특징을 찾을 수 있습니다.

- 들여쓰기의 깊이가 1 depth만 들어가있습니다. 이렇게 되면 선형적으로 위에서 아래로 읽을 수 있습니다.
- 예상 결과를 함수 끝에서 빠르게 찾을 수 있습니다. (if문은 전부 에외 관련 케이스이니 예상 결과를 바로
  싶으면 맨 밑만 확인하면 됩니다.)
- 이 사고 과정을 활용하여 에러를 가장 먼저 찾는데 주의를 기울일 수 있습니다.
  이렇게 되면 비즈니스 로직을 나중에 구현하여 안정적으로 구현할 수 있습니다.
- 예외 케이스를 먼저 처리하기 때문에 테스트 코드를 작성하기 쉽게 해줍니다.
- 함수는 에러가 발생하는 즉시 종료되기에, 의도하지 않게 코드가 실행될 가능성을 방지하게 합니다.

### Return Early 마인드 셋을 사용하여 쓸 수 있는 디자인 패턴

#### Fail Fast

- 2004년 Jim Shore와 Martin Folwer가 Fail Fast 컨셉을 창안
- Fail Fast 디자인 패턴은 Return Early 규칙의 기초입니다.
- 초기에 코드 실행이 종료될 수 있는 조건을 찾는데 집중하는 디자인 패턴입니다.
- Fail Fast 디자인 패턴을 사용하여 버그를 찾고 고치는 것을 쉽게 해줍니다.

#### Guard Clause

- `Guard Clause`는 return문이나 예외를 사용하여 즉각적으로 함수를 종료시키는 방식(if문을 뒤집은 방식)입니다.
    - if문을 뒤집은 방식은 성공했을때 if문 안쪽의 로직을 실행하는 것이 아닌 실패하는 조건을 검사하여
      예외를 발생시키는 방식이라고 생각합니다.
- Guard Clause 디자인 패턴을 사용하여 가능성이 있는 에러 케이스를 식별하고
  적절한 예외를 반환하여 각 처리를 수행합니다.

![](img/img_5.png)

위 그림의 함수에서 happy path은 어떠한 validation rule도 에러를 일으키지 않는데 있습니다.

실행문이 끝까지 성공적으로 지속되게 하여 긍정적인 응답을 반환하는 것이 happy path입니다.

#### Bouncer Pattern

- Bouncer Pattern은 에러가 발생하는지 검사하고 에러가 발생하는 조건이라면 에외를 던져서 판별하는 방법입니다.
- 판별 코드가 복잡하고 다양한 케이스에 대해 검증할때 특히 유용합니다.
- Return Early 패턴을 보완합니다.

```java
class Example {

    private void validateArgument1(SomeObject argument1) {
        if (!argument1.isValid()) {
            throw new Exception();
        }
        if (!argument2.isValid()) {
            throw new Exception();
        }
    }

    public void doStuff(String argument1) {
        validateArgument(argument1);
        // do more stuff;
    }
}
```

## private 메서드 테스트 지양해야 하는 이유

- private 메소드에 대한 테스트는 **깨지기 쉬운 테스트**가 됩니다.
- **private 메서드는 내부를 감추어 클라이언트와의 결합도를 낮춰주는데,
  클라이언트인 테스트 클래스가 내부 메서드를 알고 있으니 결합도가 높아진다.**
- private 메서드 테스트 수행시 **유지보수 비용이 증가**합니다.
  왜냐하면 private 메서드의 이름이나 매개변수 변경시 실패하게 되어 유지보수 비용이 높아지기 때문입니다.
- 리플렉션 기술 자체 역시 **컴파일 에러를 유발하지 못하여** 최대한 사용을 자제해야 합니다.
- private 메서드 테스트가 필요하다고 느끼는 순간 클래스 설계를 다시 고민해 볼 필요가 있습니다.

### private 메서드 테스트를 하지 않아야 한다면 어떻게 테스트 해야 하는가?

- 테스트 대상을 private 메서드가 아닌 private 메서드를 사용하는 public 메서드를 테스트해야 합니다.
- 실패하는 케이스와 성공하는 케이스를 나누어 private 메서드까지 커버할 수 있는 여러개의 매개변수로 테스트합니다.

## 클린 코딩 기초

### 클래스 구현 순서

클래스를 구현할때 다음 순서를 지켜 구현합니다.

```java
class Ladder {
    //상수 및 클래스 변수

    //인스턴스 변수

    //생성자

    //메서드
}
```

### Naming Convention

- 자바 언어는 `Camel Case`를 따릅니다.
    - Camel Case : 중간 글자들은 대문자로 시작하지만 첫 글자가 소문자인 케이스
    - ex) personNumber, studentAge
- 클래스명은 `대문자`로 시작합니다.
- 변수와 메서드는 `소문자`로 시작합니다.
- 클래스와 변수명은 `명사` 형태를 사용합니다.
- 메서드명은 `동사`로 시작합니다.
- 클래스 이름 예 : Rectangle, LaundryList, StudentDirectory
- 변수 이름 예 : firstName, description, mediaController
- 메소드 이름 예 : getFirstName(), cancelOrder(), isDeleted()

### 클린 코드 지향

- 들여쓰기를 줄이는 가장 좋은 방법은 메서드를 분리하는 것입니다.
- 들여쓰기가 2 이상인 메서드의 경우 메서드를 분리하는 방법을 찾습니다.
- 메서드 라인이 10라인을 넘어가는 경우 메서드를 분리합니다.
- else를 사용하지 않으려면 if 절에서 값을 바로 return해서 메서드를 종료하는 방법을 사용합니다.
    - [Return Early](#Return-Early-Pattern)

## static 메서드와 인스턴스 메서드의 비교

### 어떤 경우에 static 메서드를 사용해야 하는가?

- 변화를 가정하지 않는 경우
- 메서드가 인스턴스 변수를 사용하지 않는 경우
- 인스턴스 생성에 의존하지 않는 경우
- 메서드가 공유되고 있다면 정적 메서드로 추출할 수 있는 경우
- 메서드가 변환하지 않고 오버라이딩 되지 않는 메서드인 경우

대표적인 유틸리티 정적 메서드는 Math 클래스의 max나 min과 같은 메서드가 존재합니다.

### static 메서드 사용시 단점

- **static 메서드 사용시 객체 지향에서 멀어지게 됩니다.**
    - static은 객체 지향보다는 절차 지향에 가까운 키워드입니다.
    - static 키워드는 C의 전역변수/함수와 성격이 비슷합니다. 정적 메소드는 객체의 생성, 제거와 관계없이 프로그램
      시작부터 끝까지 메모리에 남아있기 때문입니다.
- **static 메서드는 객체 지향의 메시지 전달을 위반합니다.**
    - 객체 지향에서는 객체들이 서로 관계를 맺고 메시지를 통해 정보를 교환하고 결과를 반환합니다.
    - 이는 static 메서드가 객체에게 행위를 지시하는 것이 아닌 것을 알 수 있습니다.
    - 또한 다른 객체와 관계를 맺지도 않습니다. 즉, 메시지 전달이 아닌 절차 지향의 함수 호출에 가깝습니다.
- **static 메서드를 사용하면 해당 메서드는 메서드 재정의(오버라이딩)을 할 수 없어 객체의 다형성을 활용할 수 없습니다.**
    - static 메서드는 오버라이딩이 불가능하기 때문에 인터페이스를 구현할 수 없습니다.
    - 왜냐하면 static 메서드는 런타임 이전 컴파일 타임에 정적 바인딩이 이루어지기 때문입니다.
        - 정적 바인딩이란 어떤 정적 변수나 메서드가 컴파일 타임에 값이나 타입이 정해진다는 의미입니다.
- **static 메서드는 메모리 효율이 떨어질 수 있습니다.**
    - static 메서드는 반복적으로 객체를 생성하지 않아도 되니 메모리 효율에 좋을 것 같다는 생각이 듭니다.
    - 그러나, 런타임 중 동적으로 생성된 것들은 가비지 컬렉션의 대상이 되는 반면, static 키워드가 붙은 것들은
      가비지 컬렉션의 대상이 안됩니다. static으로 할당된 영역이 클수록 가비지 컬렉션의 효율이 떨어지고 프로그램이
      끝날 때까지 그 영역은 메모리에서 내릴 수 없습니다.
    - 즉, **static 영역이 지나치게 많은 메모리를 차지하고 있다면 메모리 부족 현상이 발생할 수 있습니다.**

### static 메서드 저장 위치

- static 메서드는 static 메서드가 속한 클래스와 함께 컴파일 과정에서 Metaspace(자바 8 아래에서는 Permanent Gneration)
  라는 특별한 메모리 영역에 저장됩니다.
- static 메서드의 파라미터, 지역 변수, 반환 값들은 stack 영역에 저장됩니다.

### static 메서드 특징

- 객체 생성없이 클래스명을 통해 호출할 수 있습니다.
    - ex) Person.calculateAge("1990-01-01")
- 같은 클래스를 통해서 생성된 객체들간에 같은 코드를 사용하는 것을 보장하기 위해서 사용합니다.
- 정적 메서드는 오버라이드(Override) 될 수 없습니다. 컴파일 과정에서 정적 바인딩이 되어 메서드 타입이 정해집니다.
    - 부모 클래스와 자식 클래스 간 같은 이름의 메서드를 정의할 수는 있지만 항상 상위 클래스의 정적 메서드만 호출됩니다.

### static 변수가 다른 객체를 참조하는 경우

```
static int i = 1;
static Object obj = new Object();
```

- 정적 변수의 값 1은 Metaspace에 저장됩니다.
- **obj는 Metaspace에 저장되나 Object 클래스의 객체는 heap 영역에 적재됩니다.**
- **참조 변수 obj에 담기는 Object의 참조값(메모리 주소)는 Metaspace에 저장됩니다.**

### static 메서드와 인스턴스 메서드 비교

- 인스턴스 메서드는 인스턴스 메서드와 인스턴스 변수를 직접 호출 가능합니다.
- 인스턴스 메서드는 정적 변수와 정적 메서드를 직접 호출 할 수 있습니다.
- static 메서드는 정적 변수와 정적 메서드를 직접 호출할 수 있습니다.
- static 메서드는 인스턴스 메서드와 인스턴스 변수를 호출할 수 없습니다.

### 인스턴스 메서드 저장 위치

- 인스턴스 메서드는 자바 8 이후 Metaspace 영역의 Method Area에 저장됩니다.
- 인스턴스 메서드의 파라미터, 지역 변수, 반환 값들은 stack에 영역에 할당됩니다.

### 인스턴스 메서드의 특징

- 인스턴스 메서드는 클래스의 객체에 속해있는 것이지 클래스에 속해있는 것이 아닙니다.
  즉, 클래스로 객체를 생성하고서 그 객체를 통해서만 호출할 수 있습니다.
- 인스턴스 메서드라고 해서 매번 객체가 생성될 때마다 함께 생성되는 것이 아닙니다.
  메모리에서 한번 할당이 되고 각 생성된 객체들은 그 메서드가 메모리 어디에 존재하는지를 알 뿐입니다.
  객체가 메모리가 할당된 메모리 주소를 담고 있어서 메서드를 호출하면 메모리 주소를 통해 메서드를 호출하게 됩니다.
- 오버라이드가 가능합니다. 런타임 중 동적 바인딩을 통해 메서드의 타입이 결정됩니다.

### Metaspace는 어디에 존재하는가?

- Method Area는 클래스, 메서드, 필드 및 상수 풀과 같은 클래스 메타데이터를 저장합니다.
- 런타임 데이터 영역의 Method Area도 자바 8 이후 Metaspace 영역에 저장됩니다.
- `Metaspace`는 Heap 영역이 아닌 `Native Memeory` 영역에 저장됩니다.
- 자바 8 이전에는 Method Area가 PermGen 영역에 저장되었으나 PermGen 영역이 가득차면 "java.lang.OutOfMemoryError: PermGen
  space" 오류가 발생했습니다. 왜냐하면 PermGen 영역은 Heap 영역에 있었기 때문입니다.
- 그러나 Metaspace는 기본적으로 Native Memory 영역에 할당되며, PermGen 영역과 달리 동적으로 크기가 조정되기 때문에
  이러한 문제가 발생하지 않습니다.
- 즉, **Method Area는 Metaspace 영역에 저장되고 Metaspace 영역은 NativeMemory 영역에 저장됩니다.**

![](img/img_6.png)

## References

- [\[Java\] String, StringBuffer, StringBuilder 차이 및 장단점](https://dev-jwblog.tistory.com/108#3.%20StringBuffer%20/%20StringBuilder)
- [StringBuffer, StringBuilder 가 String 보다 성능이 좋은 이유와 원리](https://cjh5414.github.io/why-StringBuffer-and-StringBuilder-are-better-than-String/)
- [\[디자인 패턴\]Early return pattern이란?](https://woonys.tistory.com/m/entry/Design-PatternJavaEarly-return-pattern%EC%9D%B4%EB%9E%80)
- [\[Java\] Private 메소드를 테스트하는 방법과 이를 지양해야 하는 이유](https://mangkyu.tistory.com/235)

- [정적 메소드, 너 써도 될까?](https://tecoble.techcourse.co.kr/post/2020-07-16-static-method/)
- [\[Java\] 정적 메소드(static Method)는 언제 사용할까?](https://dev-coco.tistory.com/175)
- [Java, 인스턴스 메소드(instance methods)와 정적 메소드(static methods)의 차이](https://ykh6242.tistory.com/entry/Java-%EC%9D%B8%EC%8A%A4%ED%84%B4%EC%8A%A4-%EB%A9%94%EC%86%8C%EB%93%9Cinstance-methods%EC%99%80-%EC%A0%95%EC%A0%81-%EB%A9%94%EC%86%8C%EB%93%9Cstatic-methods%EC%9D%98-%EC%B0%A8%EC%9D%B4)
- [\[Java\] 자바 메타스페이스(Metaspace)에 대해 알아보자.](https://jaemunbro.medium.com/java-metaspace%EC%97%90-%EB%8C%80%ED%95%B4-%EC%95%8C%EC%95%84%EB%B3%B4%EC%9E%90-ac363816d35e#:~:text=%EC%9D%B4%20metadata%EB%8A%94%20heap%20%EC%99%B8%EB%B6%80,%EC%9D%B4%20%EA%B5%AC%EC%97%AD%EC%9D%B4%20Metaspace%EC%9D%B4%EB%8B%A4.)
- [JVM Runtime Data Area- Heap, Method Area](https://mia-dahae.tistory.com/101)
- [Java 런타임 데이터 영역](https://8iggy.tistory.com/229)
