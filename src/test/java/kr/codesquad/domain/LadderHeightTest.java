package kr.codesquad.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderHeightTest {

    @DisplayName("사다리 높이가 1 이하 일 경우 생성되지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void validateMinHeight(int height) {
        // given

        // when

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new LadderHeight(height));
    }

    @DisplayName("사다리 높이가 2 이상 일 경우 높이를 가져온다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5})
    void getHeight(int height) {
        // given
        LadderHeight ladderHeight = new LadderHeight(height);

        // when
        int actual = ladderHeight.getHeight();

        // then
        Assertions.assertEquals(height, actual);
    }
}
