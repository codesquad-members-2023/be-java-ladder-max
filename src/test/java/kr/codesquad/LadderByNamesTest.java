package kr.codesquad;

import static kr.codesquad.LadderByNames.FAIL_DELIMITER;
import static kr.codesquad.LadderByNames.SUCCESS_DELIMITER;
import static kr.codesquad.LadderByNames.addLadder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderByNamesTest {

    @Test
    void create() {
        LadderByNames ladder = new LadderByNames();

        String result = ladder.create(4, 5, () -> true);
        Assertions.assertThat(result).isEqualTo(
            "|-----|     |-----|\n"
                + "|-----|     |-----|\n"
                + "|-----|     |-----|\n"
                + "|-----|     |-----|\n"
                + "|-----|     |-----|\n"
        );
    }

    @Test
    void addLadder_True() {
        StringBuilder target = new StringBuilder();
        addLadder(target, true, true);
        Assertions.assertThat(target).contains(SUCCESS_DELIMITER);
    }

    @ParameterizedTest
    @CsvSource({"false,true", "false,false", "true,false"})
    void addLadder_False(boolean beforeIsTrue, boolean currentIsPossible) {
        StringBuilder target = new StringBuilder();
        addLadder(target, beforeIsTrue, currentIsPossible);
        Assertions.assertThat(target).contains(FAIL_DELIMITER);
    }
}
