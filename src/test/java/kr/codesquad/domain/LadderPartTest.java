package kr.codesquad.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderPartTest {

    @DisplayName("LadderPart 랜덤 생성 테스트")
    @Test
    void createRandomPartTest() {
        int bridgeCount = 0;
        int emptyCount = 0;

        for (int i = 0; i < 100; i++) {
            LadderPart ladderPart = LadderPart.makeRandomBridge();
            if (ladderPart == LadderPart.BRIDGE) {
                ++bridgeCount;
            }
            if (ladderPart == LadderPart.EMPTY) {
                ++emptyCount;
            }
        }

        assertThat(bridgeCount).isNotZero();
        assertThat(emptyCount).isNotZero();
    }
}