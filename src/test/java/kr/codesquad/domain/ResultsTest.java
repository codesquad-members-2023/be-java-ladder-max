package kr.codesquad.domain;

import kr.codesquad.exception.result.ResultsMinResultCountException;
import kr.codesquad.exception.result.ResultsSameUserCountException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ResultsTest {

    @DisplayName("실행 결과의 갯수와 참여할 사람 수가 같지 않는 경우 생성 되지 않는다.")
    @Test
    void validateSameUserCount() {
        // given

        // when

        // then
        Assertions.assertThrows(ResultsSameUserCountException.class
            , () -> new Results("꽝,5000,꽝,3000", 3));
    }

    @DisplayName("실행 결과의 갯수가 2개 미만인 경우 생성 되지 않는다.")
    @Test
    void validateMinResultCount() {
        // given

        // when

        // then
        Assertions.assertAll(
            () -> Assertions.assertThrows(ResultsMinResultCountException.class
            , () -> new Results("꽝", 1)),
            () -> Assertions.assertThrows(ResultsMinResultCountException.class
                , () -> new Results("", 0)));
    }

    @DisplayName("실행 결과의 갯수와 참여할 사람 수가 같은 경우 생성된다.")
    @Test
    void create() {
        // given

        // when

        // then
        Assertions.assertDoesNotThrow(() -> new Results("꽝,5000,꽝,3000", 4));
    }

    @ParameterizedTest
    @CsvSource({"꽝,0", "5000,1", "꽝,2", "3000,3"})
    void findByIndex(String result, int index) {
        // given
        Results results = new Results("꽝,5000,꽝,3000", 4);

        // when
        Result actual = results.findByIndex(index);

        // then
        Assertions.assertEquals(new Result(result), actual);
    }
}
