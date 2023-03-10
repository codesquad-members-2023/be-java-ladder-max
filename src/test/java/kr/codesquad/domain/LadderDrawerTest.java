package kr.codesquad.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderDrawerTest {


    @DisplayName("사다리 그리기")
    @Test
    void draw() {
        LineInfo lineSuccessInfo = mock(LineInfo.class);
        when(lineSuccessInfo.connectLine()).thenReturn(LineInfo.SUCCESS_DELIMITER + LineInfo.PEOPLE_DELIMITER);
        LineInfo lineFailureInfo = mock(LineInfo.class);
        when(lineFailureInfo.connectLine()).thenReturn(LineInfo.FAIL_DELIMITER + LineInfo.PEOPLE_DELIMITER);
        LadderDrawer ladderDrawer = new LadderDrawer();
        assertThat(ladderDrawer.draw(List.of(lineSuccessInfo, lineFailureInfo)))
            .isEqualTo("   |-----|\n"
                + "   |     |\n");
    }
}
