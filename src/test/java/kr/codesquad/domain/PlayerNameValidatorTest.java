package kr.codesquad.domain;

import kr.codesquad.util.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerNameValidatorTest {

    Validator validator = new Validator();

    @Test
    @DisplayName("모든 playerName이 5글자 이하일떄 test")
    void parseAndValidateSuccessTest() {
        String input = "Tom,Dean,crong,boy";
        Assertions.assertNotNull(validator.getValidPlayerFromUser(input));
    }

    @Test
    @DisplayName("5글자 이상인 playerName이 존재할때 test")
    void parseAndValidateFailTest() {
        String input = "Tom,Dean,crong,charlie";
        Assertions.assertNull(validator.getValidPlayerFromUser(input));
    }

    @Test
    @DisplayName("player가 1명 이하일때 test")
    void validatePlayerNumFailTest() {
        String input = "Tom";
        Assertions.assertNull(validator.getValidPlayerFromUser(input));
    }


}