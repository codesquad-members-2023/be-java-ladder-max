package kr.codesquad;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class ScreenTest {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUpBefore() {
    }

    @AfterEach
    void setUpAfter() {
        outputStream = new ByteArrayOutputStream();
    }

    @MethodSource(value = "inputInvalidData")
    @DisplayName("다리 높이 테스트")
    @ParameterizedTest(name = "input = {0}, error message = {1}")
    public void inputLadderHeightTest(String input, String errorMessage) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStream));

        // Screen의 scanner를 static final로 선언하니 처음 테스트만 통과
        // 내가 테스트에서 inputStream을 계속 생성해도 처음에 생성된 Scanner에 주입된 inputStream이 등록이 되어 있어서 실패하는 것 같다.
        // 그래서 System.setIn()을 계속 바꿔도 전역으로 생성된 Scanner에는 맨 처음 inputStream이 주입 되어 있는 상태

        final Screen screen = new Screen();

        // Screen 생성을 밖에서 하면 무한 루프..?
        // System.setIn()으로 내가 사용할 InputStream을 주입하기 전에 Screen을 생성하면
        // Scanner에 교체하기전 실제 System.in이 주입되기 떄문에 계속 입력을 대기하는 상태가 되는 것 같다.

        assertThatThrownBy(screen::inputLadderHeight).isInstanceOf(NoSuchElementException.class);

        assertThat(outputStream.toString()).contains(errorMessage);

    }

    public static Stream<Arguments> inputInvalidData() {
        return Stream.of(
                Arguments.of("-10", "0보다 큰 숫자를 입력해 주세요."),
                Arguments.of("0", "0보다 큰 숫자를 입력해 주세요."),
                Arguments.of("a", "숫자를 입력해주세요.")
        );
    }

}