package kr.codesquad.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InputParserTest {

    InputParser inputParser = new InputParser();

    @Test
    @DisplayName("validate(글자크기 5글자 이하)성공 테스트")
    void parseAndValidateSuccessTest(){
        ArrayList<String> listForTest = new ArrayList<>();
        String strForTest = "Tom,Dean,crong";

        assertTrue(inputParser.parseAndValidate(listForTest,strForTest));
    }

    @Test
    @DisplayName("validate(글자크기 5글자 이하)실패 테스트")
    void parseAndValidateFailTest(){
        ArrayList<String> listForTest = new ArrayList<>();
        String strForTest = "Tom,Dean,crong,charlie";

        assertFalse(inputParser.parseAndValidate(listForTest,strForTest));
    }

}