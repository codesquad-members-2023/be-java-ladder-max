package kr.codesquad.domain;

import kr.codesquad.exception.result.ResultMaxLengthException;
import kr.codesquad.exception.result.ResultMinLengthException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ResultTest {


    @DisplayName("결과는 5글자 초과할 경우 생성되지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"10만원 당첨", "100000"})
    void validateMaxLength(String result) {
        // given

        // when

        // then
        Assertions.assertThrows(ResultMaxLengthException.class
            , () -> new Result(result));
    }

    @DisplayName("결과는 1글자 미만할 경우 생성되지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void validateMinLength(String result) {
        // given

        // when

        // then
        Assertions.assertThrows(ResultMinLengthException.class
            , () -> new Result(result));
    }

    @DisplayName("결과는 1글자 이상 5글자 이하인 경우 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"꽝", "5만원당첨", "5만원 당첨", "당첨", "3만원", "밥값내기"})
    void create(String result) {
        // given

        // when

        // then
        Assertions.assertDoesNotThrow(() -> new Result(result));
    }
}
