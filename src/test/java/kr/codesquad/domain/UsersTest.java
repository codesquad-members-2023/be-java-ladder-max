package kr.codesquad.domain;

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
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> new Users(userNames));
        Assertions.assertEquals("참여할 사람의 수는 최소 2명입니다.", exception.getMessage());
    }

    @DisplayName("참여할 사람이 2명 이상일 경우 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"honux, crong", "crong, jk", " jk , honux "})
    void generate(String userNames) {
        // given

        // when

        // then
        Assertions.assertDoesNotThrow(() -> new Users(userNames));
    }

    @DisplayName("참여할 사람의 이름이 중복인 경우 생성되지 않는다.")
    @Test
    void validateDuplicationName() {
        // given
        String names = "jk, jk,pobi,crong,honux";

        // when

        // then
        IllegalArgumentException exception = Assertions.assertThrows(
            IllegalArgumentException.class, () -> new Users(names));
        Assertions.assertEquals("참여자 이름 중에 중복된 이름이 있습니다.", exception.getMessage());
    }
}
