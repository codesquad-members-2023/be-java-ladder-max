package ladder;

import kr.ladder.view.OutputView;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    @DisplayName("플레이어 이름을 출력할 때 5글자를 정확히 출력하는지 확인")
    void testPlayerName(){
        //given
        OutputView outputView = new OutputView();
        SoftAssertions softAssertions = new SoftAssertions();

        //when
        String playerName = "하이";
        int blankRepeatNumber = outputView.insertBlank(playerName.length()).length();

        //then
        softAssertions.assertThat(blankRepeatNumber).isPositive().isGreaterThan(1).isLessThan(5)
                .isEqualTo(6 - playerName.length());
    }

}
