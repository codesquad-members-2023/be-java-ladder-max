package kr.codesquad.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayersTest {

    @Test
    @DisplayName("플레이어들의 이름 출력시 5글자씩 가운데 정렬하여 출력되는지 테스트")
    void testToString() {
        // 준비(Arrange)
        int maxNameLength = 5;
        String[] names = {"a", "ab", "abc", "abcd", "abcde"};
        String[] frontPadding = {"  ", "  ", " ", " ", ""};
        String[] backPadding = {"  ", " ", " ", "", ""};
        String[] expected = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            expected[i] = frontPadding[i] + names[i] + backPadding[i];
        }
        PlayerGroup playerGroup = new PlayerGroup(names);

        // 실행(Act)
        String result = playerGroup.toString();

        // 단언(Assert)
        int pointer = 0;
        for (int i = 0; i < names.length; i++) {
            assertThat(result.substring(pointer, pointer + maxNameLength))
                    .isEqualTo(expected[i]);
            pointer += 1 + maxNameLength;
        }

    }


}
