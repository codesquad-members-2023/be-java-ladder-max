package kr.codesquad;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LadderTest {

    private Ladder ladder;

    @BeforeEach
    void setLadder() {
        ladder = new Ladder();
    }

    @Test
    void create() {
        boolean[][] booleans = ladder.create(3, 4, () -> false);
        boolean[][] result = {{false, false}, {false, false}, {false, false}, {false, false}};
        Assertions.assertThat(booleans).isEqualTo(result);

        booleans = ladder.create(5, 3, () -> true);
        result = new boolean[][]{{true, true, true, true}, {true, true, true, true}, {true, true, true, true}};
        Assertions.assertThat(booleans).isEqualTo(result);
    }

    @Test
    void drawLadder() {
        boolean[][] result = new boolean[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = true;
            }
        }
        String draw = ladder.draw(result);
        Assertions.assertThat(draw).isEqualTo(
            "|-|-|-|-|\n"
                + "|-|-|-|-|\n"
                + "|-|-|-|-|\n"
        );
    }
}
