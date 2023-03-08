package kr.codesquad.ladder.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NamesTest {

    @Test
    void 생성되는_리스트_사이즈_검증() {
        Names names = Names.createNames(Arrays.asList("a", "b", "c"));

        Assertions.assertThat(names.getSize()).isEqualTo(3);
    }

}
