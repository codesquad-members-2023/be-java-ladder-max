package kr.codesquad.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UsersTest {

    @DisplayName("참여할 사람이 2명 미만일 경우 생성되지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"honux", "crong,", "jk, ", "", " ", " , "})
    void validateMinUserNamesCount(String userNames) {
        // given

        // when

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Users(userNames));
    }

    @DisplayName("참여할 사람이 2명 이일 경우 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"honux, crong", "crong, jk", " jk , honux "})
    void generate(String userNames) {
        // given

        // when

        // then
        Assertions.assertDoesNotThrow(() -> new Users(userNames));
    }
}
