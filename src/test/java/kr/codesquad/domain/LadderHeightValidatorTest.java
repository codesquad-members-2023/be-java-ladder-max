package kr.codesquad.domain;

import kr.codesquad.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LadderHeightValidatorTest {

    LadderHeight heightValidator = new LadderHeight();
    Integer height;
    @Test
    @DisplayName("사다리 높이가 >0 일때 test")
    void heightValidateSuccessTest(){
        int input = 10;
        assertTrue(heightValidator.getValidHeightFromUser(input));
    }

    @Test
    @DisplayName("사다리 높이가 <1 일때 test")
    void heightValidateFailTest(){
        int input = -1;
        assertFalse(heightValidator.getValidHeightFromUser(input));
    }
}