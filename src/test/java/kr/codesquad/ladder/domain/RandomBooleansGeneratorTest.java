package kr.codesquad.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomBooleansGeneratorTest {

    private final RandomBooleansGenerator randomBooleansGenerator = new RandomBooleansGenerator();

    @Test
    void 생성되는_리스트_사이즈_검증() {
        List<Boolean> booleans = randomBooleansGenerator.createRandomBooleans(5);

        assertThat(booleans.size()).isEqualTo(5);
    }

}
