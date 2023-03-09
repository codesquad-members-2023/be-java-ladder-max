package kr.codesquad.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserTest {


    @DisplayName("참여할 유저 이름이 1글자 미만일 경우 생성되지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void validateMinLength(String name) {
        // given

        // when

        // then
        IllegalArgumentException exception = Assertions.assertThrowsExactly(
            IllegalArgumentException.class, () -> new User(name));
        Assertions.assertEquals("참여할 사람의 이름은 최소 1글자입니다.", exception.getMessage());
    }

    @DisplayName("참여할 유저 이름이 5글자 초과할 경우 생성되지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"123456", "code squad"})
    void validateMaxLength(String name) {
        // given

        // when

        // then
        IllegalArgumentException exception = Assertions.assertThrowsExactly(
            IllegalArgumentException.class, () -> new User(name));
        Assertions.assertEquals("참여할 사람의 이름은 최대 5글자입니다.", exception.getMessage());
    }

    @DisplayName("참여할 유저 이름은 1글자 이상 5글자 이하여야 생성된다")
    @ParameterizedTest
    @ValueSource(strings = {"man du", "h o", "o", "JK", "honux"})
    void generate(String name) {
        // given

        // when

        // then
        Assertions.assertDoesNotThrow(() -> new User(name));
    }
}
