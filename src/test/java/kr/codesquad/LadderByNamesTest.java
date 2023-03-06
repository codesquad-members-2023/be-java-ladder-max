package kr.codesquad;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LadderByNamesTest {

    @Test
    void create() {
        LadderByNames ladder = new LadderByNames();

        String result = ladder.create(4, 5, () -> true);
        Assertions.assertThat(result).isEqualTo(
            "|-----|     |-----|\n"
                + "|-----|     |-----|\n"
                + "|-----|     |-----|\n"
                + "|-----|     |-----|\n"
                + "|-----|     |-----|\n"
        );
    }
}
