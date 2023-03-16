package kr.codesquad;

import kr.codesquad.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LineTest {
    @Test
    @DisplayName("Line의 모양이 변환되는지 확인")
    void drawLineTest() {
        Line line = new Line(List.of(true, false, false, true, false));
        String figure = line.drawLine();
        assertThat(figure).isEqualTo("|=====|     |     |=====|     |");
    }
}