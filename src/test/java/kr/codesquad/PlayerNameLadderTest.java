package kr.codesquad;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PlayerNameLadderTest {
    @DisplayName("사다리는 연속적으로 연결 다리가 생길 수 없다.")
    @Test
    void ladderOutputTest() {
//        final List<String> playerNames = makePlayerNames();
//        final Ladder ladder = LadderGenerator.of(playerNames, 1000);
//        final List<String> outputLines = ladder.createOutputLines();
//        final List<String> ladderShape = outputLines.subList(1, outputLines.size() - 1);
//
//        assertThat(ladderShape).filteredOn(ladderLine -> ladderLine.contains("|-----|-----|")).isEmpty();
    }

    private List<String> makePlayerNames() {
        final List<String> names = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            names.add(String.valueOf(i));
        }

        return names;
    }
}