package kr.codesquad;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import kr.codesquad.message.ErrorMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//TODO: args의 2번째 값이 인식이 안된다.

class InputExceptionTest {

    @AfterEach
    void resetInputStream() {
        System.setIn(new ByteArrayInputStream(new byte[0]));
    }

    @Test
    @DisplayName("플레이어 이름 미입력 시 예외 발생")
    void emptyInputTest1() {
        //given
        String[] args = {"", "3"}; //

        byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        //then
        IllegalArgumentException ie = assertThrows(IllegalArgumentException.class, () -> Main.main(args));
        assertEquals(ErrorMessage.INPUT_IS_EMPTY_ERROR.toString(), ie.getMessage());
    }

    @Test
    @DisplayName("플레이어 이름 미입력 시 예외 발생")
    void emptyInputTest2() {
        //given
        String[] args = {"aaa, , ccc", "3"};

        byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        //then
        IllegalArgumentException ie = assertThrows(IllegalArgumentException.class, () -> Main.main(args));
        assertEquals(ErrorMessage.INPUT_IS_EMPTY_ERROR.toString(), ie.getMessage());
    }

    @Test
    @DisplayName("플레이어 이름을 6자 이상 입력 시 예외 발생")
    void playerNameLengthTest() {
        //given
        String[] args = {"이름이6글자, 3글자", "3"};

        byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        //then
        IllegalArgumentException ie = assertThrows(IllegalArgumentException.class, () -> Main.main(args));
        assertEquals(ErrorMessage.INVALID_NAME_LENGTH.toString(), ie.getMessage());
    }

    @Test
    @DisplayName("플레이어 이름을 쉼표로 구분하지 않았을 때 예외 발생")
    void delimiterTest() {
        //given
        String[] args = {"a;b", "3"};

        byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        //then
        IllegalArgumentException ie = assertThrows(IllegalArgumentException.class, () -> Main.main(args));
        assertEquals(ErrorMessage.INVALID_NAME_DELIMITER.toString(), ie.getMessage());
    }

    @Test
    @DisplayName("플레이어가 1명만 참가했을 때 예외가 발생한다.")
    void numberOfPlayerTest() {
        //TODO: 쉼표로 구분이 안돼서 "쉼표 없는 예외"가 발생하는데 따로 처리를 해야할지?
    }

    @Test
    @DisplayName("플레이어 이름이 중복되었을 때 예외가 발생한다.")
    void duplicatedNameTest() {
        //given
        String[] args = {"aaa, aaa", "3"};

        byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        //then
        IllegalArgumentException ie = assertThrows(IllegalArgumentException.class, () -> Main.main(args));
        assertEquals(ErrorMessage.DUPLICATED_PLAYER_NAME.toString(), ie.getMessage());
    }
}
