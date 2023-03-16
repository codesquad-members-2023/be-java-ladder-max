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
        String playerName = "하이이이이이";
        int blankRepeatNumber = outputView.insertBlank(playerName.length()).length();

        System.out.println(blankRepeatNumber);
        //then
        // 🤔넣는 공백이 0은 아니어야 하는데(=이름이 6글자라는 소리) 왜 테스트에 안걸릴까?
        softAssertions.assertThat(blankRepeatNumber).isPositive().isGreaterThan(1).isLessThan(5).isNotEqualTo(0);
    }

}
