package ladder.domain;

import ladder.random.RandomManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    @DisplayName("같은 높이에 연속된 발판을 생성하지 않음을 검증하는 테스트")
    void checkContinuousRungs() {
        // given
        int width = 5;

        // when
        Line line = new Line(width, new RandomManager() {
            @Override
            public List<Boolean> makeBooleansRandomly(int size) {
                List<Boolean> booleans = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    booleans.add(true);
                }
                return booleans;
            }
        });

        // then
        assertThat(line.drawLine()).isEqualTo("|-----|     |-----|     |-----|");
    }
}
