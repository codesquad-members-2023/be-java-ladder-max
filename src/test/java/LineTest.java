import kr.codesquad.domain.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;

public class LineTest {
   Line line;

    @BeforeEach
    void setUp() {
        line = new Line();
    }

    @Test
    void 그리기_가능_테스트() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method booleanMethod = Line.class.getDeclaredMethod("canDraw", int.class);
        booleanMethod.setAccessible(true);

        assertThat((boolean)booleanMethod.invoke(line, 0)).isTrue();
        line.addLine(true);
        assertThat((boolean)booleanMethod.invoke(line, 1)).isFalse();
        line.addLine(false);
        assertThat((boolean)booleanMethod.invoke(line, 2)).isTrue();
    }

}
