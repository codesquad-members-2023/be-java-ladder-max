package kr.codesquad;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final String RUNG = "=".repeat(5);
    private static final String BLANK = " ".repeat(5);
    private static final String POLE = "|";
    private final List<Boolean> line;
    private final int width;

    public Line (List<Boolean> line) {
        this.line = line;
        this.width = line.size();
    }

    public String drawLine() {
        StringBuilder sb = new StringBuilder();

        sb.append(POLE);
        for (Boolean rung : line) {
            sb.append(drawRung(rung));
            sb.append(POLE);
        }
        return sb.toString();
    }

    private String drawRung(boolean rung) {
        if (rung) {
            return RUNG;
        }
        return BLANK;
    }
}
