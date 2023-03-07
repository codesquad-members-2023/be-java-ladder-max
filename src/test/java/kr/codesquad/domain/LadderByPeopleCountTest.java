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

    @DisplayName("사람 몇명 입력시 2차원 배열 생성")
    @Test
    void create() {
        boolean[][] booleans = ladderByPeopleCount.create(3, 4, () -> false);
        boolean[][] result = {{false, false}, {false, false}, {false, false}, {false, false}};
        Assertions.assertThat(booleans).isEqualTo(result);

        booleans = ladderByPeopleCount.create(5, 3, () -> true);
        result = new boolean[][]{{true, true, true, true}, {true, true, true, true}, {true, true, true, true}};
        Assertions.assertThat(booleans).isEqualTo(result);
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
        String draw = ladderByPeopleCount.draw(result);
        Assertions.assertThat(draw).isEqualTo(
            "|-|-|-|-|\n"
                + "|-|-|-|-|\n"
                + "|-|-|-|-|\n"
        );
    }
}
