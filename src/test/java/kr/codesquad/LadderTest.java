package kr.codesquad;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderTest {

    @ParameterizedTest
    @CsvSource({"3,3,ture", "4,5,false"})
    void create(int peopleCount, int ladderHeight, boolean flag) {
        Ladder ladder = new Ladder();
        boolean[][] booleans = ladder.create(peopleCount, ladderHeight, () -> flag);
        boolean[][] result = new boolean[peopleCount - 1][ladderHeight];
        for (int i = 0; i < peopleCount - 1; i++) {
            for (int j = 0; j < ladderHeight; j++) {
                result[i][j] = flag;
            }
        }
        Assertions.assertThat(booleans).isEqualTo(result);
    }
}
