package kr.codesquad;

import kr.codesquad.domain.RandomBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RandomBooleanGeneratorTest{
    @Test
    @DisplayName("입력한 길이의 list를 생성하는지 확인")
    void lengthTest() {
        RandomBooleanGenerator rbg = new RandomBooleanGenerator();
        List<Boolean> randomBoolean = rbg.generate(10);
        assertThat(randomBoolean.size()).isEqualTo(10);
    }

    @Test
    @DisplayName("True가 연속되어 있는지 확인")
    void continuityTest() {
        RandomBooleanGenerator rbg = new RandomBooleanGenerator();
        List<Boolean> randomBoolean = rbg.generate(10);
        assertThat(randomBoolean).doesNotContainSequence(true, true);
    }
}