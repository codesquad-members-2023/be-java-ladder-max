package kr.codesquad.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LadderTest {

//    @DisplayName("플레이어 수 또는 다리 높이가 0 이하면 생성되지 않는다.")
//    @MethodSource(value = "invalidParams")
//    @ParameterizedTest(name = "플레이어 수 : {0}, 다리 높이 : {1}")
//    void createLadderFailTest(int playerNumber, int height) {
//        assertThatThrownBy(() -> new Ladder(playerNumber, height))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @DisplayName("유효한 플레이어 수, 다리 높이에 따라 사다리가 성공적으로 생성이 된다.")
//    @MethodSource(value = "validParams")
//    @ParameterizedTest(name = "플레이어 수 : {0}, 다리 높이 : {1}")
//    void createOutputLinesTest(int playerNumber, int height) {
//        try (final MockedStatic<LadderPart> ladderPartMockedStatic = mockStatic(LadderPart.class)) {
//            when(LadderPart.makeRandomBridge()).thenReturn(LadderPart.EMPTY);
//
//            final Ladder ladder = new Ladder(playerNumber, height);
//
//            final List<String> outputLines = ladder.createOutputLines();
//
//            List<String> expectOutputLines = new ArrayList<>();
//            for (int i = 0; i < height; i++) {
//                expectOutputLines.add(makeExpectOutputLine(playerNumber));
//            }
//
//            System.out.println("실제 결과");
//            System.out.println(String.join("\n", outputLines));
//            System.out.println("예상 결과");
//            System.out.println(String.join("\n", expectOutputLines));
//
//            assertThat(outputLines.toString()).isEqualTo(expectOutputLines.toString());
//        }
//    }
//
//    private String makeExpectOutputLine(int playerNumber) {
//        StringBuilder builder = new StringBuilder();
//
//        builder.append(LadderPart.BAR);
//        for (int i = 0; i < playerNumber - 1; i++) {
//            builder.append(LadderPart.EMPTY).append(LadderPart.BAR);
//        }
//
//        return builder.toString();
//    }
//
//    static Stream<Arguments> invalidParams() {
//        return Stream.of(
//                Arguments.of(-5, -5),
//                Arguments.of(-1, 1),
//                Arguments.of(1, -1),
//                Arguments.of(0, 1),
//                Arguments.of(1, 0)
//        );
//    }
//
//    static Stream<Arguments> validParams() {
//        return Stream.of(
//                Arguments.of(5, 5),
//                Arguments.of(10, 10),
//                Arguments.of(20, 20)
//        );
//    }
}
