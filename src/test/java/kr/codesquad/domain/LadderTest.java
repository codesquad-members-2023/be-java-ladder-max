package kr.codesquad.domain;

import java.util.List;
import kr.codesquad.exception.ladder.LadderMinHeightException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderTest {

    @DisplayName("가로라인들을 가진 리스트 사이즈가 2미만 일 경우 생성되지 않는다.")
    @Test
    void validateMinSize() {
        // given
        List<RowLines> rowLisnesList = List.of(new RowLines(List.of(true, false)));

        // when

        // then
        Assertions.assertThrows(LadderMinHeightException.class
            , () -> new Ladder(rowLisnesList));
    }

    @DisplayName("가로라인들을 가진 리스트 사이즈가 2이상 일 경우 생성된다.")
    @Test
    void create() {
        // given
        List<RowLines> rowLisnesList = List.of(new RowLines(List.of(true, false, true))
            , new RowLines(List.of(false, false, true)));

        // when

        // then
        Assertions.assertDoesNotThrow(() -> new Ladder(rowLisnesList));
    }

    @ParameterizedTest
    @CsvSource({"0,2", "1,0", "2,3", "3,1"})
    void calculateResultIndex(int columnLineIndex, int expected) {
        // |-| |-|
        // | |-| |
        // given
        List<RowLines> rowLisnesList = List.of(new RowLines(List.of(true, false, true))
            , new RowLines(List.of(false, true, false)));
        Ladder ladder = new Ladder(rowLisnesList);

        // when
        int actual = ladder.calculateResultIndex(columnLineIndex);

        // then
        Assertions.assertEquals(expected, actual);
    }
}
