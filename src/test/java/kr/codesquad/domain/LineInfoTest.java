package kr.codesquad.domain;

import static kr.codesquad.domain.LineDelimiterType.FAIL_DELIMITER;
import static kr.codesquad.domain.LineDelimiterType.PEOPLE_DELIMITER;
import static kr.codesquad.domain.LineDelimiterType.SUCCESS_DELIMITER;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LineInfoTest {

    @DisplayName("라인이 존재하면 이동한다.")
    @Test
    void move() {
        List<Boolean> testList = List.of(false, true, false);
        LineInfo lineInfo = new LineInfo(testList);

        Assertions.assertThat(lineInfo.move(1)).isEqualTo(2);
        Assertions.assertThat(lineInfo.move(2)).isEqualTo(1);
        Assertions.assertThat(lineInfo.move(0)).isEqualTo(0);
        Assertions.assertThat(lineInfo.move(3)).isEqualTo(3);
    }

    @DisplayName("LineInfo의 사이즈 확인.")
    @Test
    void size() {
        List<Boolean> testList = List.of(false, true, false);
        LineInfo lineInfo = new LineInfo(testList);

        Assertions.assertThat(lineInfo.size()).isEqualTo(3);
    }


    @DisplayName("입력한 size-1의 LineInfo 객체 생성")
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 10})
    void createRandomLineStateInfo(int size) {
        Assertions.assertThat(LineInfo.createRandomLineInfo(size).size()).isEqualTo(size);
    }

    @DisplayName("라인을 연결하여 대응한 String으로 return")
    @Test
    void drawLine() {
        List<Boolean> testList = List.of(false, true, false);
        LineInfo lineInfo = new LineInfo(testList);
        Assertions.assertThat(lineInfo.drawLine())
                .isEqualTo(LineInfo.PREFIX
                        + PEOPLE_DELIMITER.getValue()
                        + FAIL_DELIMITER.getValue()
                        + PEOPLE_DELIMITER.getValue()
                        + SUCCESS_DELIMITER.getValue()
                        + PEOPLE_DELIMITER.getValue()
                        + FAIL_DELIMITER.getValue()
                        + PEOPLE_DELIMITER.getValue()
                        + LineInfo.NEXT_LINE);
    }
}
