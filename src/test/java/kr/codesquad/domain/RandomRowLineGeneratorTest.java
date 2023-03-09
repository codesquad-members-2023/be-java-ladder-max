package kr.codesquad.domain;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RandomRowLineGeneratorTest {

    @DisplayName("가로 사다리 라인이 곁치지 않도록 생성된다.")
    @ParameterizedTest
    @CsvSource({"2,1", "3,2", "4,3", "5,4"})
    void generate(int numberOfUsers, int expected) {
        // given
        RandomRowLineGenerator randomRowLineGenerator = new RandomRowLineGenerator(numberOfUsers);

        // when
        List<Boolean> actual = randomRowLineGenerator.generate();

        // then
        Assertions.assertEquals(expected, actual.size());
        IntStream.range(1, actual.size())
            .forEach(index -> {
                if (actual.get(index - 1)) {
                    Assertions.assertFalse(actual.get(index));
                }
            });
    }
}
