package kr.codesquad.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {
    @Test
    @DisplayName("글자 크기 실패 테스트")
    void NameFailTest() {
        Input input = new Input();
        String[] names = {"wisdom", "a", "aa"};

        boolean result = input.validateNames(names);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("글자 크기 성공 테스트")
    void NameSuccessTest() {
        Input input = new Input();
        String[] names = {"pobi", "honux", "crong", "jk"};

        boolean result = input.validateNames(names);

        assertThat(result).isTrue();
    }
}
