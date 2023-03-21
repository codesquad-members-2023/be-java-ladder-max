package kr.codesquad.domain;

import kr.codesquad.util.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LadderHeightValidatorTest {

    Validator validator = new Validator();

    @Test
    @DisplayName("사다리 높이가 >0 일때 test")
    void heightValidateSuccessTest() {
        int input = 10;
        assertTrue(validator.getValidHeightFromUser(input));
    }

    @Test
    @DisplayName("사다리 높이가 <1 일때 test")
    void heightValidateFailTest() {
        int input = -1;
        assertFalse(validator.getValidHeightFromUser(input));
    }
}