package kr.codesquad.util;

import kr.codesquad.domain.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidationTest {

    Validation validation = new Validation();

    @Test
    @DisplayName("이름을 문자열로 입력")
    void checkNameString() throws IOException {
        // given
//        String names = "pobi,honux,crong,jk";
//        Users users = validation.validateInputNames(names);

        // when
//        List<String> namesToCompare = List.of("pobi", "honux", "crong", "jk");

        // then
//        assertThat(inputNames).isEqualTo(namesToCompare);
    }

    @Test
    @DisplayName("이름이 문자열이 아니면 에러")
    void checkNameStringError() {
        // given
        String names = "pobi,honux,crong,jk111";
        // when
        // then
        assertThrows(IOException.class, () -> {
            validation.validateInputNames(names);
        });
    }

    @Test
    @DisplayName("이름 길이가 5를 넘으면 에러")
    void checkNameSizeError() {
        // given
        String names = "pobipo,honux,crong,jk";

        // when
        // then
        assertThrows(IOException.class, () -> validation.validateInputNames(names));
    }

    @Test
    @DisplayName("사다리 개수 입력하기")
    void checkLadderNumber() {
        // given
        String beforeInput = "5";
        int afterInput = validation.validateInputLadderNumber(beforeInput);

        // when
        int inputToCompare = 5;

        // then
        assertThat(afterInput).isEqualTo(inputToCompare);
    }

    @Test
    @DisplayName("사다리 개수가 양수가 아니면 에러")
    void checkLadderNumberPositive() {
        // given
        String beforeInput = "-1";

        // when
        // then
        assertThrows(NumberFormatException.class, () -> validation.validateInputLadderNumber(beforeInput));
    }

    @Test
    @DisplayName("사다리 개수가 정수가 아니면 에러")
    void checkLadderNumberInteger() {
        // given
        String beforeInput = "0.25";
        // when
        // then
        assertThrows(NumberFormatException.class, () -> validation.validateInputLadderNumber(beforeInput));
    }
}