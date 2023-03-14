package kr.codesquad.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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