package kr.codesquad;

import kr.codesquad.domain.Line;
import kr.codesquad.domain.RandomLadderGenerator;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class RandomLadderGeneratorTest {
    @Test
    @DisplayName("랜덤하게 생성시 사다리의 라인은 겹치지 않습니다.")
    public void testRandomGenerate() {
        RandomLadderGenerator generator = new RandomLadderGenerator();
        var ladder = generator.generate(5, 5);

        SoftAssertions softAssertions = new SoftAssertions();
        for (Line line : ladder.getLadder()) {
            for (int i = 1; i < line.size() - 1; i++) {
                // 현재위치와 앞 또는 뒤 위치에 라인이 모두 있는 경우는 없습니다.
                softAssertions.assertThat(line.hasBridge(i)).isTrue()
                        .isNotEqualTo(line.hasBridge(i - 1))
                        .isNotEqualTo(line.hasBridge(i + 1));
            }
        }
    }

    @Test
    @DisplayName("사다리의 마지막 열은 라인이 없습니다.")
    public void testLastRow() {
        RandomLadderGenerator generator = new RandomLadderGenerator();
        var ladder = generator.generate(5, 5);
        for (Line line : ladder.getLadder()) {
            assertFalse(line.hasBridge(4));
        }
    }
}