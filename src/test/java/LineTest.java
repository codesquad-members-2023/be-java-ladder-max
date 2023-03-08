import kr.codesquad.domain.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LineTest {
   Line line;

    @BeforeEach
    void setUp() {
        line = new Line();
    }

    @Test
    void 그리기_가능_테스트() {
        assertThat(line.canDraw(0)).isTrue();
        line.addLine(true);
        assertThat(line.canDraw(1)).isFalse();
        line.addLine(false);
        assertThat(line.canDraw(2)).isTrue();
    }

}
