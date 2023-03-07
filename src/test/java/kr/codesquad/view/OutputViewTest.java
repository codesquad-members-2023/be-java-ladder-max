package kr.codesquad.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OutputViewTest {

    @DisplayName("이름을 5글자로 제한한다.")
    @ParameterizedTest
    @CsvSource({"papabear,papab", "albert,alber"})
    void limitName(String target, String expect) {
        Assertions.assertThat(OutputView.limitName(target)).isEqualTo(expect);
    }
}
