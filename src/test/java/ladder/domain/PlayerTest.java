package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {
    @Test
    @DisplayName("최대 길이보다 긴 이름을 입력 받은 경우 오류를 발생하는지 검증하는 테스트")
    void checkNameLength() {
        // given
        String name = "snoopy";

        // when
        // then
        assertThatThrownBy(() -> new Player(name)).isInstanceOf(IllegalArgumentException.class).hasMessage("이름의 길이는 최대 5글자입니다.");
    }
}
