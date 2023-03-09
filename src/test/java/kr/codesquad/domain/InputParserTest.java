package kr.codesquad.domain;

import org.assertj.core.api.Assertions;
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

        //org.junit.jupiter.api.Assertions 로 테스트
        assertFalse(inputParser.parseAndValidate(listForTest,strForTest));

        //org.assertj.core.api.Assertions 으로 테스트
        Assertions.assertThat(inputParser.parseAndValidate(listForTest,strForTest)).isFalse();
    }
}