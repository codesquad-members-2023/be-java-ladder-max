package Ladder2.test;


import Ladder2.domain.Participants;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;


class ParticipantsTest {

    @Test
    public void whenWrongInputFormat() {
        String input = "Alice,Bob,Cha,David;";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        try {
            Participants participants = new Participants();
        } catch (Exception e) {
            System.err.println("Participants 생성 실패: " + e.getMessage());
        }
    }

}
