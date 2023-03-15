package kr.codesquad.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import kr.codesquad.domain.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    private Player player;
    private final String SYLLABLE = "s";
    private final int MAX_NAME_LENGTH = 5;

    @Test
    @DisplayName("플레이어에 입력된 이름이 5글자보다 크면 예외 발생.")
    void testGetNameThrowException() {
        assertThatThrownBy(() -> new Player(SYLLABLE.repeat(MAX_NAME_LENGTH + 1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("플레이어에 이름을 입력하면 5글자로 출력한다.")
    void testGetNameLength() {
        for(int i = 1; i <= MAX_NAME_LENGTH; i++) {
            player = new Player(SYLLABLE.repeat(i));
            assertThat(player.getCenterAlignedName().length()).isEqualTo(MAX_NAME_LENGTH);
        }
    }

}
