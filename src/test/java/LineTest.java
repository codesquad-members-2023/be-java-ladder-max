import kr.codesquad.domain.Line;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {
    @Test
    @DisplayName("사다리에 가로줄이 연속으로 나오지 않는지 검사")
    void testMakeLine() {
        Line line = new Line(11);
        String str = line.toString();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(str).doesNotContain("-----|-----");
        softly.assertAll();
    }
    @Test
    @DisplayName("Line의 열이 맞게 출력되는지 확인")
    void testColumn() {
        Line line = new Line(11);
        String str = line.toString();
        String[] columns = str.split("\\|");
        Assertions.assertEquals(11, columns.length*2-1);
    }
}
