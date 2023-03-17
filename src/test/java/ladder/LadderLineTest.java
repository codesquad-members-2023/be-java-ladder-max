package ladder;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.assertj.core.api.SoftAssertions;

import kr.ladder.domain.LadderLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderLineTest {

    @Test
    @DisplayName("ladderLine 인스턴스 생성시 ladderLine이 잘 생성 되었는지 확인.")
    void testLadderLine() {
        // given
        LadderLine ladderLine = new LadderLine();
        SoftAssertions softAssertions = new SoftAssertions();

        //when
        int playerNumber = 100;
        ladderLine.make(playerNumber);

        // then
        // 🤔test code 안에 for문 넣어도 되는걸까?
        for (int i = 0; i < ladderLine.size(); i++) {
            softAssertions.assertThat(ladderLine.get(i)).isNotNull().asInstanceOf(InstanceOfAssertFactories.BOOLEAN);
        }
    }

}
