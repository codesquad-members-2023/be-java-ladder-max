package kr.codesquad.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @DisplayName("숫자가 맞다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "20", "300", "475"})
    void isDigitTrue(String input) {
        Assertions.assertThat(InputView.isDigit(input)).isTrue();
    }
    @DisplayName("숫자가 아니다")
    @ParameterizedTest
    @ValueSource(strings = {"01", "sfa", "s32", "0-0"})
    void isDigitFalse(String input) {
        Assertions.assertThat(InputView.isDigit(input)).isFalse();
    }

    @DisplayName("이름패턴에 매치된다")
    @ParameterizedTest
    @ValueSource(strings = {"jack,john", "fia,june,jk"})
    void isRightNamesPattern_True(String input) {
        InputView inputView = new InputView();
        Assertions.assertThat(inputView.isRightNamesPattern(input)).isTrue();
    }
    @DisplayName("이름패턴에 매치 안된다")
    @ParameterizedTest
    @ValueSource(strings = {"jack1,john", "fia!june,jk"})
    void isRightNamesPattern_False(String input) {
        InputView inputView = new InputView();
        Assertions.assertThat(inputView.isRightNamesPattern(input)).isFalse();
    }
    @DisplayName("결과 패턴에 매치 된다")
    @ParameterizedTest
    @ValueSource(strings = {"꽝,5000,꽝", "꽝,5000,2000,1000"})
    void isRightResultPattern_True(String input) {
        InputView inputView = new InputView();
        Assertions.assertThat(inputView.isRightResultPattern(input)).isTrue();

    }

    @DisplayName("결과 패턴에 매치 안된다")
    @ParameterizedTest
    @ValueSource(strings = {"꽁,5000,꽝", "깡,5000,2000,1000"})
    void isRightResultPattern_Fail(String input) {
        InputView inputView = new InputView();
        Assertions.assertThat(inputView.isRightResultPattern(input)).isFalse();
    }
}
