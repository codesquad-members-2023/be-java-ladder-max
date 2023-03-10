package kr.codesquad.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import static kr.codesquad.domain.LadderPart.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("LadderLine 테스트")
class LadderLineTest {

    @DisplayName("플레이어 수만큼 BAR('|')를 가진다.")
    @ValueSource(ints = {2, 5, 10, 100})
    @ParameterizedTest(name = "플레이어 수 : {0}")
    void createLadderLineTest(int playerNumber) {
        try (final MockedStatic<LadderPart> ladderPartMockedStatic = mockStatic(LadderPart.class)) {
            when(makeRandomBridge()).thenReturn(EMPTY);

            final LadderLine ladderLine = new LadderLine(playerNumber);
            final StringBuilder expectLadderLineShape = new StringBuilder();

            expectLadderLineShape.append(BAR);
            for (int i = 0; i < playerNumber - 1; i++) {
                expectLadderLineShape.append(EMPTY).append(BAR);
            }

            assertThat(ladderLine.toString()).isEqualTo(expectLadderLineShape.toString());
        }
    }

    @DisplayName("연속된 다리는 생성되지 않는다.")
    @ValueSource(ints = {100, 200, 500, 1000})
    @ParameterizedTest(name = "플레이어 수 : {0}")
    void ladderLineConnectBridgeTest(int playerNumber) {
        final LadderLine ladderLine = new LadderLine(playerNumber);

        assertThat(ladderLine.toString()).doesNotContain("" + BRIDGE + BAR + BRIDGE);
    }

    @DisplayName("플레이어 수가 1보다 작으면 생성되지 않는다.")
    @ValueSource(ints = {-10, 0})
    @ParameterizedTest(name = "플레이어 수 : {0}")
    void createFailInvalidPlayerNumberTest(int playerNumber) {
        assertThatThrownBy(() -> new LadderLine(playerNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}