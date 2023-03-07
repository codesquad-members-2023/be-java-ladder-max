package kr.codesquad.domain;

import static kr.codesquad.domain.LadderByNames.FAIL_DELIMITER;
import static kr.codesquad.domain.LadderByNames.SUCCESS_DELIMITER;
import static kr.codesquad.domain.LadderByNames.addLadder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderByNamesTest {

    @DisplayName("이름으로 입력시 사다리 생성")
    @Test
    void create() {
        LadderByNames ladder = new LadderByNames();

        String result = ladder.create(4, 5, () -> true);
        Assertions.assertThat(result).isEqualTo(
            "   |-----|     |-----|\n"
                + "   |-----|     |-----|\n"
                + "   |-----|     |-----|\n"
                + "   |-----|     |-----|\n"
                + "   |-----|     |-----|\n"
        );
    }

    @DisplayName("사다리 추가의 성공")
    @Test
    void addLadder_True() {
        StringBuilder target = new StringBuilder();
        addLadder(target, true, true);
        Assertions.assertThat(target).contains(SUCCESS_DELIMITER);
    }

    @DisplayName("사다리 추가의 실패")
    @ParameterizedTest
    @CsvSource({"false,true", "false,false", "true,false"})
    void addLadder_False(boolean beforeIsTrue, boolean currentIsPossible) {
        StringBuilder target = new StringBuilder();
        addLadder(target, beforeIsTrue, currentIsPossible);
        Assertions.assertThat(target).contains(FAIL_DELIMITER);
    }
}
