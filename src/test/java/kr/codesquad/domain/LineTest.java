package kr.codesquad.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    @DisplayName("선 출력 실패 테스트")
    void printLineFailTest() {
        Line line = new Line(2);

        String str = line.toString();

        assertThat(str).isNotEqualTo("|");
    }

    @Test
    @DisplayName("선 출력 성공 테스트")
    void printLineSuccessTest() {
        Line line = new Line(1);

        String str = line.toString();

        assertThat(str).isEqualTo("|");
    }
}
