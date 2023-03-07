import kr.codesquad.Line;
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
        String tLine = "-----", fLine = "     ";
        assertThat(line.canDraw(0)).isTrue();
        line.addLine(tLine);
        assertThat(line.canDraw(1)).isFalse();
        line.addLine(fLine);
        assertThat(line.canDraw(2)).isTrue();
    }

}
