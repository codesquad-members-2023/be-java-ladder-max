package kr.codesquad.domain;

import kr.codesquad.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerNameValidatorTest {

    Players playerValidator = new Players();
    InputView inputHandler = new InputView();
    ArrayList list = new ArrayList<>();

    @Test
    @DisplayName("모든 playerName이 5글자 이하일떄 test")
    void parseAndValidateSuccessTest() {
        String input = "Tom,Dean,crong,boy";
        assertTrue(playerValidator.getValidPlayerFromUser(input));
    }

    @Test
    @DisplayName("5글자 이상인 playerName이 존재할때 test")
    void parseAndValidateFailTest() {
        String input = "Tom,Dean,crong,charlie";
        assertFalse(playerValidator.getValidPlayerFromUser(input));
    }

    @Test
    @DisplayName("player가 1명 이하일때 test")
    void validatePlayerNumFailTest() {
        String input = "Tom";
        assertFalse(playerValidator.getValidPlayerFromUser(input));
    }


}