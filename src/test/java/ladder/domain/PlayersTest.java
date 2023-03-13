package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {
    @Test
    @DisplayName("참가자의 수가 2명 미만일 경우 오류를 발생하는지 검증하는 테스트")
    void checkMinPlayer() {
        // given
        String[] names = {"alone"};

        // when
        // then
        assertThatThrownBy(() -> new Players(names)).isInstanceOf(IllegalArgumentException.class).hasMessage("2명 이상 참여해야 시작할 수 있습니다.");
    }
}
