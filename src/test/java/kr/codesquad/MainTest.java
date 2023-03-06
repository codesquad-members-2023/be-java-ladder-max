package kr.codesquad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntGgomTest {

    @Test
    void plus() {
        int result = IntGgom.plus(2,3);
        assertEquals(5, result);
    }
}