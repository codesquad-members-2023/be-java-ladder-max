package kr.codesquad.util;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class LadderRandomNumberGeneratorTest {

    @RepeatedTest(10000)
    @DisplayName("0과 1만 출력되는지 테스트")
    void test() {
        NumberGenerator numberGenerator = new LadderRandomNumberGenerator();
        int number = numberGenerator.generate();
        Assertions.assertThat(number).isIn(List.of(0, 1));
    }

}
