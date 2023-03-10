package Ladder2.test;

import Ladder2.domain.Ladder;
import Ladder2.domain.LadderRow;
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

public class LadderRowTest {

    @Test
    public void checkContinuousLine() throws IOException {
        LadderRow ladderRow = new LadderRow(4);
        boolean continuousLineFound = false;
        String actualLine = ladderRow.toString();
        for (int i = 1; i < actualLine.length() - 1; i++) {
            if (actualLine.charAt(i) == '|' && actualLine.charAt(i - 1) == '-' && actualLine.charAt(i + 1) == '-') {
                continuousLineFound = true;
                break;
            }
        }
        assertFalse(continuousLineFound);
    }
}
