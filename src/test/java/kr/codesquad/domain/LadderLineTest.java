package kr.codesquad.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static kr.codesquad.domain.Direction.*;
import static kr.codesquad.domain.LadderPart.*;
import static org.assertj.core.api.Assertions.*;

class LadderLineTest {
    @DisplayName("잘못된 사다리 라인 생성 시 예외가 발생한다.")
    @MethodSource("invalidLadderLineParts")
    @ParameterizedTest()
    void ladderLineConnectBridgeExceptionTest(List<LadderPart> ladderParts) {
        System.out.println("\"" + toShape(ladderParts) + "\"");

        assertThatThrownBy(() -> new LadderLine(ladderParts)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리 라인은 현재 위치 Point에서 이동 가능한 방향 Direction을 반환한다.")
    @Test
    void findDirectionTest() {
        final LadderLine ladderLine = new LadderLine(List.of(BAR, EMPTY, BAR, BRIDGE, BAR));
        final int parts = ladderLine.getSumParts();
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < parts; i++) {
            points.add(new Point(i));
        }

        assertThatStream(points.stream())
                .map(ladderLine::findCanMoveDirection)
                .containsExactly(NONE, NONE, RIGHT, NONE, LEFT);

    }

    static Stream<Arguments> invalidLadderLineParts() {
        return Stream.of(
                Arguments.of(List.of(BAR, BRIDGE, BAR, BRIDGE, BAR)),
                Arguments.of(List.of(BRIDGE, BAR, BAR, EMPTY, BAR)),
                Arguments.of(List.of(BAR, BRIDGE, EMPTY, EMPTY, BAR)),
                Arguments.of(List.of(BAR, EMPTY, BAR, BRIDGE))
        );
    }

    public String toShape(List<LadderPart> ladderParts) {
        return ladderParts.stream()
                .map(LadderPart::toString)
                .collect(Collectors.joining());
    }
}