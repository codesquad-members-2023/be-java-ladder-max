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
    InputView inputHandler = new InputView();
    Integer height;
    @Test
    @DisplayName("사다리 높이가 >0 일때 test")
    void heightValidateSuccessTest(){
        String input = "10";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertTrue(heightValidator.getValidHeightFromUser(height,inputHandler));
    }

    @Test
    @DisplayName("사다리 높이가 <1 일때 test")
    void heightValidateFailTest(){
        String input = "-1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertFalse(heightValidator.getValidHeightFromUser(height,inputHandler));
    }
}