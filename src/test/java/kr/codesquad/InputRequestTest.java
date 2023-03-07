package kr.codesquad;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputRequestTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "20", "300", "475"})
    void isDigitTrue(String input) {
        Assertions.assertThat(InputRequest.isDigit(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"01", "sfa", "s32", "0-0"})
    void isDigitFalse(String input) {
        Assertions.assertThat(InputRequest.isDigit(input)).isFalse();
    }


    @ParameterizedTest
    @ValueSource(strings = {"jack,john", "fia,june,jk"})
    void isRightNamesPattern_True(String input) {
        InputRequest inputRequest = new InputRequest();
        Assertions.assertThat(inputRequest.isRightNamesPattern(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"jack1,john", "fia!june,jk"})
    void isRightNamesPattern_False(String input) {
        InputRequest inputRequest = new InputRequest();
        Assertions.assertThat(inputRequest.isRightNamesPattern(input)).isFalse();
    }
}
