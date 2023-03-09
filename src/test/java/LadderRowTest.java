import kr.codesquad.domain.LadderRow;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderRowTest {
    @DisplayName("사다리 한 로우가 선을 가지고 있는지 확인")
    @Test
    public void isRadderRowHasLine() {
        LadderRow ladderRow = new LadderRow(3);

        assertThat(ladderRow.isRowHasLine()).isTrue();
    }

}
