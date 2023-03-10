package kr.codesquad.domain;

import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LinesInfoTest {

    @Test
    @DisplayName("LineInfo 를 추가하고 저장한다.")
    void add() {
        LinesInfo linesInfo = new LinesInfo();
        LineInfo lineInfo = new LineInfo(new ArrayList<>());
        Assertions.assertThat(linesInfo.size()).isEqualTo(0);
        linesInfo.add(lineInfo);
        Assertions.assertThat(linesInfo.size()).isEqualTo(1);
    }

    @Test
    void create() {
    }

    @Test
    void draw() {
    }

    @Test
    void calculatorAndSaveResult() {
    }
}
