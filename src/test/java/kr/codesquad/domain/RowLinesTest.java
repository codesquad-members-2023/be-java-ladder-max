package kr.codesquad.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RowLinesTest {

    @DisplayName("가로 사다리 라인이 곁치면 생성되지 않는다.")
    @ParameterizedTest
    @CsvSource({"true,true,ture", "true,true,false", "false,true,true"})
    void validateDuplicationLine(Boolean line1, Boolean line2, Boolean line3) {
        // given
        List<Boolean> rowLines = List.of(line1, line2, line3);

        // when

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new RowLines(rowLines));
    }

    @DisplayName("가로 사다리 라인이 2개 미만일 경우 생성되지 않는다.")
    @Test
    void validateMinSize() {
        // given
        List<Boolean> rowLines1 = List.of(true);
        List<Boolean> rowLines2 = List.of(false);
        List<Boolean> rowLines3 = Collections.emptyList();

        // when

        // then
        Assertions.assertAll(
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> new RowLines(rowLines1)),
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> new RowLines(rowLines2)),
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> new RowLines(rowLines3)));
    }
    
    @ParameterizedTest
    @CsvSource({"true,false,ture", "false,true,false", "false,true,false"})
    void create(Boolean line1, Boolean line2, Boolean line3) {
        // given
        List<Boolean> rowLines = List.of(line1, line2, line3);

        // when

        // then
        Assertions.assertDoesNotThrow(() -> new RowLines(rowLines));
    }

    @ParameterizedTest
    @CsvSource({"false,true,false,0,1,2", "true,false,true,0,1,2"})
    void findByIndex(Boolean line1, Boolean line2, Boolean line3, int index1, int index2, int index3) {
        // given
        RowLines rowLines = new RowLines(List.of(line1, line2, line3));

        // when
        boolean actual1 = rowLines.findByIndex(index1);
        boolean actual2 = rowLines.findByIndex(index2);
        boolean actual3 = rowLines.findByIndex(index3);

        // then
        Assertions.assertAll(
            () -> Assertions.assertEquals(line1, actual1),
            () -> Assertions.assertEquals(line2, actual2),
            () -> Assertions.assertEquals(line3, actual3));
    }

    @ParameterizedTest
    @CsvSource({"true,0", "false,1", "true,2", "false,3"})
    void isConnectLine(boolean expected, int index) {
        // given
        RowLines rowLines = new RowLines(List.of(false, false, true, false));

        // when
        boolean actual = rowLines.isConnectLine(index);

        // then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void connect() {
        // given
        RowLines rowLines = new RowLines(Arrays.asList(true, false));

        // when
        rowLines.connect(0);
        rowLines.connect(1);

        // then
        boolean actual1 = rowLines.findByIndex(0);
        boolean actual2 = rowLines.findByIndex(1);
        Assertions.assertAll(
            () -> Assertions.assertTrue(actual1),
            () -> Assertions.assertTrue(actual2));
    }
}
