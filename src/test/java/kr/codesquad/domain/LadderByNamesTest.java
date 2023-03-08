package kr.codesquad.domain;

import static kr.codesquad.domain.LadderByNames.FAIL_DELIMITER;
import static kr.codesquad.domain.LadderByNames.connectLine;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderByNamesTest {

    @DisplayName("사다리 추가의 실패")
    @ParameterizedTest
    @CsvSource({"false,true", "false,false", "true,false"})
    void addLadder_False(boolean beforeIsTrue, boolean currentIsPossible) {
        StringBuilder target = new StringBuilder();
        connectLine(target, beforeIsTrue);
        Assertions.assertThat(target).contains(FAIL_DELIMITER);
    }
}
