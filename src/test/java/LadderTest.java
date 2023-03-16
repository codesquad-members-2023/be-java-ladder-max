import kr.codesquad.domain.Ladder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.SoftAssertions;

class LadderTest {

    @Test
    @DisplayName("사다리의 행이 맞게 출력되는지 확인")
    void testRow() {
        int row = 5;
        int column = 3;
        Ladder ladder = new Ladder(row, column);
        String result = ladder.make();

        String[] lines = result.split("\n");
        Assertions.assertEquals(row, lines.length);
    }
    @Test
    @DisplayName("사다리의 열이 맞게 출력되는지 확인")
    void testColumn() {
        int row = 5;
        int headCount = 3;
        Ladder ladder = new Ladder(row, headCount);
        String result = ladder.make();

        String[] lines = result.split("\n");
        for (String line : lines) {
            String[] columns = line.split("\\|");
            Assertions.assertEquals(headCount, columns.length);
        }
    }
    @Test
    @DisplayName("사다리 가로줄이 연속으로 나오는지 확인")
    void testMakeLadder() {
        Ladder ladder = new Ladder(5,4);
        String result = ladder.make();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(result).doesNotContain("-----|-----");
        softly.assertAll();
    }
    @Test
    @DisplayName("결과 int[]의 인덱스 검사")
    void testCalculateResult(){
        Ladder ladder = new Ladder(5,4);
        ladder.make();
        int[] ans = ladder.calculateResult();

        SoftAssertions softly = new SoftAssertions();
        int[] test = {4};
        softly.assertThat(ans).doesNotContain(4);
        softly.assertThat(ans).doesNotContain(5);
        softly.assertThat(ans).doesNotContain(6);
        softly.assertThat(ans).doesNotContain(7);
        softly.assertThat(ans.length).isEqualTo(7);
        softly.assertAll();
    }
}

