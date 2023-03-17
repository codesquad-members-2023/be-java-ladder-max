import kr.codesquad.domain.Line;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


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
        String[] headCount = str.split("\\|");
        assertEquals(11, headCount.length*2-1);
    }
    @Test
    @DisplayName("좌표이동의 총합이 0인지 확인")
    void testMoveTotal(){
        Line line = new Line(7);
        int[] move = line.move();
        int total = 0;
        for (int i : move){
            total += i;
        }
        assertEquals(0,total);
    }
    @Test
    @DisplayName("좌표이동이 -1,0,1인지 확인")
    void testMovePoint(){
        Line line = new Line(7);
        int[] move = line.move();
        SoftAssertions softly = new SoftAssertions();
        for (int i : move){
            softly.assertThat(i).isBetween(-1,1);
        }
    }
}
