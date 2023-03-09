package kr.codesquad.domain;

import static org.assertj.core.api.Assertions.catchException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import kr.codesquad.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @Test
    @DisplayName("플레이어 이름 미입력 시 예외 발생")
    void emptyPlayerNameTest() {
        Exception e = catchException(() -> new Players(List.of(new Player(""))));
        assertThat(e).isInstanceOf(IllegalArgumentException.class);
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.INPUT_IS_EMPTY_ERROR.toString());
    }

    @Test
    @DisplayName("플레이어 이름을 6자 이상 입력 시 예외 발생")
    void playerNameLengthTest() {
        Exception e = catchException(() -> new Players(List.of(new Player("이름이6글자"))));
        assertThat(e).isInstanceOf(IllegalArgumentException.class);
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.INVALID_NAME_LENGTH.toString());
    }

    @Test
    @DisplayName("플레이어 이름이 중복되었을 때 예외가 발생한다.")
    void duplicatedNameTest() {
        Exception e = catchException(() -> new Players(List.of(
                new Player("same"),
                new Player("same")
        )));
        assertThat(e).isInstanceOf(IllegalArgumentException.class);
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.DUPLICATED_PLAYER_NAME.toString());
    }
}
