package kr.codesquad.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setInputView() {
        inputView = new InputView();
    }

    @DisplayName("숫자가 맞다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "20", "300", "475"})
    void isDigitTrue(String input) {
        assertThat(InputView.isDigit(input)).isTrue();
    }

    @DisplayName("숫자가 아니다")
    @ParameterizedTest
    @ValueSource(strings = {"01", "sfa", "s32", "0-0"})
    void isDigitFalse(String input) {
        assertThat(InputView.isDigit(input)).isFalse();
    }

    @DisplayName("이름패턴에 매치 된다")
    @ParameterizedTest
    @ValueSource(strings = {"jack,john", "fia,june,jk"})
    void isRightNamesPattern_True(String input) {
        assertThat(inputView.isRightNamesPattern(input)).isTrue();
    }

    @DisplayName("이름패턴에 매치 안된다")
    @ParameterizedTest
    @ValueSource(strings = {"jack1,john", "fia!june,jk"})
    void isRightNamesPattern_False(String input) {
        assertThat(inputView.isRightNamesPattern(input)).isFalse();
    }

    @DisplayName("결과 패턴에 매치 된다")
    @ParameterizedTest
    @ValueSource(strings = {"꽝,5000,꽝", "꽝,5000,2000,1000"})
    void isRightResultPattern_True(String input) {
        assertThat(inputView.isRightResultInfoPattern(input)).isTrue();
    }

    @DisplayName("결과 패턴에 매치 안된다")
    @ParameterizedTest
    @ValueSource(strings = {"꽁,5000,꽝", "깡,5000,2000,1000"})
    void isRightResultPattern_Fail(String input) {
        assertThat(inputView.isRightResultInfoPattern(input)).isFalse();
    }

    @DisplayName("close 명령 체크")
    @ParameterizedTest
    @CsvSource({"춘식이,true", "춘식,false"})
    void isClose(String input, boolean flag) {
        assertThat(InputView.isClose(input)).isEqualTo(flag);
    }

    @DisplayName("all 명령 체크")
    @ParameterizedTest
    @CsvSource({"all,true", "allr,false"})
    void isSearchAll(String input, boolean flag) {
        assertThat(InputView.isSearchAll(input)).isEqualTo(flag);
    }
}
