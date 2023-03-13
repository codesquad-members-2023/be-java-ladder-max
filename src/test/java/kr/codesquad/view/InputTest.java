package kr.codesquad.view;

import kr.codesquad.domain.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {
    @Test
    @DisplayName("글자 크기 실패 테스트")
    void NameFailTest() {
        Validator validator = new Validator();
        String[] names = {"wisdom", "a", "aa"};

        boolean result = validator.validateNames(names);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("글자 크기 성공 테스트")
    void NameSuccessTest() {
        Validator validator = new Validator();
        String[] names = {"pobi", "honux", "crong", "jk"};

        boolean result = validator.validateNames(names);

        assertThat(result).isTrue();
    }
}
