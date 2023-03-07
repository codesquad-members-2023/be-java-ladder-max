package kr.codesquad.util;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

class InputHandlerTest {

    InputHandler handler = new InputHandler();

    @Test
    @DisplayName("사용자 입력에따른 player 이름을 list의 형태로 가져오는지 test")
    void getPeopleNameFromUserTest() throws IOException {
        String input = "aaaa,bbbbb,ccc";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ArrayList actual = new ArrayList();
        handler.getName(actual);
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("aaaa", "bbbbb", "ccc"));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("사용자 입력에따른 ladderHeight를 잘 가지고 오는지 test")
    void getLadderHeightFromUser() throws IOException {
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int expected = 3;
        int actual = handler.getHeight();

        Assertions.assertEquals(expected, actual);
    }

}