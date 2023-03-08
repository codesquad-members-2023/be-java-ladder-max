package kr.codesquad.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import kr.codesquad.util.NumberGenerator;
import org.junit.jupiter.api.Test;

class LadderMakerTest {

    @Test
    void 사다리_생성_테스트() {
        NumberGenerator numberGenerator = new TestNumberGenerator(List.of(1, 0, 0));
        LadderMaker ladderMaker = new LadderMaker(numberGenerator);
        List<List<String>> ladder = ladderMaker.makeLadder(3, 1);
        assertThat(ladder.get(0)).isEqualTo(List.of("|", "-----", "|", "     ", "|"));
    }

    static class TestNumberGenerator implements NumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return -1;
        }
    }

}

