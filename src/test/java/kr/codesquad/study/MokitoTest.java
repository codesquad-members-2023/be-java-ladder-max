package kr.codesquad.study;

import java.util.Random;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MokitoTest {

    @Test
    @DisplayName("Person 객체 생성시 목 객체를 주입하여 랜덤 객체가 통제되는지 테스트")
    public void sayYesOrNo() {
        //given
        Random mockRandom = Mockito.mock(Random.class);
        Mockito.when(mockRandom.nextBoolean()).thenReturn(true, false);
        Person person = new Person(mockRandom);
        //when
        boolean actual1 = person.sayYesOrNo();
        boolean actual2 = person.sayYesOrNo();
        //then
        Assertions.assertThat(actual1).isTrue();
        Assertions.assertThat(actual2).isFalse();
    }
}

class Person {

    private Random random;

    public Person(Random random) {
        this.random = random;
    }

    public boolean sayYesOrNo() {
        return random.nextBoolean();
    }
}
