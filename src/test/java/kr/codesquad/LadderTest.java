package kr.codesquad;

import kr.codesquad.domain.Ladder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LadderTest {
    private final Ladder ladder = new Ladder();

    @BeforeEach
    void initializeTest() {
        ladder.addLine(List.of(true, false, false, true));
        ladder.addLine(List.of(false, false, true, false));
    }

    @Test
    @DisplayName("Ladder에 새로운 줄을 추가하는 것이 잘 되는지 확인")
    void addLineTest() {
        ladder.addLine(List.of(true, true, true, true));
        assertThat(ladder.getLadderSize()).isEqualTo(3);
    }

    @Test
    @DisplayName("Ladder의 모양이 String으로 잘 변환되는지 확인")
    void drawLadderTest() {
        String figure = ladder.drawLadder();
        assertThat(figure).isEqualTo("|=====|     |     |=====|\n|     |     |=====|     |\n");
    }
}