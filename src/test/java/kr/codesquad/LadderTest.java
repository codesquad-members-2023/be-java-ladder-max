package kr.codesquad;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LadderTest {
    @Test
    @DisplayName("사람 2명과 사다리 높이2가 주어질 때 랜덤한 사다리 생성하는지 테스트")
    public void generate_testcase1(){
        //given
        int n = 2;
        int m = 2;
        Ladder ladder = new Ladder(n, m);
        //mocking
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextBoolean()).thenReturn(true, false);
        setRandomCreateLine(ladder, mockRandom);
        //when
        String[][] actual = ladder.generate();
        //then
        String[][] expected = {{"|","-","|"},
                               {"|"," ","|"}};
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("사람 3명과 사다리 높이5가 주어질 때 랜덤한 사다리 생성하는지 테스트")
    public void generate_testcase2(){
        //given
        int n = 3;
        int m = 5;
        Ladder ladder = new Ladder(n, m);
        //mocking
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextBoolean()).thenReturn(true, false, false, true, true, true, false, true, true, false);
        setRandomCreateLine(ladder, mockRandom);
        //when
        String[][] actual = ladder.generate();
        //then
        String[][] expected = {{"|","-","|"," ","|"},
                               {"|"," ","|","-","|"},
                               {"|","-","|","-","|"},
                               {"|"," ","|","-","|"},
                               {"|","-","|"," ","|"}};
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    private void setRandomCreateLine(Ladder ladder, Random mockRandom){
        try {
            Field field = Ladder.class.getDeclaredField("randomCreateLine");
            field.setAccessible(true);
            field.set(ladder, mockRandom);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


}