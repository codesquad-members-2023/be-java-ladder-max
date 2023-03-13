package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    @DisplayName("같은 높이에 연속된 발판을 생성하지 않음을 검증하는 테스트")
    void checkContinuousRungs() {
        // given
        int width = 6;

        // when
        Line line = new Line(width);

        // then
        for (int i = 0; i < width - 1; i++) {
            if (line.isRungExist(i)) {
                assertThat(line.isRungExist(i)).isTrue().isNotEqualTo(line.isRungExist(i + 1));
            }
        }
    }
}
