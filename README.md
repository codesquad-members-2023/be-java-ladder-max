# 목차

- [Java Ladder](#Java-Ladder)
- [학습목표](#학습목표)

# Java Ladder

- Last Update: 2022-3-6

## Todolist

- [ ] ConsoleInput 클래스의 사용자 입력 기능 리팩토링
- [ ] 이중 반복문을 일종 반복문으로 리팩토링

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

## 프로그래밍 요구사항

- 메서드 크기는 최대 10라인입니다.
- 메서드가 한 가지 일만 하도록 합니다.
- 2차원 배열을 활용합니다.

## 예상 결과 및 동작 예시

```
참여할 사람은 몇 명인가요?
3
최대 사다리 높이는 몇 개인가요?
5

|-| |
| |-|
|-|-|
| |-|
|-| |
```

```
참여할 사람은 몇 명인가요?
0
적절하지 않은 입력입니다. 1명 이상의 사람을 입력해주세요.

참여할 사람은 몇 명인가요?
3
최대 사다리 높이는 몇 개인가요?
abc
적절하지 않은 입력입니다. 1 이상의 사다리 높이를 입력해주세요.

최대 사다리 높이는 몇 개인가요?
5
|-| |
| |-|
|-|-|
| |-|
|-| |
```

## 빌드 및 실행

```shell
$ ./gradlew build
$ java -jar ./build/libs/java-lotto-1.0-SNAPSHOT.jar
```

# 학습목표

- [x] [String, StringBuilder, StringBuffer 비교](#String,-StringBuilder,-StringBuffer-비교)
- [x] [String과 new String() 차이](#String과-new-String()-차이)
- [ ] static 메서드와 객체 메서드의 비교
    - 어떤 경우에 static 메서드를 사용해야 하는가?
    - static 메서드 사용시 단점
    - static 메서드와 객체 메서드가 저장되는 위치
    - static 메서드와 객체 메서드의 성능(시간, 메모리공간)의 차이
- [ ] 콘솔 출력을 위해서 static 메서드 대신 더욱 효율적인 방법을 탐색해보기
- [ ] Early Return Pattern
- [ ] private 메서드 테스트 지양해야 하는 이유 학습
- [ ] 클린 코딩 기초 학습

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

## Early Return Pattern

### Early Return Pattern 필요성

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

### Early Return Pattern 개념

- Early Return은 함수 혹은 메서드를 작성하는 방법으로, Early Return을 사용하여
  예상하는 결과가 함수의 끝에서 리턴하도록 하는 패턴입니다.
- 조건이 충족되지 않았을때 코드의 나머지 부분이 실행문을 종료(예외처리를 리턴함으로써)시킵니다.

다음 코드는 위 anti-pattern을 가지고 있는 예제를 Early Return 패턴으로 적용한 예제입니다.

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

## References

- [\[Java\] String, StringBuffer, StringBuilder 차이 및 장단점](https://dev-jwblog.tistory.com/108#3.%20StringBuffer%20/%20StringBuilder)
- [StringBuffer, StringBuilder 가 String 보다 성능이 좋은 이유와 원리](https://cjh5414.github.io/why-StringBuffer-and-StringBuilder-are-better-than-String/)

- [\[Java\] Private 메소드를 테스트하는 방법과 이를 지양해야 하는 이유](https://mangkyu.tistory.com/235)
- [정적 메소드, 너 써도 될까?](https://tecoble.techcourse.co.kr/post/2020-07-16-static-method/)