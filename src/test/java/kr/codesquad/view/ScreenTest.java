package kr.codesquad.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.Optional;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

class ScreenTest {
    @DisplayName("사다리 높이 입력 테스트")
    @ValueSource(strings = {"1", "2"})
    @ParameterizedTest
    void inputLadderHeightTest(String inputLadderHeight) {
        //given
        int expectLadderHeight = Integer.parseInt(inputLadderHeight);
        final ByteArrayInputStream testInputStream = new ByteArrayInputStream(inputLadderHeight.getBytes());

        System.setIn(testInputStream);
        final Screen screen = new Screen(new Scanner(System.in));

       //when
        final Optional<Integer> ladderHeight = screen.inputLadderHeight();

        //then
        assertThat(ladderHeight).isPresent().get().isEqualTo(expectLadderHeight);
    }
}