package ladder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import kr.ladder.domain.LadderLine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderLineTest {

    @Test
    @DisplayName("ladderLine 인스턴스 생성시 ladderLine이 잘 생성 되었는지 확인.")
    void testLadderLine() {
        // given
        LadderLine ladderLine = new LadderLine();

        //when
        int playerNumber = 100;
        ladderLine.make(playerNumber);
        int test = ladderLine.isFilled();

        // then
        assertEquals(test, playerNumber-1);
    }

    @Test
    @DisplayName("ladderLine 인스턴스 생성 시 ladderLine의 발판이 중복인지 확인.")
    void testAvailableFoothold(){
        // given
        LadderLine ladderLine = new LadderLine();

        //when
        int playerNumber = 100;
        ladderLine.make(playerNumber);
        boolean test = ladderLine.isDoubleFoothold();

        // then
        assertTrue(test);
    }

}
