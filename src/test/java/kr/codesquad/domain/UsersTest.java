package kr.codesquad.domain;

import kr.codesquad.exception.user.UsersDuplicationUserNameException;
import kr.codesquad.exception.user.UsersMinSizeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class UsersTest {

    @DisplayName("참여할 사람이 2명 미만일 경우 생성되지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"honux", "crong,", "jk, ", "", " ", " , "})
    void validateMinUserNamesCount(String userNames) {
        // given

        // when

        // then
        Assertions.assertThrows(UsersMinSizeException.class, () -> new Users(userNames));
    }

    @DisplayName("참여할 사람의 이름이 중복인 경우 생성되지 않는다.")
    @Test
    void validateDuplicationName() {
        // given
        String names = "jk, jk,pobi,crong,honux";

        // when

        // then
        Assertions.assertThrows(UsersDuplicationUserNameException.class, () -> new Users(names));
    }

    @DisplayName("참여할 사람이 2명 이상일 경우 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"honux, crong", "crong, jk", " jk , honux "})
    void create(String userNames) {
        // given

        // when

        // then
        Assertions.assertDoesNotThrow(() -> new Users(userNames));
    }

    @ParameterizedTest
    @CsvSource({"honux,0", "crong,1", "jk,2"})
    void findByIndex(String userName, int index) {
        // given
        Users users = new Users("honux,crong,jk");

        // when
        User actual = users.findByIndex(index);

        // then
        Assertions.assertEquals(new User(userName), actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"crong", "jk", "honux", "chloe"})
    void findByName(String userName) {
        // given
        Users users = new Users("honux,crong,jk,chloe");

        // when
        User actual = users.findByName(userName);

        // then
        Assertions.assertEquals(new User(userName), actual);
    }

    @Test
    void count() {
        // given
        Users users = new Users("jk,crong,honux");
        int expected = 3;

        // when
        int actual = users.count();

        // then
        Assertions.assertEquals(expected, actual);
    }
}
