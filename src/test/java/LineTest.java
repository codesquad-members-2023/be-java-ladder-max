import kr.codesquad.domain.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;

public class LineTest {
   private Line line;
   private Method addMethod;

    @BeforeEach
    void setUp() throws NoSuchMethodException {
        this.line = new Line();
        this.addMethod = Line.class.getDeclaredMethod("addLine", boolean.class);
        this.addMethod.setAccessible(true);
    }

    @Test
    @DisplayName("그리기 가능 여부 테스트")
    void canDraw_test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method booleanMethod = Line.class.getDeclaredMethod("canDraw", int.class);
        booleanMethod.setAccessible(true);

        assertThat((boolean)booleanMethod.invoke(line, 0)).isTrue();
        addMethod.invoke(line, true);
        assertThat((boolean)booleanMethod.invoke(line, 1)).isFalse();
        addMethod.invoke(line, false);
        assertThat((boolean)booleanMethod.invoke(line, 2)).isTrue();
    }

    @Test
    @DisplayName("사다리 타기 테스트")
    void goLine_test() throws InvocationTargetException, IllegalAccessException {
        addMethod.invoke(line, false);
        addMethod.invoke(line, true);
        assertThat(line.goLine(0)).isEqualTo(0);
        assertThat(line.goLine(1)).isEqualTo(2);
        assertThat(line.goLine(2)).isEqualTo(1);
    }
}
