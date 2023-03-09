package kr.codesquad;

import kr.codesquad.domain.Ladder;
import kr.codesquad.service.LadderGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PlayerNameLadderTest {
    @DisplayName("사다리는 연속적으로 연결 다리가 생길 수 없다.")
    @RepeatedTest(value = 5)
    void ladderOutputTest() {
        final LadderGenerator ladderGenerator = new LadderGenerator();
        final Ladder ladder = ladderGenerator.generate(100, 100);
        final List<String> outputLines = ladder.createOutputLines();

        assertThat(outputLines).filteredOn(ladderLine -> ladderLine.contains("|-----|-----|")).isEmpty();
    }
}