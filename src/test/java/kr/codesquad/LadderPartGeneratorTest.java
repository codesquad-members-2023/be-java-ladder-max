package kr.codesquad;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LadderPartGeneratorTest {

    private int n;
    private int m;
    private Random random;
    private Ladder ladder;
    private LadderPartGenerator generator;

    @Test
    @DisplayName("사람 2명과 사다리 높이2가 주어질 때 랜덤한 사다리 생성하는지 테스트")
    public void generate_testcase1() {
        //given
        n = 2;
        m = 2;
        random = new Random();
        ladder = new Ladder(n, m);
        generator = new LadderPartGenerator(ladder, random);
        //mocking
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextBoolean()).thenReturn(true, false);
        setRandomBridge(generator, mockRandom);
        //when
        String[][] actual = generator.generate();
        //then
        String[][] expected =
            {{"|", "-", "|"},
                {"|", " ", "|"}};
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("사람 3명과 사다리 높이5가 주어질 때 랜덤한 사다리 생성하는지 테스트")
    public void generate_testcase2() {
        //given
        n = 3;
        m = 5;
        random = new Random();
        ladder = new Ladder(n, m);
        generator = new LadderPartGenerator(ladder, random);
        //mocking
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextBoolean()).thenReturn(true, false, false, true, true, true, false, true,
            true, false);
        setRandomBridge(generator, mockRandom);
        //when
        String[][] actual = generator.generate();
        //then
        String[][] expected =
            {{"|", "-", "|", " ", "|"},
                {"|", " ", "|", "-", "|"},
                {"|", "-", "|", "-", "|"},
                {"|", " ", "|", "-", "|"},
                {"|", "-", "|", " ", "|"}};
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    private void setRandomBridge(LadderPartGenerator generator, Random mockRandom) {
        try {
            Field field = generator.getClass().getDeclaredField("random");
            field.setAccessible(true);
            field.set(generator, mockRandom);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


}