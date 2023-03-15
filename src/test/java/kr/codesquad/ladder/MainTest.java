package kr.codesquad.ladder;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    @DisplayName("통합 테스트")
    public void mainTest() {
        //given
        String input = "pobi,honux,crong,jk\n꽝,5000,꽝,3000\n5\npobi\nall\n춘식이";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        //when
        Main.main(new String[0]);
        //then
    }
}
