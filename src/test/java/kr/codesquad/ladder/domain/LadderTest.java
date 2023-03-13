package kr.codesquad.ladder.domain;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Random;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("랜덤한 사다리가 주어졌을때 사다리 타기가 되는지 테스트")
    public void climb_testcase1() {
        //given
        LadderGenerator generator = new LadderGenerator(2, 1);
        //mocking
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextBoolean()).thenReturn(true, false);
        Ladder ladder = generator.createLines(2, mockRandom);
        //when
        int actual = ladder.climb(0);
        //then
        Assertions.assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("4명과 사다리 높이 5가 주어졌을때 사다리 타기가 되는지 테스트")
    public void climb_testcase2() {
        //given
        LadderGenerator generator = new LadderGenerator(5, 1);
        //mocking
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextBoolean()).thenReturn(
            true, false, true,
            false, true, false,
            true, false, false,
            false, true, false,
            true, false, true
        );
        Ladder ladder = generator.createLines(4, mockRandom);
        //when
        int actual1 = ladder.climb(0);
        int actual2 = ladder.climb(2);
        int actual3 = ladder.climb(4);
        int actual4 = ladder.climb(6);
        //then
        Assertions.assertThat(actual1).isEqualTo(0);
        Assertions.assertThat(actual2).isEqualTo(6);
        Assertions.assertThat(actual3).isEqualTo(4);
        Assertions.assertThat(actual4).isEqualTo(2);
    }

}
