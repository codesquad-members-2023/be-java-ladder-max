import kr.codesquad.domain.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;

public class LineTest {
   private Line line;

    @BeforeEach
    void setUp() {
        line = new Line();
    }

    @Test
    @DisplayName("그리기 가능 여부 테스트")
    void canDraw_test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method booleanMethod = Line.class.getDeclaredMethod("canDraw", int.class);
        booleanMethod.setAccessible(true);

        assertThat((boolean)booleanMethod.invoke(line, 0)).isTrue();
        line.addLine(true);
        assertThat((boolean)booleanMethod.invoke(line, 1)).isFalse();
        line.addLine(false);
        assertThat((boolean)booleanMethod.invoke(line, 2)).isTrue();
    }

}
