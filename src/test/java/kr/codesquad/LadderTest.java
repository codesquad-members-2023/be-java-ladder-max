package kr.codesquad;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderTest {

    private Ladder ladder;

    @BeforeEach
    void setLadder() {
        ladder = new Ladder();
    }

    @ParameterizedTest
    @CsvSource({"3,3,ture", "4,5,false"})
    void create(int peopleCount, int ladderHeight, boolean flag) {
        boolean[][] booleans = ladder.create(peopleCount, ladderHeight, () -> flag);
        boolean[][] result = new boolean[peopleCount - 1][ladderHeight];
        for (int i = 0; i < peopleCount - 1; i++) {
            for (int j = 0; j < ladderHeight; j++) {
                result[i][j] = flag;
            }
        }
        Assertions.assertThat(booleans).isEqualTo(result);
    }

    @Test
    void drawLadder() {
        boolean[][] result = new boolean[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = true;
            }
        }
        String draw = ladder.draw(result);
        Assertions.assertThat(draw).isEqualTo(
            "|-|-|-|\n|-|-|-|\n|-|-|-|\n"
        );
    }
}
