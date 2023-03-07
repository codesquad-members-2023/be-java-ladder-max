package kr.codesquad.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    void 이름_생성성공_유효성_검증() {
        Assertions.assertDoesNotThrow(() -> new Name("abc"));
    }

    @Test
    void 이름_생성실패_유효성_검증() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Name("abcdef"));
    }

    @Test
    void 이름은_6글자로_생성() {
        assertThat(new Name("abc").toString()).isEqualTo(("abc   "));
    }

}