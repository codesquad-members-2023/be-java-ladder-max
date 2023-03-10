package kr.codesquad.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
