package ladder;

import kr.ladder.view.OutputView;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputTest {

    @Test
    @DisplayName("플레이어 이름 글자수에 따라 공백이 적절하게 들어가는지 확인.")
    void testPlayerName(){
        /*
            공백을 포함한 이름 글자 수는 6개이다. (사다리와 간격을 맞추기 위해)
             글자수가 홀수면 (ex) 이지안)
             1. 이름 앞에 들어가는 공백 수 = 이름 뒤에 들어가는 공백 수 - 1 (ex) 1)
             2. 이름 뒤에 들어가는 공백 수 = 이름 앞에 들어가는 공백 수 + 1 (ex) 2)
         */
        //given
        OutputView outputView = new OutputView();
        SoftAssertions softAssertions = new SoftAssertions();

        //when
        String playerName = "이지안";
        String playerNameWithBlanks = outputView.insertBlankAroundName(playerName);

        //then
        softAssertions.assertThat(playerNameWithBlanks).isEqualTo(" 이지안  ");
    }
}
