package kr.codesquad.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderByPeopleCountTest {

    private LadderByPeopleCount ladderByPeopleCount;

    @BeforeEach
    void setLadder() {
        ladderByPeopleCount = new LadderByPeopleCount();
    }


    @DisplayName("draw")
    @Test
    void drawLadder() {
        boolean[][] result = new boolean[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = true;
            }
        }
        String draw = ladderByPeopleCount.connectLines(result);
        Assertions.assertThat(draw).isEqualTo(
            "|-|-|-|-|\n"
                + "|-|-|-|-|\n"
                + "|-|-|-|-|\n"
        );
    }
}
