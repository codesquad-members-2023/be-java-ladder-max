package kr.codesquad.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static kr.codesquad.domain.LadderPart.*;
import static org.assertj.core.api.Assertions.*;

class LadderLineTest {
    @DisplayName("연속된 다리 생성시 예외가 발생한다.")
    @Test
    void ladderLineConnectBridgeExceptionTest() {
        final List<LadderPart> ladderParts = List.of(BAR, BRIDGE, BAR, BRIDGE, BAR);

        assertThatThrownBy(() -> new LadderLine(ladderParts)).isInstanceOf(IllegalArgumentException.class);
    }
}