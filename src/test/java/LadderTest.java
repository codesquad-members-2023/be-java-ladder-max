import kr.codesquad.Ladder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {
   Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = new Ladder(new ArrayList<>(), 0);
    }

    @Test
    void 그리기_테스트() {
        List<String> board = new ArrayList<>();
        String tLine = "-----", fLine = "     ";
        ladder.drawLine(true, 0, board);
        assertThat(board.get(0)).isEqualTo(tLine);
        ladder.drawLine(true, 1, board);
        assertThat(board.get(1)).isEqualTo(fLine);
        ladder.drawLine(true, 2, board);
        assertThat(board.get(2)).isEqualTo(tLine);
        ladder.drawLine(false, 3, board);
        assertThat(board.get(3)).isEqualTo(fLine);
    }

}
