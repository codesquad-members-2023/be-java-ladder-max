package kr.codesquad.domain;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.data.MapEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static kr.codesquad.domain.LadderPart.*;
import static org.assertj.core.api.Assertions.*;

class LadderTest {
    private List<LadderLine> ladderLines;

    @BeforeEach
    void setUp() {
        ladderLines = List.of(
                new LadderLine(List.of(BAR, BRIDGE, BAR, EMPTY, BAR)),
                new LadderLine(List.of(BAR, EMPTY, BAR, BRIDGE, BAR)),
                new LadderLine(List.of(BAR, BRIDGE, BAR, EMPTY, BAR))
        );
    }

    @DisplayName("사다리 생성 시 라인의 길이가 일정하면 성공적으로 생성이 된다.")
    @Test
    void LadderCreateSuccessTest() {
        assertThatNoException().isThrownBy(() -> new Ladder(ladderLines));
    }

    @DisplayName("사다리 생성 시 라인의 길이가 다르면 IllegalArgumentException 예외가 발생한다.")
    @Test
    void LadderCreateFailTest() {
        final List<LadderLine> ladderLines = List.of(
                new LadderLine(List.of(BAR, BRIDGE, BAR, EMPTY, BAR)),
                new LadderLine(List.of(BAR, BRIDGE, BAR))
        );

        assertThatThrownBy(() -> new Ladder(ladderLines))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리 모양을 List로 한줄씩 담아서 반환할 수 있다.")
    @Test
    void LadderOutputLinesTest() {
        final Ladder ladder = new Ladder(ladderLines);
        final List<String> expectOutputLines = toOutputLines(ladderLines);

        final List<String> outputLines = ladder.createOutputLines();


        assertThat(outputLines).isEqualTo(expectOutputLines);
    }

    private List<String> toOutputLines(List<LadderLine> ladderLines) {
        return ladderLines.stream()
                .map(LadderLine::toString)
                .collect(Collectors.toList());
    }

    @DisplayName("사다리 결과 생성시 올바르게 매칭이 된다.")
    @Test
    void makeResultTest() {
        final Ladder ladder = new Ladder(ladderLines);
        final Map<Integer, Integer> results = ladder.makeResult().stream()
                .collect(Collectors.toMap(Point::getStartLadderNumber, Point::getFinalLadderNumber));

        assertThat(results).hasSize(3).contains(
                entry(0, 2),
                entry(1, 1),
                entry(2, 0)
        );
    }
}