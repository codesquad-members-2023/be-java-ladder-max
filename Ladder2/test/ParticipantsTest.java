package Ladder2.test;


import Ladder2.domain.Name;
import Ladder2.domain.Participants;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ParticipantsTest {

    @Test
    public void whenWrongInputFormat() {
        String input = "Alice,Bob,Cha,David;";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        assertThrows(IllegalArgumentException.class, () -> {
            Participants participants = new Participants();
        });
    }

    @Test
    public void whenTooLongName() {
        String input = "Alicia,Bob,Cha,David";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        assertThrows(IllegalArgumentException.class, () -> {
            Participants participants = new Participants();
        });
    }

    @Test
    public void whenCorrectNames() throws IOException {
        String input = "Alice,Bob,Cha,David";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        List<String> expected = Arrays.asList(
                new Name("Alice").getName(),
                new Name("Bob").getName(),
                new Name("Cha").getName(),
                new Name("David").getName()
        );
        Participants participants = new Participants();
        List<Name> participantsNames = participants.getNames();
        List<String> actual = new ArrayList<>();
        for(Name name : participantsNames){
            actual.add(name.getName());
        }
        assertEquals(expected, actual);
    }



}
